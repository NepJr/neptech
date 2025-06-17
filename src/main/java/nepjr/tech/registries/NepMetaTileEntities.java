package nepjr.tech.registries;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static nepjr.tech.NepTech.nepId;

import gregtech.api.GTValues;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockTurbineCasing.TurbineCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.multi.electric.generator.MetaTileEntityLargeTurbine;
import nepjr.tech.multipart.BruhEnergyHatch;
import nepjr.tech.multipart.BruhSubstationEnergyHatch;
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
	
    public static final BruhEnergyHatch[] ENERGY_INPUT_HATCH = new BruhEnergyHatch[GTValues.V.length];
    public static final BruhEnergyHatch[] ENERGY_INPUT_HATCH_4A = new BruhEnergyHatch[GTValues.V.length]; // EV, IV, LuV, ZPM, UV, UHV
    public static final BruhEnergyHatch[] ENERGY_INPUT_HATCH_16A = new BruhEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
    public static final BruhEnergyHatch[] ENERGY_OUTPUT_HATCH = new BruhEnergyHatch[GTValues.V.length];
    public static final BruhEnergyHatch[] ENERGY_OUTPUT_HATCH_4A = new BruhEnergyHatch[GTValues.V.length]; // EV, IV, LuV, ZPM, UV, UHV
    public static final BruhEnergyHatch[] ENERGY_OUTPUT_HATCH_16A = new BruhEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
    public static final BruhSubstationEnergyHatch[] SUBSTATION_ENERGY_INPUT_HATCH = new BruhSubstationEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
    public static final BruhSubstationEnergyHatch[] SUBSTATION_ENERGY_OUTPUT_HATCH = new BruhSubstationEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
   
	
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
		
		// Energy Input/Output Hatches
        int endPos = GTValues.MAX;
        String voltageName = GTValues.VN[GTValues.MAX].toLowerCase();
        
        ENERGY_INPUT_HATCH[GTValues.MAX] = registerMetaTileEntity(7000,
                new BruhEnergyHatch(nepId("energy_hatch.input." + voltageName), GTValues.MAX, 2, false));
        ENERGY_OUTPUT_HATCH[GTValues.MAX] = registerMetaTileEntity(7001,
                new BruhEnergyHatch(nepId("energy_hatch.output." + voltageName), GTValues.MAX, 2, true));
        for (int i = 0; i < endPos + 1; i++) {

            if (i >= GTValues.UEV && i <= GTValues.MAX) {
            	voltageName = GTValues.VN[i].toLowerCase();
                ENERGY_INPUT_HATCH_4A[i - GTValues.UEV] = registerMetaTileEntity(7002 + i - GTValues.UEV,
                        new BruhEnergyHatch(nepId("energy_hatch.input_4a." + voltageName), i, 4, false));
                ENERGY_INPUT_HATCH_16A[i - GTValues.UEV] = registerMetaTileEntity(7007 + i - GTValues.UEV,
                        new BruhEnergyHatch(nepId("energy_hatch.input_16a." + voltageName), i, 16,
                                false));
                ENERGY_OUTPUT_HATCH_4A[i - GTValues.UEV] = registerMetaTileEntity(7012 + i - GTValues.UEV,
                        new BruhEnergyHatch(nepId("energy_hatch.output_4a." + voltageName), i, 4, true));
                ENERGY_OUTPUT_HATCH_16A[i - GTValues.UEV] = registerMetaTileEntity(7017 + i - GTValues.UEV,
                        new BruhEnergyHatch(nepId("energy_hatch.output_16a." + voltageName), i, 16,
                                true));
                SUBSTATION_ENERGY_INPUT_HATCH[i - GTValues.UEV] = registerMetaTileEntity(7022 + i - GTValues.UEV,
                        new BruhSubstationEnergyHatch(nepId("substation_hatch.input_64a." + voltageName),
                                i, 64, false));
                SUBSTATION_ENERGY_OUTPUT_HATCH[i - GTValues.UEV] = registerMetaTileEntity(7027 + i - GTValues.UEV,
                        new BruhSubstationEnergyHatch(
                        		nepId("substation_hatch.output_64a." + voltageName), i, 64, true));
            }
        }
	}
}
