package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.UPAchievements;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMummy extends EntityMob {

	public EntityMummy(World worldIn) {
		super(worldIn);
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(16);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(4);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.275D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)  {
        if(super.attackEntityAsMob(entity))
        {
            if(entity instanceof EntityLiving)
            {
                byte byte0 = 0;
                	if(worldObj.getDifficulty() == EnumDifficulty.EASY) {
                		byte0 = 7;
                	}
                    if(worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                        byte0 = 8;
                    } else
                    if(worldObj.getDifficulty() == EnumDifficulty.HARD) {
                        byte0 = 9;
                    }
                
                if(byte0 > 0)
                {
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, byte0 * 20));
                    ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.confusion.id, byte0 * 20));
                }
            }
            return true;
        } else
        {
            return false;
        }
    }
	
	@Override
	protected void dropFewItems(boolean flag, int i) {
        int j = rand.nextInt(3 + i);
        for (int k = 0; k < j; k++) {
            dropItem(Items.gold_nugget, 1);
        }
        
        int j1 = rand.nextInt(3 + i);
        for (int k = 0; k < j1; k++) {
            dropItem(Item.getItemFromBlock(Blocks.sand), 1);
        }
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
            float f = this.getBrightness(1.0F);
            BlockPos blockpos = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(blockpos))
            {
                boolean flag = true;
                ItemStack itemstack = this.getEquipmentInSlot(4);

                if (itemstack != null) {
                    if (itemstack.isItemStackDamageable()) {
                        itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                        if (itemstack.getItemDamage() >= itemstack.getMaxDamage()) {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.setFire(8);
                }
            }
        }
	}
	
	@Override
	protected String getLivingSound() {
		return "undeadplus:mummymoan";
	}

	@Override
	protected String getHurtSound() {
		return "undeadplus:mummyhit";
	}

	@Override
	protected String getDeathSound() {
		return "undeadplus:mummydie";
	} 
	
	@Override
	public void onDeath(DamageSource damagesource) {
		if (damagesource.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)damagesource.getEntity();
			player.addStat(UPAchievements.mummyKill, 1);
		}

		super.onDeath(damagesource);
	} 

}
