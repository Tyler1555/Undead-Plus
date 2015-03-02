package me.tyler15555.undeadplus.common;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
		
	}
	
	@EventHandler
	public void finishLoading(FMLInitializationEvent event) {
		logger.log(Level.INFO, "Undead+ has finished loading!");
	}

}
