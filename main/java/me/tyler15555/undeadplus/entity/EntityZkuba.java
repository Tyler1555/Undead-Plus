package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.ConfigHandler;
import me.tyler15555.undeadplus.util.IClassicEntity;
import me.tyler15555.undeadplus.util.UPConstants;
import net.minecraft.enchantment.Enchantment;
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
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityZkuba extends EntityMob implements IClassicEntity {

	public EntityZkuba(World worldIn) {
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(24D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(2);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.2);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		UPConstants.burnInSunlight(this.worldObj, this);
	}

	@Override
	public void dropRareDrop(int i) {
		ItemStack var2 = new ItemStack(Items.golden_helmet);
    	var2.addEnchantment(Enchantment.respiration, 1);
    	entityDropItem(var2, 0F);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)  {
        if(super.attackEntityAsMob(entity) && ConfigHandler.enableTweaks) {
            if(entity instanceof EntityPlayer) {
                    byte byte0 = 0;
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
                
                if(byte0 > 0) {
                   EntityPlayer player = (EntityPlayer)entity;
                   //The "Watery Grave" combo
                   player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, byte0 * 200, 2));
                   player.addPotionEffect(new PotionEffect(Potion.confusion.id, byte0 * 200, 2));
                   player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 200, 2));
                   player.addPotionEffect(new PotionEffect(Potion.weakness.id, byte0 * 200, 2));
                }
            }
            super.attackEntityAsMob(entity);
            return true;
        } else {
            return false;
        }
    }
	//According to the sounds directory the Zkuba has the same sounds as the buccaneer. No point to implementing them in the JSON file twice
	//TODO: Replace them with my own sounds
	@Override
	public String getLivingSound() {
		return "undeadplus:pirategrowl";
	}
	
	@Override
	public String getHurtSound() {
		return "undeadplus:piratehurt";
	}
	
	@Override
	public String getDeathSound() {
		return "undeadplus:piratedeath";
	}

}
