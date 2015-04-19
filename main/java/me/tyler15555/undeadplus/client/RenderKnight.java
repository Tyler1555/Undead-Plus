package me.tyler15555.undeadplus.client;

import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;

public class RenderKnight extends RenderBaseZombie {

	public RenderKnight(String texture) {
		super(texture);
		this.addLayer(new LayerBipedArmor(this));
		this.addLayer(new LayerHeldItem(this));
	}

}
