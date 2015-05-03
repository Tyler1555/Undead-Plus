package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.IClassicEntity;
import me.tyler15555.undeadplus.util.UPAchievements;
import me.tyler15555.undeadplus.util.UPConstants;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBrute extends EntityMob implements IClassicEntity {

	public EntityBrute(World worldIn) {
		super(worldIn);
        setSize(1F, 2.1F);
        
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
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(60D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(8);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.2);
	}
	
	@Override
	protected void dropFewItems(boolean flag, int i) {
        int j = rand.nextInt(3 + i);
        for (int k = 0; k < j; k++) {
            dropItem(Items.rotten_flesh, 1);
        }

        j = rand.nextInt(3 + i);
        for (int l = 0; l < j; l++) {
            dropItem(Items.bone, 1);
        }
        
    }

	@Override
	public void dropRareDrop(int i) {
		dropItem(Items.experience_bottle, 1);
	}
	
	@Override
	public void onDeath(DamageSource source) {
		if(source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) source.getEntity();
			player.addStat(UPAchievements.bruteKill, 1);
		}
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
        UPConstants.burnInSunlight(this.worldObj, this);
	}
	
	@Override
	public String getLivingSound() {
		return "undeadplus:brutemoan";
	}
	
	@Override
	public String getHurtSound() {
		return "undeadplus:brutehurt";
	}
	
	@Override
	public String getDeathSound() {
		return "undeadplus:brutedie";
	}

}
