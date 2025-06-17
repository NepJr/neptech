package nepjr.tech.recipes;

import exnihilocreatio.ModBlocks;
import gregtech.api.recipes.RecipeMaps;
import net.minecraft.init.Blocks;

public class ForgeHammerRecipes 
{
	public static void registerRecipes()
	{
		RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
			.input(Blocks.SAND)
			.output(ModBlocks.dust)
			.EUt(16)
			.duration(10)
			.buildAndRegister();
	}
}
