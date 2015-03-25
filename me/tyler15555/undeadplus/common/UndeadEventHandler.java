package me.tyler15555.undeadplus.common;

import java.util.Random;

import me.tyler15555.undeadplus.entity.EntityGhoul;
import me.tyler15555.undeadplus.entity.EntityThinker;
import me.tyler15555.undeadplus.util.ConfigHandler;
import net.minecraft.world.EnumDifficulty;
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

}
