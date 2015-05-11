package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.IClassicEntity;
import me.tyler15555.undeadplus.util.UPAchievements;
import me.tyler15555.undeadplus.util.UPConstants;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityScorcher extends EntityMob implements IClassicEntity {

	public EntityScorcher(World worldIn) {
		super(worldIn);
		this.isImmuneToFire = true;
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(6);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.40);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
	     if(entity instanceof EntityPlayer) {
				((EntityPlayer)entity).setFire(8);
		 }
			return true;
		
	}
	
	@Override
	public Item getDropItem() {
		return Items.fire_charge;
	}
	
	@Override
	public void dropRareDrop(int i) {
		switch (this.rand.nextInt(4))
		{
		case 0:
			this.dropItem(Items.chainmail_chestplate, 1);
			break;
		case 1:
			this.dropItem(Items.chainmail_helmet, 1);
			break;
		case 2:
			this.dropItem(Items.chainmail_leggings, 1);
			break;
		case 3:
			this.dropItem(Items.chainmail_boots, 1);
			break;
		}
	}
	
	@Override
	public void onDeath(DamageSource damagesource) {
		if (damagesource.getEntity() instanceof EntityPlayer) {
			EntityPlayer var2 = (EntityPlayer)damagesource.getEntity();
			var2.triggerAchievement(UPAchievements.scorchKill);
		}
		super.onDeath(damagesource);
	}
	
	@Override
	protected String getLivingSound() {
		return "undeadplus:scorchmoan";
	}
	
	@Override
	protected String getHurtSound() {
		return "undeadplus:scorchhit";
	}
	
	@Override
	protected String getDeathSound() {
		return "undeadplus:scorchdie";
	}

}
