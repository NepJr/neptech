package nepjr.tech.recipes;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import nepjr.tech.registries.NepMetaTileEntities;

public class CraftingRecipes 
{
	public static void registerRecipes()
	{
		ModHandler.addShapedRecipe("hp_steam_grinder", NepMetaTileEntities.HP_STEAM_GRINDER.getStackForm(), 
				"CGC", "CMC", "CGC",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'G', new UnificationEntry(OrePrefix.gear, Materials.WroughtIron),
				'M', MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm());
		
		ModHandler.addShapedRecipe("greenhouse", NepMetaTileEntities.GREENHOUSE.getStackForm(), 
				"GCG", 
				"CMC", 
				"GCG",
				'C', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID),
				'G', OreDictUnifier.get("circuitLv"),
				'M', MetaTileEntities.HULL[GTValues.LV].getStackForm());
	}
}
