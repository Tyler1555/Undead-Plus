package me.tyler15555.undeadplus.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class RenderRotter extends RenderLiving {
	
	public RenderRotter(RenderManager p_i46153_1_) {
		super(p_i46153_1_, new ModelRotter(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/rotter.png");
	}

}
