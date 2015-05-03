package me.tyler15555.undeadplus.util;

import java.util.Random;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class UPConstants {
	
	private static final Random random = new Random();

	public static final String NAME = "Undead+";
	//This is here to try to get the mobs to reflect their old movespeed values. Not sure if this is accurate though
	public static final double BASE_MOVESPEED = 0.7;
	
	//So I don't have to write the same code a billion times
	public static void burnInSunlight(World world, EntityMob entity) {
		if (entity.worldObj.isDaytime() && !entity.worldObj.isRemote && !entity.isChild()) {
            float f = entity.getBrightness(1.0F);

            if (f > 0.5F && random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && entity.worldObj.canBlockSeeTheSky(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ))) {
                boolean flag = true;
                ItemStack itemstack = entity.getEquipmentInSlot(4);

                if (itemstack != null) {
                    if (itemstack.isItemStackDamageable()) {
                        itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + random.nextInt(2));

                        if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage()) {
                            entity.renderBrokenItemStack(itemstack);
                            entity.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    entity.setFire(8);
                }
            }
		}
	}
	
}
