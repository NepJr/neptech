package nepjr.tech.recipes;

import exnihilocreatio.items.ItemResource;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GreenhouseRecipes 
{
	public static void registerRecipes()
	{
		// Oak Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Item.getItemFromBlock(Blocks.SAPLING).getDefaultInstance())
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4)
		.output(Item.getItemFromBlock(Blocks.LOG), 24)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Item.getItemFromBlock(Blocks.SAPLING).getDefaultInstance())
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4)
		.output(Item.getItemFromBlock(Blocks.LOG), 48)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Rubber Saplings
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING).getDefaultInstance())
		.output(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING), 4)
		.output(Item.getItemFromBlock(MetaBlocks.RUBBER_LOG), 24)
		.output(MetaItems.STICKY_RESIN, 16)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING).getDefaultInstance())
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(MetaBlocks.RUBBER_SAPLING), 4)
		.output(Item.getItemFromBlock(MetaBlocks.RUBBER_LOG), 48)
		.output(MetaItems.STICKY_RESIN, 32)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Spruce Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 1)
		.output(Item.getItemFromBlock(Blocks.LOG), 24, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 1)
		.output(Item.getItemFromBlock(Blocks.LOG), 48, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Spruce Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 1)
		.output(Item.getItemFromBlock(Blocks.LOG), 24, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 1))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 1)
		.output(Item.getItemFromBlock(Blocks.LOG), 48, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Birch Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 2))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 2)
		.output(Item.getItemFromBlock(Blocks.LOG), 24, 2)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 2))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 2)
		.output(Item.getItemFromBlock(Blocks.LOG), 48, 2)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Jungle Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 3))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 3)
		.output(Item.getItemFromBlock(Blocks.LOG), 24, 3)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 3))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 3)
		.output(Item.getItemFromBlock(Blocks.LOG), 48, 3)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Acacia Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 4))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 4)
		.output(Item.getItemFromBlock(Blocks.LOG2), 24, 0)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 4))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 4, 4)
		.output(Item.getItemFromBlock(Blocks.LOG2), 48, 0)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Dark Oak Sapling
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 4, 5))
		.output(Item.getItemFromBlock(Blocks.SAPLING), 16, 5)
		.output(Item.getItemFromBlock(Blocks.LOG2), 64, 1)
		.output(Item.getItemFromBlock(Blocks.LOG2), 32, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 4, 5))
		.input(MetaItems.FERTILIZER)
		.output(Item.getItemFromBlock(Blocks.SAPLING), 16, 5)
		.output(Item.getItemFromBlock(Blocks.LOG2), 64, 1)
		.output(Item.getItemFromBlock(Blocks.LOG2), 64, 1)
		.output(Item.getItemFromBlock(Blocks.LOG2), 64, 1)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(600)
		.circuitMeta(2)
		.buildAndRegister();
		
		// Oak Sapling + Silkworm
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.input(Item.getItemFromBlock(Blocks.SAPLING))
		.inputs(ItemResource.getResourceStack("silkworm"))
		.output(Items.STRING, 32)
		.output(Item.getItemFromBlock(Blocks.LOG), 24)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(2400)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.input(Item.getItemFromBlock(Blocks.SAPLING))
		.inputs(ItemResource.getResourceStack("silkworm"))
		.input(MetaItems.FERTILIZER)
		.output(Items.STRING, 64)
		.output(Item.getItemFromBlock(Blocks.LOG), 48)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(1200)
		.circuitMeta(2)
		.buildAndRegister();

		// Sugar cane
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Items.REEDS.getDefaultInstance())
		.output(Items.REEDS, 64)
		.output(Items.REEDS, 64)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(60)
		.circuitMeta(1)
		.buildAndRegister();
		
		NepRecipeMaps.GREENHOUSE.recipeBuilder()
		.fluidInputs(Materials.Water.getFluid(1000))
		.notConsumable(Items.REEDS.getDefaultInstance())
		.input(MetaItems.FERTILIZER)
		.output(Items.REEDS, 64)
		.output(Items.REEDS, 64)
		.output(Items.REEDS, 64)
		.output(Items.REEDS, 64)
		.EUt(GTValues.VA[GTValues.ULV])
		.duration(30)
		.circuitMeta(2)
		.buildAndRegister();
	}
}
