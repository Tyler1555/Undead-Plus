package me.tyler15555.undeadplus.client;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.RenderingRegistry;
import me.tyler15555.undeadplus.common.CommonProxy;
import me.tyler15555.undeadplus.entity.EntityBrute;
import me.tyler15555.undeadplus.entity.EntityBuccaneer;
import me.tyler15555.undeadplus.entity.EntityCoolZombie;
import me.tyler15555.undeadplus.entity.EntityCordie;
import me.tyler15555.undeadplus.entity.EntityCrawler;
import me.tyler15555.undeadplus.entity.EntityFlare;
import me.tyler15555.undeadplus.entity.EntityFrostbite;
import me.tyler15555.undeadplus.entity.EntityGhoul;
import me.tyler15555.undeadplus.entity.EntityInfectedZombie;
import me.tyler15555.undeadplus.entity.EntityKnight;
import me.tyler15555.undeadplus.entity.EntityLimb;
import me.tyler15555.undeadplus.entity.EntityMaggot;
import me.tyler15555.undeadplus.entity.EntityMudman;
import me.tyler15555.undeadplus.entity.EntityMummy;
import me.tyler15555.undeadplus.entity.EntityRotter;
import me.tyler15555.undeadplus.entity.EntityThinker;
import me.tyler15555.undeadplus.entity.EntityWidower;
import me.tyler15555.undeadplus.entity.EntityZkuba;
import me.tyler15555.undeadplus.entity.EntityZombrine;



public class ClientProxy extends CommonProxy {

    public ClientProxy() {
    	
    }
	
    @Override
	public void setupEntityRenderering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThinker.class, new RenderBaseZombie("thinker"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMaggot.class, new RenderMaggot());
		RenderingRegistry.registerEntityRenderingHandler(EntityCoolZombie.class, new RenderBaseZombie("cool"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRotter.class, new RenderRotter());
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderBaseZombie("mummy"));
		RenderingRegistry.registerEntityRenderingHandler(EntityInfectedZombie.class, new RenderBaseZombie("infected"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new RenderBaseZombie("ghoul"));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCustomModel(new ModelCrawler(), "crawler"));
		RenderingRegistry.registerEntityRenderingHandler(EntityWidower.class, new RenderWidower());
		RenderingRegistry.registerEntityRenderingHandler(EntityMudman.class, new RenderBaseZombie("mudman"));
		RenderingRegistry.registerEntityRenderingHandler(EntityLimb.class, new RenderCustomModel(new ModelArm(), "arm"));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbite.class, new RenderBaseZombie("frostbite"));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombrine.class, new RenderBaseZombie("zombrine"));
		RenderingRegistry.registerEntityRenderingHandler(EntityBuccaneer.class, new RenderBuccaneer());
		RenderingRegistry.registerEntityRenderingHandler(EntityKnight.class, new RenderKnight("knightnew"));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrute.class, new RenderCustomModel(new ModelBrute(), "brute"));
		RenderingRegistry.registerEntityRenderingHandler(EntityZkuba.class, new RenderCustomModel(new ModelZkuba(), "zkuba"));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlare.class, new RenderCustomModel(new ModelFlare(), "flare"));
		RenderingRegistry.registerEntityRenderingHandler(EntityCordie.class, new RenderCordie("cordie"));
	}
	
    @Override
	public void registerRenderers() {
		
	}

}
