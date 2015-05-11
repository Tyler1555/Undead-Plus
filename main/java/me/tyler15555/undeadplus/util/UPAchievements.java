package me.tyler15555.undeadplus.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class UPAchievements {

	public UPAchievements() {
		
	}
	public static Achievement thinkerKill = new Achievement("killThinker", "killThinker", 0, 0, Items.book, null);
	public static Achievement coolKill = new Achievement("coolKill", "coolKill", 2, 3, Blocks.ice, null);
	public static Achievement rotterKill = new Achievement("rotterKill", "rotterKill", 3, 2, Items.rotten_flesh, null);
	public static Achievement mummyKill = new Achievement("mummyKill", "mummyKill", 5, 4, Blocks.sand, null);
	public static Achievement frostKill = new Achievement("frostKill", "frostKill", 8, 4, Items.snowball, null);
	public static Achievement bruteKill = new Achievement("bruteKill", "bruteKill", -3, 7, Items.bone, null);
	public static Achievement cordieKill = new Achievement("cordieKill", "cordieKill", -5, 10, Blocks.red_mushroom, null);
	public static Achievement scorchKill = new Achievement("scorchKill", "scorchKill", 10 ,-3, Items.water_bucket, null);
	
	public static AchievementPage upPage = new AchievementPage("Undead+", thinkerKill, coolKill, mummyKill, rotterKill, frostKill, bruteKill, cordieKill, scorchKill);

}
