package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
/**
 * A simple renderer for entities that use ModelBaseZombie(A fairly large amount of the zombies) and just need a texture. No fancy stuff
 * @author Tyler15555
 *
 */
public class RenderBaseZombie extends RenderBiped {

	private String entityTexture;
	
	public RenderBaseZombie(String texture) {
		super(new ModelBaseZombie(), 0.5F);
		this.entityTexture = texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/" + entityTexture + ".png");
	}

}
