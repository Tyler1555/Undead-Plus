package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import me.tyler15555.undeadplus.common.CommonProxy;
import me.tyler15555.undeadplus.entity.EntityThinker;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
    	
    }
	
    @Override
	public void setupEntityRenderering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThinker.class, new RenderThinker(Minecraft.getMinecraft().getRenderManager()));
	}
	
    @Override
	public void registerRenderers() {
		
	}

}
