package me.tyler15555.undeadplus.client;

import me.tyler15555.undeadplus.entity.EntityRotter;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class RenderRotter extends RenderBiped {

	public RenderRotter() {
		super(new ModelRotter(), 0.5F);
	}


	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/rotter.png");
	}
}
