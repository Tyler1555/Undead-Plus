package me.tyler15555.undeadplus.util;

import org.apache.logging.log4j.Level;

import me.tyler15555.undeadplus.common.UndeadPlus;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public ConfigHandler() {
		
	}
	
	public static void setupConfig(Configuration config) {
		try {
			config.load();
		} catch(Exception e) {
			UndeadPlus.logger.log(Level.ERROR, "An error has occured loading the Undead+ config file! Things may not work properly!");
			e.printStackTrace();
		} finally {
			config.save();
		}
	}

}
