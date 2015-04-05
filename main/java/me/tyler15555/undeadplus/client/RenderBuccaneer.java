package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBuccaneer extends RenderLiving {

	public RenderBuccaneer() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelBuccaneer(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/buccaneer.png");
	}

}
