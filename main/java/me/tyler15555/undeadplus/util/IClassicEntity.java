package me.tyler15555.undeadplus.util;
/**
 * This exists to reimplement methods that no longer exist in Minecraft for entities that are being ported from older versions
 * Most methods are reimplemented through the Forge Event system.
 * @author Tyler15555
 *
 */
public interface IClassicEntity {

	public void dropRareDrop(int i);
	
}
