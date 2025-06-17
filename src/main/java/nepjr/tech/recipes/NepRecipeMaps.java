package nepjr.tech.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import stanhebben.zenscript.annotations.ZenProperty;

public class NepRecipeMaps 
{
	@ZenProperty
	public static final RecipeMap<SimpleRecipeBuilder> GREENHOUSE = new RecipeMap<>(
			"greenhouse", 4, 4, 1, 0, new SimpleRecipeBuilder(), false)
				.setSlotOverlay(false, false, GuiTextures.SLOT)
				.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
				.setSound(GTSoundEvents.CENTRIFUGE);
	
	@ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HIGH_TEMP_STEAM_TURBINE_FUELS = new RecipeMap<>("high_temp_steam_turbine", 0, 0, 1, 1,
            new FuelRecipeBuilder(), false)
                    .setSlotOverlay(false, true, true, GuiTextures.CENTRIFUGE_OVERLAY)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.TURBINE)
                    .allowEmptyOutput();

    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NUCLEAR_FUEL = new RecipeMap<>(
            "nuclear_fuel", 1, 1, 0, 0, new FuelRecipeBuilder(), false)
                    .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COMBUSTION)
                    .allowEmptyOutput();

}
