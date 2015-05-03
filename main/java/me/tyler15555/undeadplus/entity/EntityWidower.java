package me.tyler15555.undeadplus.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityWidower extends EntitySpider {

	public EntityWidower(World world) {
		super(world);
		setSize(1.4F, 0.9F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(10);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(2);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
    {
        if(super.attackEntityAsMob(entity))
        {
            if(entity instanceof EntityLiving)
            {
                byte byte0 = 0;
                
                switch(this.worldObj.difficultySetting) {
                case EASY:
                	byte0 = 4;
                	break;
                case NORMAL:
                	byte0 = 7;
                	break;
                case HARD:
                	byte0 = 15;
                	break;
                default:
                	byte0 = 0;
                	break;
                }
                
                if(byte0 > 0)
                {
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, byte0 * 25));
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.hunger.id, byte0 * 25));
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

}
