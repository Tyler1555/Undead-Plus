package me.tyler15555.undeadplus.common;

import java.awt.Color;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import me.tyler15555.undeadplus.biome.BiomeGrave;
import me.tyler15555.undeadplus.entity.EntityCoolZombie;
import me.tyler15555.undeadplus.entity.EntityInfectedZombie;
import me.tyler15555.undeadplus.entity.EntityMaggot;
import me.tyler15555.undeadplus.entity.EntityMummy;
import me.tyler15555.undeadplus.entity.EntityRotter;
import me.tyler15555.undeadplus.entity.EntityThinker;
import me.tyler15555.undeadplus.util.ConfigHandler;
import me.tyler15555.undeadplus.util.UPAchievements;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(name = "Undead+", modid = "UndeadPlus", version = "1.0a")
public class UndeadPlus {

	@Instance("UndeadPlus")
	public static UndeadPlus instance;
	@SidedProxy(clientSide = "me.tyler15555.undeadplus.client.ClientProxy", serverSide = "me.tyler15555.undeadplus.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void startLoading(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		
		ConfigHandler.setupConfig(new Configuration(event.getSuggestedConfigurationFile()));
		
		AchievementPage.registerAchievementPage(UPAchievements.upPage);
		
		logger.log(Level.INFO, "Undead+ is now loading!");
	}
	
	@EventHandler
	public void loadMod(FMLInitializationEvent event) {
		proxy.setupEntityRenderering();
		proxy.registerRenderers();
		
		if(ConfigHandler.enableGraveBiome) {
			BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(new BiomeGrave(), ConfigHandler.graveBiomeID));
			BiomeManager.addSpawnBiome(new BiomeGrave());
			BiomeDictionary.registerBiomeType(new BiomeGrave(), Type.SPOOKY, Type.SPARSE, Type.COLD);
		}
		
		EntityRegistry.registerGlobalEntityID(EntityThinker.class, "UP-Thinker", EntityRegistry.findGlobalUniqueEntityId(),Color.PINK.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityMaggot.class, "UP-Maggot", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.RED.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityCoolZombie.class, "UP-CoolZombie", EntityRegistry.findGlobalUniqueEntityId(), Color.CYAN.getRGB(), Color.BLUE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityRotter.class, "UP-Rotter", EntityRegistry.findGlobalUniqueEntityId(), Color.RED.getRGB(), Color.ORANGE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityMummy.class, "UP-Mummy", EntityRegistry.findGlobalUniqueEntityId(), Color.YELLOW.getRGB(), Color.ORANGE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityInfectedZombie.class, "UP-Infected", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.YELLOW.getRGB());
		
		EntityRegistry.addSpawn(EntityMaggot.class, ConfigHandler.maggotSpawnRate, 2, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityMaggot.class, ConfigHandler.maggotSpawnRate, 2, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityThinker.class, ConfigHandler.thinkerSpawnRate, 1, 3, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityMummy.class, ConfigHandler.mummySpawnRate, 5, 6, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DRY));
		EntityRegistry.addSpawn(EntityRotter.class, ConfigHandler.rotterSpawnRate, 1, 3, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityCoolZombie.class, ConfigHandler.coolSpawnRate, 1, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityInfectedZombie.class, ConfigHandler.infectedSpawnRate, 1, 4, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		
		
	}
	
	@EventHandler
	public void finishLoading(FMLInitializationEvent event) {
		logger.log(Level.INFO, "Undead+ has finished loading!");
	}
	
	

}
