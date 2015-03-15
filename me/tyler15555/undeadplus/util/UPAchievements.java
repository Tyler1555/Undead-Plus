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
	
	public static AchievementPage upPage = new AchievementPage("Undead+", thinkerKill, coolKill, mummyKill, rotterKill);

}
