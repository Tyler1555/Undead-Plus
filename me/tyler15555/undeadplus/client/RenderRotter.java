package me.tyler15555.undeadplus.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderRotter extends RenderLiving {
	
	public RenderRotter(RenderManager p_i46153_1_) {
		super(p_i46153_1_, new ModelRotter(), 0.5F);
		//this.addLayer(new UndeadLayerHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("undeadplus", "/textures/entity/rotter.png");
	}

}
