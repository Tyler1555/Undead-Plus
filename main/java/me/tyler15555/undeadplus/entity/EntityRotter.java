package me.tyler15555.undeadplus.entity;

import java.util.HashMap;

import me.tyler15555.undeadplus.util.ConfigHandler;
import me.tyler15555.undeadplus.util.UPAchievements;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRotter extends EntityMob {

	public EntityRotter(World worldIn) {
		super(worldIn);
		tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        tasks.addTask(2, new EntityAIWander(this, 1.0D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
        tasks.addTask(3, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	} 
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.bone);
	}
	
	@Override
	public void onDeath(DamageSource par1) {
		int i = rand.nextInt(4);

		if (!worldObj.isRemote && i == 3) {
			EntityMaggot entitymaggot = new EntityMaggot(worldObj);
			entitymaggot.setLocationAndAngles(posX, posY + 0.5D, posZ, rand.nextFloat() * 360F, 0.0F);
			worldObj.spawnEntityInWorld(entitymaggot);
		} else if(!worldObj.isRemote && i == 1 && ConfigHandler.enableTweaks) {
			EntityLimb arm = new EntityLimb(this.worldObj);
			arm.copyLocationAndAnglesFrom(this);
			worldObj.spawnEntityInWorld(arm);
		}
			
		if (par1.getEntity() instanceof EntityPlayer) {
				EntityPlayer var2 = (EntityPlayer)par1.getEntity();
				var2.addStat(UPAchievements.rotterKill, 1);
		} 
		super.onDeath(par1);
	}
	
	@Override
	protected String getLivingSound() {
        return "undeadplus:rottermoan";
    }

	@Override
    protected String getHurtSound() {
        return "undeadplus:rotterhit";
    }

	@Override
    protected String getDeathSound(){
        return "undeadplus:rotterdie";
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
}
