package me.tyler15555.undeadplus.client;

import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.util.ResourceLocation;

public class LayerWidowerEyes extends LayerSpiderEyes {
	
	public LayerWidowerEyes(RenderSpider spider) {
		super(spider);
		this.field_177150_a = new ResourceLocation("undeadplus", "textures/entity/widower_eyes.png");
	}
}
