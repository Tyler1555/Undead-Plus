package me.tyler15555.undeadplus.client;


public class RenderCordie extends RenderBaseZombie {

	public RenderCordie(String texture) {
		super(texture);
		this.addLayer(new LayerCordieMushroom(this));
	}

}
