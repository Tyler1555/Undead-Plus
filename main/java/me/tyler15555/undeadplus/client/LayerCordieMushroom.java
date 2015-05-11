package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
/** Just a very slightly tweaked version of the Mooshroom mushroom layer **/
public class LayerCordieMushroom implements LayerRenderer {

	private final RenderCordie field_177205_a;
	
	public LayerCordieMushroom(RenderCordie renderer) {
		field_177205_a = renderer;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entity, float p_177141_2_,float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if (!entity.isChild() && !entity.isInvisible())
        {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.field_177205_a.bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.enableCull();
            /*
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0F, -1.0F, 1.0F);
            GlStateManager.translate(0.2F, 0.35F, 0.5F);
            GlStateManager.rotate(42.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5F, -0.5F, 0.5F);
            blockrendererdispatcher.renderBlockBrightness(Blocks.red_mushroom.getDefaultState(), 1.0F);
            GlStateManager.popMatrix(); 
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.1F, 0.0F, -0.6F);
            GlStateManager.rotate(42.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.5F, -0.2F, 0.5F);
            //blockrendererdispatcher.renderBlockBrightness(Blocks.red_mushroom.getDefaultState(), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix(); */
            GlStateManager.pushMatrix();
            ((ModelBaseZombie)this.field_177205_a.getMainModel()).bipedHead.postRender(0.0625F);
            GlStateManager.scale(1.0F, -1.0F, 1.0F);
            GlStateManager.translate(0.0F, 0.7F, -0.2F);
            GlStateManager.rotate(12.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-0.55F, -0.2F, 0.7F);
            blockrendererdispatcher.renderBlockBrightness(Blocks.red_mushroom.getDefaultState(), 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.disableCull();
        }
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

}
