package nepjr.tech.exnihilo;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.items.ore.ItemOre;
import exnihilocreatio.modules.IExNihiloCreatioModule;
import exnihilocreatio.recipes.defaults.IRecipeDefaults;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.registries.OreRegistry;
import exnihilocreatio.registries.registries.SieveRegistry;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.ItemInfo;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GTModule implements IExNihiloCreatioModule, IRecipeDefaults
{
	public void registerOreChunks(OreRegistry registry) 
	{
		
		Item ingot = Item.getByNameOrId("gregtech:meta_ingot");
		Item dust = Item.getByNameOrId("gregtech:meta_dust");
		
		if(!registry.isRegistered("copper"))
		{
			registry.register(Materials.Copper.getName(), new Color(Materials.Copper.getMaterialRGB()), 
					new ItemInfo(ingot, Materials.Copper.getId()),
					new ItemInfo(dust, Materials.Copper.getId()));
		}
		if(!registry.isRegistered("tin"))
		{
			registry.register(Materials.Tin.getName(), new Color(Materials.Tin.getMaterialRGB()), 
					new ItemInfo(ingot, Materials.Tin.getId()),
					new ItemInfo(dust, Materials.Tin.getId()));
		}
		if(!registry.isRegistered("silver"))
		{
			registry.register(Materials.Silver.getName(), new Color(Materials.Silver.getMaterialRGB()), 
					new ItemInfo(ingot, Materials.Silver.getId()),
					new ItemInfo(dust, Materials.Silver.getId()));
		}
		if(!registry.isRegistered("lead"))
		{
			registry.register(Materials.Lead.getName(), new Color(Materials.Lead.getMaterialRGB()), 
					new ItemInfo(ingot, Materials.Lead.getId()),
					new ItemInfo(dust, Materials.Lead.getId()));
		}
		if(!registry.isRegistered("cobaltite"))
		{
			registry.register(Materials.Cobaltite.getName(), new Color(Materials.Cobaltite.getMaterialRGB()), 
					new ItemInfo(ingot, Materials.Cobalt.getId()),
					new ItemInfo(dust, Materials.Cobaltite.getId()));
		}
		if(!registry.isRegistered("sphalerite"))
		{
			registry.register(Materials.Sphalerite.getName(), new Color(Materials.Sphalerite.getMaterialRGB()), 
					new ItemInfo(dust, Materials.Sphalerite.getId()),
					new ItemInfo(dust, Materials.Sphalerite.getId()));
		}
		if(!registry.isRegistered("calcite"))
		{
			registry.register(Materials.Calcite.getName(), new Color(Materials.Calcite.getMaterialRGB()), 
					new ItemInfo(dust, Materials.Calcite.getId()),
					new ItemInfo(dust, Materials.Calcite.getId()));
		}
		if(!registry.isRegistered("gypsum"))
		{
			registry.register(Materials.Gypsum.getName(), new Color(Materials.Gypsum.getMaterialRGB()), 
					new ItemInfo(dust, Materials.Gypsum.getId()),
					new ItemInfo(dust, Materials.Gypsum.getId()));
		}
		if(!registry.isRegistered("sulfur"))
		{
			registry.register(Materials.Sulfur.getName(), new Color(Materials.Sulfur.getMaterialRGB()), 
					new ItemInfo(dust, Materials.Sulfur.getId()),
					new ItemInfo(dust, Materials.Sulfur.getId()));
		}
		if(!registry.isRegistered("oilsands"))
		{
			registry.register(Materials.Oilsands.getName(), new Color(Materials.Oilsands.getMaterialRGB()), 
					new ItemInfo(dust, Materials.Oilsands.getId()),
					new ItemInfo(dust, Materials.Oilsands.getId()));
		}
		ItemOre oreCalcite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("calcite");
		ItemOre oreGypsum = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("gypsum");
		ItemOre oreSulfur = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sulfur");
		ItemOre oreOilsands = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("oilsands");
		ItemOre oreSphalerite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sphalerite");
		ItemOre oreCobaltite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("cobaltite");
		
        registry.getSieveBlackList().add(oreCalcite);
        registry.getSieveBlackList().add(oreGypsum);
        registry.getSieveBlackList().add(oreSulfur);
        registry.getSieveBlackList().add(oreOilsands);
        registry.getSieveBlackList().add(oreSphalerite);
        registry.getSieveBlackList().add(oreCobaltite);   
	}
	
	public void registerSieve(SieveRegistry registry) {
        ItemOre sulfur = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sulfur");
        ItemOre calcite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("calcite");
        ItemOre gypsum = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("gypsum");
        ItemOre oilsands = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("oilsands");
        ItemOre sphalerite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("sphalerite");
		ItemOre cobaltite = ExNihiloRegistryManager.ORE_REGISTRY.getOreItem("cobaltite");
        
        ItemStack crushedNetherrack = Item.getItemFromBlock(ModBlocks.netherrackCrushed).getDefaultInstance();
        @SuppressWarnings("unused")
		ItemStack crushedEndstone = Item.getItemFromBlock(ModBlocks.endstoneCrushed).getDefaultInstance();
        
        if (sulfur != null) {
            registry.register(crushedNetherrack, new ItemInfo(sulfur), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (calcite != null) {
            registry.register("dust", new ItemInfo(calcite), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (gypsum != null) {
            registry.register("dust", new ItemInfo(gypsum), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (oilsands != null) {
            registry.register("sand", new ItemInfo(oilsands), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (sphalerite != null) {
            registry.register("gravel", new ItemInfo(sphalerite), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
        
        if (cobaltite != null) {
            registry.register("gravel", new ItemInfo(cobaltite), 0.05f, BlockSieve.MeshType.DIAMOND.getID());
        }
    }
	
	@Override
	public String getMODID() 
	{
		return GTValues.MODID;
	}

}
