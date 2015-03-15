package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBaseZombie extends RenderLiving {

	private String entityTexture;
	
	public RenderBaseZombie(RenderManager manager, String texture) {
		super(manager, new ModelBaseZombie(), 0.5F);
		this.entityTexture = texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "/textures/entity/" + entityTexture + ".png");
	}

}
