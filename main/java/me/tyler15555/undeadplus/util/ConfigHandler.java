package me.tyler15555.undeadplus.util;

import org.apache.logging.log4j.Level;

import me.tyler15555.undeadplus.common.UndeadPlus;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public ConfigHandler() {
		
	}
	
	public static int rotterSpawnRate;
	public static int maggotSpawnRate;
	public static int thinkerSpawnRate;
	public static int coolSpawnRate;
	public static int mummySpawnRate;
	public static int infectedSpawnRate;
	public static int ghoulSpawnRate;
	public static int widowerSpawnRate;
	public static int graveBiomeID;
	public static boolean enableGraveBiome;
	public static boolean addCustomAid;
	public static boolean addToDungeons;
	
	public static void setupConfig(Configuration config) {
		try {
			config.load();
			rotterSpawnRate = config.getInt("RotterSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a rotter spawning");
			maggotSpawnRate = config.getInt("MaggotSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a maggot spawning");
			thinkerSpawnRate = config.getInt("MummySpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a mummy spawning");
			coolSpawnRate = config.getInt("CoolZombieSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a cool zombie spawning");
			mummySpawnRate = config.getInt("MummySpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a mummy spawning");
			infectedSpawnRate = config.getInt("InfectedSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a infected zombie spawning");
			ghoulSpawnRate = config.getInt("GhoulSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "The chance of a ghoul spawning. Note: If no spooky biomes are found(This mod adds one) this mob will not spawn");
			widowerSpawnRate = config.getInt("WidowerSpawnRate", "Spawning", 10, 0, Integer.MAX_VALUE, "Chance of a widower spawning");
			graveBiomeID = config.getInt("GraveBiomeID", "IDs", 30, Integer.MIN_VALUE, Integer.MAX_VALUE, "The Grave Biome's ID");
			enableGraveBiome = config.getBoolean("EnableGraveBiome", "General", true, "Whether or not to enable the grave biome. This could screw up some mod interactions");
			addCustomAid = config.getBoolean("AddCustomSummonAid", "Tweaks", true, "Whether or not to add custom aid for zombies that summon it(This is a vanilla mechanic. The possible summons are a thinker or ghoul");
			addToDungeons = config.getBoolean("AddZombiesToDungeons", "Tweaks", true, "Whether or not to add a chance for dungeons to contain a spawner for this mod's mobs");
		} catch(Exception e) {
			UndeadPlus.logger.log(Level.ERROR, "An error has occured loading the Undead+ config file! Things may not work properly!");
			e.printStackTrace();
		} finally {
			if(config.hasChanged()) {
				config.save();
			}
		}
	}

}
