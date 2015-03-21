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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityInfectedZombie extends EntityMob {

	public EntityInfectedZombie(World worldIn) {
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25F);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if(super.attackEntityAsMob(entity))
		{
			if(entity instanceof EntityLiving)
			{
				byte byte0 = 0;

				if(worldObj.getDifficulty() == EnumDifficulty.EASY)
				{
					byte0 = 4;
				}

				if(worldObj.getDifficulty() == EnumDifficulty.NORMAL)
				{
					byte0 = 7;
				} 
				else
					if(worldObj.getDifficulty() == EnumDifficulty.HARD)
					{
						byte0 = 15;
					}

				if(byte0 > 0)
				{
					((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, byte0 * 20, 0));
				}
			}
			return true;
		} else
		{
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
	protected String getLivingSound() {
		return "undeadplus:infectedmoan";
	}
	
	@Override
	protected String getHurtSound() {
		return "undeadplus:infectedhurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "undeadplus:infecteddeath";
	}
}
