package nepjr.tech.api.capability.impl;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.SteamMultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;

public class HighPressureSteamMultiWorkable extends SteamMultiblockRecipeLogic {

	public HighPressureSteamMultiWorkable(RecipeMapSteamMultiblockController tileEntity, double conversionRate) 
	{
		super(tileEntity, tileEntity.recipeMap, tileEntity.getSteamFluidTank(), conversionRate);
	}
	
	@NotNull
    @Override
    public ParallelLogicType getParallelLogicType() {
        return ParallelLogicType.APPEND_ITEMS;
    }

    @Override
    public void applyParallelBonus(@NotNull RecipeBuilder<?> builder) {
        int currentRecipeEU = builder.getEUt();
        int currentRecipeDuration = builder.getDuration() / getParallelLimit();
        builder.EUt((int) Math.min(32.0, Math.ceil(currentRecipeEU * 1.33)))
                .duration((int) (currentRecipeDuration * 1.5));
    }
	
    @NotNull
    @Override
    protected int[] calculateOverclock(@NotNull Recipe recipe) {
        // EUt, Duration
        int[] result = new int[2];

        result[0] = recipe.getEUt() * 2;
        result[1] = recipe.getDuration() / 2;

        return result;
    }

}
