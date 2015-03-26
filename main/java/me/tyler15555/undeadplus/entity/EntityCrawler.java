package me.tyler15555.undeadplus.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCrawler extends EntityMob {

	public EntityCrawler(World worldIn) {
		super(worldIn);
        setSize(1F, 1F);
        
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIBreakDoor(this));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
        tasks.addTask(6, new EntityAIWander(this, 1.0D));
        tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
        tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2F);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(16);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(2);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)  {
        if(super.attackEntityAsMob(entity))
        {
            if(entity instanceof EntityLiving)
            {
                byte byte0 = 0;
                	//This is a switch as opposed to other entities because I figured it would be easier to write this way, and what do you know, it was. Other classes will not be changed
                	switch(this.worldObj.getDifficulty()) {
                	case EASY:
                		byte0 = 3;
                		break;
                	case NORMAL:
                		byte0 = 4;
                		break;
                	case HARD:
                		byte0 = 5;
                		break;
					default:
						byte0 = 3;
						break;
                	}
                
                if(byte0 > 0)
                {
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 20));
                }
            }
            super.attackEntityAsMob(entity);
            return true;
        } else {
            return false;
        }
    }
	
	@Override
	public void onLivingUpdate() {
        super.onLivingUpdate();
		
		if (worldObj.isDaytime() && !worldObj.isRemote)
		{
			float f = getBrightness(1.0F);
			if (f > 0.5F && worldObj.canBlockSeeSky(new BlockPos(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ))) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
			{
				setFire(8);
			}
		}
    }
	
	@Override
	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}
	
	@Override
	protected String getLivingSound() {
		return "mob.zombie.say";
	}
	
	@Override
	protected String getDeathSound() {
		return "mob.zombie.death";
	}
	
	@Override
	public Item getDropItem() {
		return Items.rotten_flesh;
	}

}
