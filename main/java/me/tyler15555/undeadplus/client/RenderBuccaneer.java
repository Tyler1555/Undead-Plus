package me.tyler15555.undeadplus.client;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderBuccaneer extends RenderBiped {

	public RenderBuccaneer() {
		super(new ModelBuccaneer(), 0.5F);
		//this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/buccaneer.png");
	}
	/*
	@Override
	protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_) {
		super.renderEquippedItems(p_77029_1_, p_77029_2_);
	} */

}
