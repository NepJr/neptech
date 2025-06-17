package nepjr.tech.multis;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import nepjr.tech.recipes.NepRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class Greenhouse extends RecipeMapMultiblockController
{
	public Greenhouse(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId, NepRecipeMaps.GREENHOUSE);
	}

	@Override
	protected @NotNull BlockPattern createStructurePattern() {
		FactoryBlockPattern pattern = FactoryBlockPattern.start()
				.aisle("CCCCC", "CGGGC", "CGGGC" ,"CGGGC", "CCCCC")
				.aisle("CDDDC", "G   G", "G   G", "G   G", "CGGGC")
				.aisle("CDDDC", "G   G", "G   G", "G   G", "CGGGC")
				.aisle("CDDDC", "G   G", "G   G", "G   G", "CGGGC")
				.aisle("CCSCC", "CGGGC", "CGGGC" ,"CGGGC", "CCCCC")
				.where('S', selfPredicate())
				.where('C', states(getCasingState())
							.or(autoAbilities(true, true, true, true, true, false, false)))
				.where('D', blocks(Blocks.DIRT)
						.or(blocks(Blocks.GRASS)))
				.where('G', blocks(Blocks.GLASS))
				.where(' ', air());
				
		return pattern.build();
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		// TODO Auto-generated method stub
		return Textures.SOLID_STEEL_CASING;
	}
	
	protected IBlockState getCasingState()
	{
		return MetaBlocks.METAL_CASING.getState(MetalCasingType.STEEL_SOLID);
	}

	@Override
	public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
		// TODO Auto-generated method stub
		return new Greenhouse(metaTileEntityId);
	}

}
