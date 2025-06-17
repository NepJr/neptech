package nepjr.tech.recipes;

import exnihilocreatio.ModBlocks;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import net.minecraft.init.Blocks;

public class ChemicalBathRecipes 
{
	public static void registerRecipes()
	{
		RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
			.input(ModBlocks.dust)
			.fluidInputs(Materials.Water.getFluid(1000))
			.output(Blocks.CLAY)
			.EUt(GTValues.VA[GTValues.LV])
			.duration(80)
			.buildAndRegister();
	}
}
