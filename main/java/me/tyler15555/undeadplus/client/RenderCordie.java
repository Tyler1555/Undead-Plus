package me.tyler15555.undeadplus.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class RenderCordie extends RenderBaseZombie {

	public RenderCordie(String textureName) {
		super(textureName);
	}
	
	@Override
	protected void renderEquippedItems(EntityLivingBase entity, float p_77029_2_) {
		super.renderEquippedItems(entity, p_77029_2_);
		this.bindTexture(TextureMap.locationBlocksTexture);
		GL11.glPushMatrix();
		((ModelBaseZombie)this.mainModel).bipedHead.postRender(0.0625F);
        GL11.glScalef(1.0F, -1.0F, 1.0F);
        GL11.glTranslatef(0.0F, 1F, 0.0F);
        GL11.glRotatef(12.0F, 0.0F, 1.0F, 0.0F);
        this.field_147909_c.renderBlockAsItem(Blocks.red_mushroom, 0, 1.0F);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        //GL11.glPopMatrix();
	}

}
