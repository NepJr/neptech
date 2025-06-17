package nepjr.tech.multipart;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import nepjr.tech.registries.NepMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class BruhEnergyHatch extends MetaTileEntityEnergyHatch
{

	public BruhEnergyHatch(ResourceLocation metaTileEntityId, int tier, int amperage, boolean isExportHatch) 
	{
		super(metaTileEntityId, tier, amperage, isExportHatch);
	}
	
	@Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) 
	{
        return new BruhEnergyHatch(metaTileEntityId, getTier(), amperage, isExportHatch);
    }
	
	@Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) 
	{
		subItems.add(getStackForm());
    }

}
