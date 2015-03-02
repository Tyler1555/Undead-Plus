package me.tyler15555.undeadplus.common;

import java.awt.Color;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import me.tyler15555.undeadplus.biome.BiomeGrave;
import me.tyler15555.undeadplus.entity.EntityThinker;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
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
		
		logger.log(Level.INFO, "Undead+ is now loading!");
	}
	
	@EventHandler
	public void loadMod(FMLInitializationEvent event) {
		proxy.setupEntityRenderering();
		proxy.registerRenderers();
		
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(new BiomeGrave(), 30));
		BiomeManager.addSpawnBiome(new BiomeGrave());
		BiomeDictionary.registerBiomeType(new BiomeGrave(), Type.SPOOKY, Type.SPARSE, Type.COLD);
		
		EntityRegistry.registerGlobalEntityID(EntityThinker.class, "UP-Thinker", EntityRegistry.findGlobalUniqueEntityId(),Color.PINK.getRGB(), Color.WHITE.getRGB());
	}
	
	@EventHandler
	public void finishLoading(FMLInitializationEvent event) {
		logger.log(Level.INFO, "Undead+ has finished loading!");
	}
	
	

}
