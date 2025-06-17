package nepjr.tech.recipes;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import nepjr.tech.NepTags;
import nepjr.tech.materials.NepMaterials;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = NepTags.MODID)
public class NepRecipes 
{
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) 
    {
    	init();
    }
	public static void init()
	{
		GreenhouseRecipes.registerRecipes();
		CraftingRecipes.registerRecipes();
		ForgeHammerRecipes.registerRecipes();
		ChemicalBathRecipes.registerRecipes();
		
        NepRecipeMaps.HIGH_TEMP_STEAM_TURBINE_FUELS.recipeBuilder()
        	.fluidInputs(NepMaterials.HighTempSteam.getFluid(160))
        	.fluidOutputs(Materials.DistilledWater.getFluid(20))
        	.duration(100)
        	.EUt((int) GTValues.V[GTValues.LuV])
        	.buildAndRegister();
        
        NepRecipeMaps.NUCLEAR_FUEL.recipeBuilder()
        	.input(OrePrefix.ingot, Materials.Uranium235)
        	.output(OrePrefix.ingot, Materials.Uranium238)
        	.duration(5*20)
        	.EUt(1)
        	.buildAndRegister();
        
        NepRecipeMaps.NUCLEAR_FUEL.recipeBuilder()
        	.input(OrePrefix.dust, NepMaterials.ThoriumFuel)
        	.output(OrePrefix.dust, NepMaterials.ThoriumFuel)
        	.duration((128*20) / 9)
        	.EUt(1)
        	.buildAndRegister();
	}
}
