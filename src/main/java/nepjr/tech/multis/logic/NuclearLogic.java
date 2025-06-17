package nepjr.tech.multis.logic;

import static gregtech.api.capability.GregtechDataCodes.BOILER_HEAT;
import static gregtech.api.capability.GregtechDataCodes.BOILER_LAST_TICK_STEAM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTTransferUtils;
import gregtech.common.ConfigHolder;
import nepjr.tech.materials.NepMaterials;
import nepjr.tech.multis.NuclearReactor;
import nepjr.tech.recipes.NepRecipeMaps;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class NuclearLogic extends AbstractRecipeLogic {

    private static final long STEAM_PER_WATER = 160;

    private int currentHeat;
    private int lastTickSteamOutput;
    private int excessWater, excessFuel, excessProjectedEU;
    
    private ItemStack wasteByproduct = ItemStack.EMPTY;

    public NuclearLogic(NuclearReactor tileEntity) {
        super(tileEntity, null);
        this.fluidOutputs = Collections.emptyList();
        this.itemOutputs = NonNullList.create();
    }

    @Override
    public void update() {
        if ((!isActive() || !canProgressRecipe() || !isWorkingEnabled()) && currentHeat > 0) {
            setHeat(currentHeat - 1);
            setLastTickSteam(0);
        }
        super.update();
    }

    @Override
    protected boolean canProgressRecipe() {
        return super.canProgressRecipe() && !(metaTileEntity instanceof IMultiblockController &&
                ((IMultiblockController) metaTileEntity).isStructureObstructed());
    }
    
    private void setWasteByproduct(ItemStack output)
    {
    	if(wasteByproduct != output)
    	{
    		wasteByproduct = output;
    	}
    }

    private ItemStack getWasteByproduct()
    {
    	return wasteByproduct;
    }
    
    @Override
    protected void trySearchNewRecipe() {
        NuclearReactor boiler = (NuclearReactor) metaTileEntity;
        if (ConfigHolder.machines.enableMaintenance && boiler.hasMaintenanceMechanics() &&
                boiler.getNumMaintenanceProblems() > 5) {
            return;
        }
        boolean didStartRecipe = false;

        if (!didStartRecipe) {
            IItemHandlerModifiable importItems = boiler.getImportItems();
            List<FluidStack> dummyFluidList = NonNullList.create();
            for (int i = 0; i < importItems.getSlots(); i++) {
                ItemStack stack = importItems.getStackInSlot(i);
                ItemStack itemStack = importItems.extractItem(i, 1, true);
                Recipe nuclearRecipe = NepRecipeMaps.NUCLEAR_FUEL.findRecipe(
                		GTValues.V[GTValues.MAX], Collections.singletonList(stack), dummyFluidList);
                
                if(nuclearRecipe != null && itemStack.getCount() >= nuclearRecipe.getInputs().get(0).getAmount())
                {
                	stack.shrink(1);
                	setMaxProgress(nuclearRecipe.getDuration());
                	setWasteByproduct(nuclearRecipe.getOutputs().get(0).copy()); // Need to use copy here otherwise it does weird shit
                	didStartRecipe = true;
                	break;
                }
            }
        }
        if (didStartRecipe) {
            this.progressTime = 1;
            this.recipeEUt = adjustEUtForThrottle(16000);
            if (wasActiveAndNeedsUpdate) {
                wasActiveAndNeedsUpdate = false;
            } else {
                setActive(true);
            }
        }
        metaTileEntity.getNotifiedItemInputList().clear();
        metaTileEntity.getNotifiedFluidInputList().clear();
    }

    @Override
    protected void updateRecipeProgress() {
        if (canRecipeProgress) {
            int generatedSteam = this.recipeEUt * getMaximumHeatFromMaintenance() / getMaximumHeat();
            if (generatedSteam > 0) {
                long amount = (generatedSteam + STEAM_PER_WATER) / STEAM_PER_WATER;
                excessWater += amount * STEAM_PER_WATER - generatedSteam;
                amount -= excessWater / STEAM_PER_WATER;
                excessWater %= STEAM_PER_WATER;

                FluidStack drainedWater = getBoilerFluidFromContainer(getInputTank(), (int) amount);
                if (amount != 0 && (drainedWater == null || drainedWater.amount < amount)) {
                    getMetaTileEntity().explodeMultiblock((1.0f * currentHeat / getMaximumHeat()) * 8.0f);
                } else {
                    setLastTickSteam(generatedSteam);
                    getOutputTank().fill(NepMaterials.HighTempSteam.getFluid(generatedSteam), true);
                }
            }
            if (currentHeat < getMaximumHeat()) {
                setHeat(currentHeat + 1);
            }

            if (++progressTime > maxProgressTime) {
            	if(getWasteByproduct() != ItemStack.EMPTY)
            	{
            		List<ItemStack> guh = new ArrayList<ItemStack>();
            		guh.add(getWasteByproduct());
            		if(GTTransferUtils.addItemsToItemHandler(getOutputInventory(), true, guh) == true)
            		{
            			GTTransferUtils.addItemsToItemHandler(getOutputInventory(), false, guh);
            		}
            	}
                completeRecipe();
            }
        }
    }

    private int getMaximumHeatFromMaintenance() {
        if (ConfigHolder.machines.enableMaintenance) {
            return (int) Math.min(currentHeat,
                    (1 - 0.1 * getMetaTileEntity().getNumMaintenanceProblems()) * getMaximumHeat());
        } else return currentHeat;
    }

    private int adjustEUtForThrottle(int rawEUt) {
        int throttle = ((NuclearReactor) metaTileEntity).getThrottle();
        return Math.max(25, (int) (rawEUt * (throttle / 100.0)));
    }

    private int getMaximumHeat() {
        return 256*20;
    }

    public int getHeatScaled() {
        return (int) Math.round(currentHeat / (1.0 * getMaximumHeat()) * 100);
    }

    public void setHeat(int heat) {
        if (heat != this.currentHeat && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_HEAT, b -> b.writeVarInt(heat));
        }
        this.currentHeat = heat;
    }

    public int getLastTickSteam() {
        return lastTickSteamOutput;
    }

    public void setLastTickSteam(int lastTickSteamOutput) {
        if (lastTickSteamOutput != this.lastTickSteamOutput && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_LAST_TICK_STEAM, b -> b.writeVarInt(lastTickSteamOutput));
        }
        this.lastTickSteamOutput = lastTickSteamOutput;
    }

    @Override
    public int getInfoProviderEUt() {
        return this.lastTickSteamOutput;
    }

    @Override
    public boolean consumesEnergy() {
        return false;
    }

    public void invalidate() {
        progressTime = 0;
        maxProgressTime = 0;
        recipeEUt = 0;
        setActive(false);
        setLastTickSteam(0);
    }

    @Override
    protected void completeRecipe() {
        progressTime = 0;
        setMaxProgress(0);
        recipeEUt = 0;
        wasActiveAndNeedsUpdate = true;
    }

    @NotNull
    @Override
    public NuclearReactor getMetaTileEntity() {
        return (NuclearReactor) super.getMetaTileEntity();
    }

    @NotNull
    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setInteger("Heat", currentHeat);
        compound.setInteger("ExcessFuel", excessFuel);
        compound.setInteger("ExcessWater", excessWater);
        compound.setInteger("ExcessProjectedEU", excessProjectedEU);
        return compound;
    }

    @Override
    public void deserializeNBT(@NotNull NBTTagCompound compound) {
        super.deserializeNBT(compound);
        this.currentHeat = compound.getInteger("Heat");
        this.excessFuel = compound.getInteger("ExcessFuel");
        this.excessWater = compound.getInteger("ExcessWater");
        this.excessProjectedEU = compound.getInteger("ExcessProjectedEU");
    }

    @Override
    public void writeInitialSyncData(@NotNull PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(currentHeat);
        buf.writeVarInt(lastTickSteamOutput);
    }

    @Override
    public void receiveInitialSyncData(@NotNull PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.currentHeat = buf.readVarInt();
        this.lastTickSteamOutput = buf.readVarInt();
    }

    @Override
    public void receiveCustomData(int dataId, @NotNull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == BOILER_HEAT) {
            this.currentHeat = buf.readVarInt();
        } else if (dataId == BOILER_LAST_TICK_STEAM) {
            this.lastTickSteamOutput = buf.readVarInt();
        }
    }

    // Required overrides to use RecipeLogic, but all of them are redirected by the above overrides.

    @Override
    protected long getEnergyInputPerSecond() {
        GTLog.logger.error("Large Boiler called getEnergyInputPerSecond(), this should not be possible!");
        return 0;
    }

    @Override
    protected long getEnergyStored() {
        GTLog.logger.error("Large Boiler called getEnergyStored(), this should not be possible!");
        return 0;
    }

    @Override
    protected long getEnergyCapacity() {
        GTLog.logger.error("Large Boiler called getEnergyCapacity(), this should not be possible!");
        return 0;
    }

    @Override
    protected boolean drawEnergy(int recipeEUt, boolean simulate) {
        GTLog.logger.error("Large Boiler called drawEnergy(), this should not be possible!");
        return false;
    }

    @Override
    public long getMaxVoltage() {
        GTLog.logger.error("Large Boiler called getMaxVoltage(), this should not be possible!");
        return 0;
    }

    /**
     * @param fluidHandler the handler to drain from
     * @param amount       the amount to drain
     * @return a valid boiler fluid from a container
     */
    @Nullable
    private static FluidStack getBoilerFluidFromContainer(@NotNull IFluidHandler fluidHandler, int amount) {
        if (amount == 0) return null;
        FluidStack drainedWater = fluidHandler.drain(Materials.Water.getFluid(amount), true);
        if (drainedWater == null || drainedWater.amount == 0) {
            drainedWater = fluidHandler.drain(Materials.DistilledWater.getFluid(amount), true);
        }
        if (drainedWater == null || drainedWater.amount == 0) {
            for (String fluidName : ConfigHolder.machines.boilerFluids) {
                Fluid fluid = FluidRegistry.getFluid(fluidName);
                if (fluid != null) {
                    drainedWater = fluidHandler.drain(new FluidStack(fluid, amount), true);
                    if (drainedWater != null && drainedWater.amount > 0) {
                        break;
                    }
                }
            }
        }
        return drainedWater;
    }
}
