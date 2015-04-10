package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.IClassicEntity;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFrostbite extends EntityMob implements IClassicEntity {

	public EntityFrostbite(World worldIn) {
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.245);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(16D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if(super.attackEntityAsMob(entity)) {
			if(entity instanceof EntityLiving) {
				byte byte0 = 0;
				switch(this.worldObj.getDifficulty()) {
				case EASY:
					byte0 = 10;
					break;
				case NORMAL:
					byte0 = 11;
					break;
				case HARD:
					byte0 = 12;
					break;
				default:
					byte0 = 0;
					break;
				}

				if(byte0 > 0) {
					((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 20, 0));
					((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, byte0 * 20, 0));
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	protected void dropFewItems(boolean flag, int i) {
		int j = rand.nextInt(4 + i);
		for (int k = 0; k < j; k++) {
			dropItem(Items.snowball, 1);
		}
	}
	
	@Override
	public Item getDropItem() {
		return Item.getItemFromBlock(Blocks.ice);
	}
	
	@Override
	protected String getLivingSound() {
		return "undeadplus:frostmoan";
	}
	
	@Override
	protected String getHurtSound() {
		return "undeadplus:frosthurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "undeadplus:frostdie";
	}
	
	@Override
	public void onDeath(DamageSource source) {
		if(source.getEntity() != null && source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)source.getEntity();
			player.addStat(UPAchievements.frostKill, 1);
		}
	}

	@Override
	public void dropRareDrop(int i) {
		dropItem(Item.getItemFromBlock(Blocks.ice), 1);
	}

}
