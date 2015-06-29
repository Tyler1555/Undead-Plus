package me.tyler15555.undeadplus.client;

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
import me.tyler15555.undeadplus.entity.EntityPoisonBall;
import me.tyler15555.undeadplus.entity.EntityRotter;
import me.tyler15555.undeadplus.entity.EntityScorcher;
import me.tyler15555.undeadplus.entity.EntityThinker;
import me.tyler15555.undeadplus.entity.EntityVent;
import me.tyler15555.undeadplus.entity.EntityWidower;
import me.tyler15555.undeadplus.entity.EntityZkuba;
import me.tyler15555.undeadplus.entity.EntityZombrine;
import me.tyler15555.undeadplus.item.UPItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
    	
    }
	
    @Override
	public void setupEntityRenderering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThinker.class, new RenderBaseZombie("thinker"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMaggot.class, new RenderMaggot(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoolZombie.class, new RenderBaseZombie("cool"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRotter.class, new RenderRotter(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderBaseZombie("mummy"));
		RenderingRegistry.registerEntityRenderingHandler(EntityInfectedZombie.class, new RenderBaseZombie("infected"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new RenderBaseZombie("ghoul"));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCustomModel(new ModelCrawler(), "crawler"));
		RenderingRegistry.registerEntityRenderingHandler(EntityWidower.class, new RenderWidower(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMudman.class, new RenderBaseZombie("mudman"));
		RenderingRegistry.registerEntityRenderingHandler(EntityLimb.class, new RenderCustomModel(new ModelArm(), "arm"));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbite.class, new RenderBaseZombie("frostbite"));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombrine.class, new RenderBaseZombie("zombrine"));
		RenderingRegistry.registerEntityRenderingHandler(EntityBuccaneer.class, new RenderBuccaneer());
		RenderingRegistry.registerEntityRenderingHandler(EntityKnight.class, new RenderKnight("knightnew"));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrute.class, new RenderCustomModel(new ModelBrute(), "brute"));
		RenderingRegistry.registerEntityRenderingHandler(EntityZkuba.class, new RenderCustomModel(new ModelZkuba(), "zkuba"));
		RenderingRegistry.registerEntityRenderingHandler(EntityCordie.class, new RenderCordie("cordie"));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlare.class, new RenderFlare());
		RenderingRegistry.registerEntityRenderingHandler(EntityScorcher.class, new RenderBaseZombie("scorcher"));
		RenderingRegistry.registerEntityRenderingHandler(EntityVent.class, new RenderBaseZombie("vent"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonBall.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), UPItems.poisonBall, Minecraft.getMinecraft().getRenderItem()));
	}
	
    @Override
	public void registerRenderers() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(UPItems.poisonBall, 0, new ModelResourceLocation("undeadplus:poisonBall", "inventory"));
	}

}
