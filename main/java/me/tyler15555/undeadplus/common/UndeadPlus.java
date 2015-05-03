package me.tyler15555.undeadplus.common;

import java.awt.Color;

import me.tyler15555.undeadplus.biome.BiomeGrave;
import me.tyler15555.undeadplus.entity.EntityBrute;
import me.tyler15555.undeadplus.entity.EntityBuccaneer;
import me.tyler15555.undeadplus.entity.EntityCoolZombie;
import me.tyler15555.undeadplus.entity.EntityCrawler;
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
import me.tyler15555.undeadplus.util.ConfigHandler;
import me.tyler15555.undeadplus.util.UPAchievements;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;


@Mod(name = "Undead+", modid = "UndeadPlus", version = "1.3ac")
public class UndeadPlus {

	@Instance("UndeadPlus")
	public static UndeadPlus instance;
	@SidedProxy(clientSide = "me.tyler15555.undeadplus.client.ClientProxy", serverSide = "me.tyler15555.undeadplus.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void startLoading(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		
		logger.log(Level.INFO, "Undead+ is now loading!");
		
		ConfigHandler.setupConfig(new Configuration(event.getSuggestedConfigurationFile()));
		
		AchievementPage.registerAchievementPage(UPAchievements.upPage);
		
		FMLInterModComms.sendRuntimeMessage("UndeadPlus", "VersionChecker", "addVersionCheck", "https://raw.githubusercontent.com/Tyler1555/Undead-Plus/master/version.json");
	}
	
	@EventHandler
	public void loadMod(FMLInitializationEvent event) {
		proxy.setupEntityRenderering();
		proxy.registerRenderers();
		
		if(ConfigHandler.enableGraveBiome) {
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(new BiomeGrave(), ConfigHandler.graveBiomeID));
			BiomeManager.addSpawnBiome(new BiomeGrave());
			BiomeDictionary.registerBiomeType(new BiomeGrave(), Type.SPOOKY, Type.SPARSE, Type.COLD, Type.DEAD);
		}
		
		if(!ConfigHandler.enableGraveBiome && ConfigHandler.ghoulSpawnRate > 0) {
			logger.log(Level.WARN, "The grave biome is disabled but the ghoul is enabled! If no other mods add a biome with the type spooky then the ghoul will not spawn!");
		}
		
		EntityRegistry.registerGlobalEntityID(EntityThinker.class, "UP-Thinker", EntityRegistry.findGlobalUniqueEntityId(),Color.PINK.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityMaggot.class, "UP-Maggot", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.RED.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityCoolZombie.class, "UP-CoolZombie", EntityRegistry.findGlobalUniqueEntityId(), Color.CYAN.getRGB(), Color.BLUE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityRotter.class, "UP-Rotter", EntityRegistry.findGlobalUniqueEntityId(), Color.RED.getRGB(), Color.ORANGE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityMummy.class, "UP-Mummy", EntityRegistry.findGlobalUniqueEntityId(), Color.YELLOW.getRGB(), Color.ORANGE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityInfectedZombie.class, "UP-Infected", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.YELLOW.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityGhoul.class, "UP-Ghoul", EntityRegistry.findGlobalUniqueEntityId(), Color.GRAY.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityCrawler.class, "UP-Crawler", EntityRegistry.findGlobalUniqueEntityId(), Color.GREEN.getRGB(), Color.BLACK.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityWidower.class, "UP-Widower", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.GREEN.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityMudman.class, "UP-Mudman", EntityRegistry.findGlobalUniqueEntityId(), Color.BLUE.getRGB(), Color.ORANGE.getRGB() + Color.BLUE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityLimb.class, "UP-Limb", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityFrostbite.class, "UP-Frostbite", EntityRegistry.findGlobalUniqueEntityId(), Color.CYAN.getRGB(), Color.BLUE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityZombrine.class, "UP-Zombrine", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.GRAY.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityBuccaneer.class, "UP-Buccaneer", EntityRegistry.findGlobalUniqueEntityId(), Color.BLUE.getRGB(), Color.ORANGE.getRGB() + Color.BLUE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityKnight.class, "UP-Knight", EntityRegistry.findGlobalUniqueEntityId(), 0xc5c5c5, 0xebebeb);
		EntityRegistry.registerGlobalEntityID(EntityBrute.class, "UP-Brute", EntityRegistry.findGlobalUniqueEntityId(), 0x00afaf, 0x676f65);
		EntityRegistry.registerGlobalEntityID(EntityZkuba.class, "UP-Zkuba", EntityRegistry.findGlobalUniqueEntityId(), 0xe4e0d3, 0xd0b600);
		
		EntityRegistry.addSpawn(EntityMaggot.class, ConfigHandler.maggotSpawnRate, 2, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityMaggot.class, ConfigHandler.maggotSpawnRate, 2, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityThinker.class, ConfigHandler.thinkerSpawnRate, 1, 3, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityMummy.class, ConfigHandler.mummySpawnRate, 5, 6, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.DRY));
		EntityRegistry.addSpawn(EntityRotter.class, ConfigHandler.rotterSpawnRate, 1, 3, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityCoolZombie.class, ConfigHandler.coolSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityInfectedZombie.class, ConfigHandler.infectedSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityGhoul.class, ConfigHandler.ghoulSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityWidower.class, ConfigHandler.widowerSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityMudman.class, ConfigHandler.mudmanSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityFrostbite.class, ConfigHandler.frostbiteSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.COLD));
		EntityRegistry.addSpawn(EntityZombrine.class, ConfigHandler.zombrineSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityBuccaneer.class, ConfigHandler.pirateSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityKnight.class, ConfigHandler.knightSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.HILLS));
		EntityRegistry.addSpawn(EntityBrute.class, ConfigHandler.bruteSpawnRate, 2, 3, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityZkuba.class, ConfigHandler.zkubaSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.WATER));
		
		MinecraftForge.EVENT_BUS.register(new UndeadEventHandler());
		
		if(ConfigHandler.addToDungeons) {
			DungeonHooks.addDungeonMob("UP-Infected", 150);
			DungeonHooks.addDungeonMob("UP-Mummy", 200);
			DungeonHooks.addDungeonMob("UP-Ghoul", 125);
		}
	}
	
	@EventHandler
	public void finishLoading(FMLInitializationEvent event) {
		logger.log(Level.INFO, "Undead+ has finished loading!");
	}
	
	

}
