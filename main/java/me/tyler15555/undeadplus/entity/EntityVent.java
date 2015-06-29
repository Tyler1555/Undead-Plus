package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.UPAchievements;
import me.tyler15555.undeadplus.util.UPConstants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityVent extends EntityMob implements IRangedAttackMob {

	public EntityVent(World worldIn) {
		super(worldIn);
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsTarget(this, 1.0D, 16.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(20);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.3D);
	}
	
	@Override
	public Item getDropItem() {
		return Items.gunpowder;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
		EntityPoisonBall ball = new EntityPoisonBall(worldObj, this);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(ball);
	}
	
	@Override
	public void onLivingUpdate() {
		for (float i = 0.1F; i < 0.3F; i++) {
			worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, posX + (rand.nextDouble() - 0.5D) * (double)width, posY + rand.nextDouble() * (double)height, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0.0D, 0.0D, 0.0D);
		}
		super.onLivingUpdate();
	}
	
	@Override
	public void onDeath(DamageSource source) {
		EntityPotion entitypotion = new EntityPotion(worldObj);
		entitypotion.posY = posY + (double)(height) + 0.5D;
		worldObj.spawnEntityInWorld(new EntityPotion(worldObj, this, 16388));

		if (source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)source.getEntity();
			player.addStat(UPAchievements.ventKill, 1);
		}
		super.onDeath(source);
	}
	
	@Override
	protected String getLivingSound() {
		return "undeadplus:ventmoan";
	}
	
	@Override
	protected String getHurtSound() {
		return "undeadplus:venthurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "undeadplus:ventdie";
	}

}
