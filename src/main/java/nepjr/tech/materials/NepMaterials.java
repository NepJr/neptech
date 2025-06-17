package nepjr.tech.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.Hydrogen;
import static gregtech.api.unification.material.Materials.Oxygen;
import static gregtech.api.unification.material.Materials.Thorium;
import static gregtech.api.unification.material.Materials.Uranium235;

import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static nepjr.tech.NepTech.nepId;

public class NepMaterials 
{
	public static Material Pyrotheum;
	public static Material Cryotheum;
	
	public static Material HighTempSteam;
	
	public static Material ThoriumFuel;
	public static Material ThoriumFuelWaste;
	
	public static void init()
	{
		Pyrotheum = new Material.Builder(10000, nepId("pyrotheum"))
				.liquid(new FluidBuilder().temperature(5800))
				.color(0xFF5F1F)
				.build();
		
		Cryotheum = new Material.Builder(10001, nepId("cryotheum"))
				.liquid(new FluidBuilder().temperature(1))
				.color(0x009999)
				.build();
		
		HighTempSteam = new Material.Builder(10002, nepId("high_temp_steam"))
                .gas(new FluidBuilder()
                        .temperature(1273)
                        .customStill())
                .color(0xC4C4C4)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();

		ThoriumFuel = new Material.Builder(11000, nepId("thorium_fuel"))
				.dust()
				.color(0x222222)
				.components(Thorium, 8, Uranium235, 1)
				.build();
		
		ThoriumFuelWaste = new Material.Builder(11001, nepId("thorium_fuel_waste"))
				.dust()
				.color(0x111111)
				.build();
	}
}
