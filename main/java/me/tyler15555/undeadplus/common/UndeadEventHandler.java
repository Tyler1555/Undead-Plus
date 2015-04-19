package me.tyler15555.undeadplus.common;

import java.util.Random;

import me.tyler15555.undeadplus.entity.EntityGhoul;
import me.tyler15555.undeadplus.entity.EntityKnight;
import me.tyler15555.undeadplus.entity.EntityThinker;
import me.tyler15555.undeadplus.util.ConfigHandler;
import me.tyler15555.undeadplus.util.IClassicEntity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UndeadEventHandler {

	public UndeadEventHandler() {
		
	}
	
	private Random random = new Random();
	
	//event.customSummonAid isn't used because non of these mobs extend EntityZombie, so I just layer them on top. If anything, it just makes this more difficult :)
	@SubscribeEvent
	public void onSummonAid(SummonAidEvent event) {
		if(ConfigHandler.addCustomAid && event.world.getDifficulty() == EnumDifficulty.HARD && this.random.nextFloat() < event.summonChance) {
			switch(random.nextInt(2)) {
			case 0:
				EntityGhoul ghoul = new EntityGhoul(event.world);
				ghoul.setPosition(event.x, event.y, event.z);
				event.world.spawnEntityInWorld(ghoul);
				break;
			case 1:
				EntityThinker thinker = new EntityThinker(event.world);
				thinker.setPosition(event.x, event.y, event.z);
				event.world.spawnEntityInWorld(thinker);
				break;
			default:
				return;
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event) {
		if(event.entity instanceof IClassicEntity) {
			if(ConfigHandler.rareDropChance == -1) {
				return;
			} else if(random.nextInt(100) >= ConfigHandler.rareDropChance) {
				IClassicEntity entity = (IClassicEntity)event.entity;
				entity.dropRareDrop(ConfigHandler.rareDropChance);
			}
		}
	}
	//Because using entityInit() will prevent the zombie from spawning at all for some reason if I try to add armor, this has to be done instead
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityKnight) {
	    	event.entity.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
	    	event.entity.setCurrentItemOrArmor(1, new ItemStack(Items.iron_helmet));
	    	event.entity.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
	    	event.entity.setCurrentItemOrArmor(3, new ItemStack(Items.iron_leggings));
	    	event.entity.setCurrentItemOrArmor(4, new ItemStack(Items.iron_boots));
		}
	}

}
