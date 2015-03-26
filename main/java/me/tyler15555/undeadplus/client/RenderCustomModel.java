package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
/**
 * Same idea as RenderBaseZombie. A simple renderer for entities that only need their models and textures rendered, no fancy stuff
 * @author Tyler15555
 *
 */
public class RenderCustomModel extends RenderLiving {

	private final String entityTexture;
	
	public RenderCustomModel(ModelBase model, String textureName) {
		super(Minecraft.getMinecraft().getRenderManager(), model, 0.5F);
		this.entityTexture = textureName;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "textures/entity/" + this.entityTexture + ".png");
	}

}
