package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderWidower extends RenderSpider {
	
	public RenderWidower(RenderManager p_i46139_1_) {
		super(p_i46139_1_);
		this.addLayer(new LayerWidowerEyes(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/widower.png");
	}

}
