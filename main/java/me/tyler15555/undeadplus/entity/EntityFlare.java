package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.UPConstants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlare extends EntityMob implements IRangedAttackMob {

	public EntityFlare(World worldIn) {
		super(worldIn);
		isImmuneToFire = true;
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAIRestrictSun(this));
		tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		tasks.addTask(4, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		tasks.addTask(5, new EntityAIWander(this, 1.0D));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
		tasks.addTask(6, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, false));
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        entityarrow.setDamage((double)(p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));

        if (i > 0) {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0) {
            entityarrow.setKnockbackStrength(j);
        }

        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0) {
            entityarrow.setFire(100);
        }

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(16D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.4);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		UPConstants.burnInSunlight(this.worldObj, this);
	}
	
	@Override
	public Item getDropItem() {
		return Items.arrow;
	}
	
	@Override
	protected void dropFewItems(boolean flag, int i) {
		int j = rand.nextInt(3 + i);
		for (int k = 0; k < j; k++) {
			dropItem(Items.arrow, 1);
		}

		j = rand.nextInt(3 + i);
		for (int l = 0; l < j; l++)
		{
			dropItem(Items.coal, 1);
		}
	}

	@Override
	public void dropRareDrop(int i) {
		ItemStack var2 = new ItemStack(Items.bow);
		var2.addEnchantment(Enchantment.flame, 1);
		this.entityDropItem(var2, 0F);
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.bow);
	}
	
	@Override
	public String getLivingSound() {
		return "undeadplus:flaremoan";
	}
	
	@Override
	public String getHurtSound() {
		return "undeadplus:flarehurt";
	}
	
	@Override
	public String getDeathSound() {
		return "undeadplus:flaredie";
	}

}
