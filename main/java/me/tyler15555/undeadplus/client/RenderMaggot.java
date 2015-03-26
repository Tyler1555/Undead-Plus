package me.tyler15555.undeadplus.client;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMaggot extends RenderSilverfish {

	public RenderMaggot(RenderManager p_i46144_1_) {
		super(p_i46144_1_);
	}
	
	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/maggot.png");
	}

}
