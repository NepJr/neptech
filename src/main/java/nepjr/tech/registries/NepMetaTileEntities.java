package nepjr.tech.registries;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import gregtech.api.GTValues;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockTurbineCasing.TurbineCasingType;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeTurbine;
import nepjr.tech.multis.Greenhouse;
import nepjr.tech.multis.HighPressureSteamGrinder;
import nepjr.tech.multis.NuclearReactor;
import nepjr.tech.recipes.NepRecipeMaps;

public class NepMetaTileEntities 
{
	public static HighPressureSteamGrinder HP_STEAM_GRINDER;
	public static Greenhouse GREENHOUSE;
	
	public static NuclearReactor NUCLEAR_REACTOR;
	public static MetaTileEntityLargeTurbine HIGH_TEMP_STEAM_TURBINE_T1;
	public static MetaTileEntityLargeTurbine HIGH_TEMP_STEAM_TURBINE_T2;
	public static MetaTileEntityLargeTurbine HIGH_TEMP_STEAM_TURBINE_T3;
	
	public static void register()
	{
		// Steam Multiblocks
		HP_STEAM_GRINDER = registerMetaTileEntity(6000, new HighPressureSteamGrinder(nepId("hp_steam_grinder")));
		
		// Electric Multiblocks
		GREENHOUSE = registerMetaTileEntity(6100, new Greenhouse(nepId("greenhouse")));
		
		// Generators
		NUCLEAR_REACTOR = registerMetaTileEntity(6500, new NuclearReactor(nepId("nuclear_reactor")));
		HIGH_TEMP_STEAM_TURBINE_T1 = registerMetaTileEntity(6501, 
				new MetaTileEntityLargeTurbine(nepId("high_temp_steam_turbine_t1"), 
						NepRecipeMaps.HIGH_TEMP_STEAM_TURBINE_FUELS,
						GTValues.EV,
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.STEEL_TURBINE_CASING),
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.STEEL_GEARBOX),
						Textures.SOLID_STEEL_CASING,
						false,
						Textures.BLAST_FURNACE_OVERLAY));
		
		HIGH_TEMP_STEAM_TURBINE_T2 = registerMetaTileEntity(6502, 
				new MetaTileEntityLargeTurbine(nepId("high_temp_steam_turbine_t2"), 
						NepRecipeMaps.HIGH_TEMP_STEAM_TURBINE_FUELS,
						GTValues.IV,
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.TITANIUM_TURBINE_CASING),
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.TITANIUM_GEARBOX),
						Textures.STABLE_TITANIUM_CASING,
						false,
						Textures.BLAST_FURNACE_OVERLAY));
		
		HIGH_TEMP_STEAM_TURBINE_T3 = registerMetaTileEntity(6503, 
				new MetaTileEntityLargeTurbine(nepId("high_temp_steam_turbine_t3"), 
						NepRecipeMaps.HIGH_TEMP_STEAM_TURBINE_FUELS,
						GTValues.LuV,
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.TUNGSTENSTEEL_TURBINE_CASING),
						MetaBlocks.TURBINE_CASING.getState(TurbineCasingType.TUNGSTENSTEEL_GEARBOX),
						Textures.ROBUST_TUNGSTENSTEEL_CASING,
						false,
						Textures.BLAST_FURNACE_OVERLAY));
	}
}
