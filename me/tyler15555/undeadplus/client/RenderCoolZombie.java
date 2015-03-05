package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCoolZombie extends RenderLiving {

	public RenderCoolZombie(RenderManager p_i46153_1_) {
		super(p_i46153_1_, new ModelBaseZombie(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "/textures/entity/cool.png");
	}

}
