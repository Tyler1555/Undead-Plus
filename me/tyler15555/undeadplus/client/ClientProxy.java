package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import me.tyler15555.undeadplus.common.CommonProxy;
import me.tyler15555.undeadplus.entity.EntityCoolZombie;
import me.tyler15555.undeadplus.entity.EntityMaggot;
import me.tyler15555.undeadplus.entity.EntityMummy;
import me.tyler15555.undeadplus.entity.EntityRotter;
import me.tyler15555.undeadplus.entity.EntityThinker;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
    	
    }
	
    @Override
	public void setupEntityRenderering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThinker.class, new RenderBaseZombie(Minecraft.getMinecraft().getRenderManager(), "thinker"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMaggot.class, new RenderMaggot(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoolZombie.class, new RenderBaseZombie(Minecraft.getMinecraft().getRenderManager(), "cool"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRotter.class, new RenderRotter(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderBaseZombie(Minecraft.getMinecraft().getRenderManager(), "mummy"));
	}
	
    @Override
	public void registerRenderers() {
		
	}

}
