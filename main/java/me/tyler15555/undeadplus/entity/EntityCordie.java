package me.tyler15555.undeadplus.entity;

import java.util.ArrayList;
import java.util.List;

import me.tyler15555.undeadplus.util.UPAchievements;
import me.tyler15555.undeadplus.util.UPConstants;
import net.minecraft.block.BlockFlower;
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
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class EntityCordie extends EntityMob implements IShearable {

	public EntityCordie(World worldIn) {
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
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(16D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(6);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(UPConstants.BASE_MOVESPEED * 0.38);
	}
	

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList();
		ret.add(new ItemStack(Item.getItemFromBlock(Blocks.red_mushroom)));
		
		EntityZombie zombie = new EntityZombie(this.worldObj);
		zombie.copyLocationAndAnglesFrom(this);
		this.worldObj.spawnEntityInWorld(zombie);
		this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX, posY + (double)(height / 2.0F), posZ, 0.0D, 0.0D, 0.0D);
		this.worldObj.removeEntity(this);
		return ret;
	}
	
	@Override
	protected void dropFewItems(boolean flag, int i) {
        int j = rand.nextInt(3 + i);
        for (int k = 0; k < j; k++) {
            this.entityDropItem(new ItemStack(Items.rotten_flesh), 0);
        }        
    }
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		UPConstants.burnInSunlight(this.worldObj, this);
	}
	
	@Override
	protected String getLivingSound() {
        return "undeadplus:cordiemoan";
    }

	@Override
    protected String getHurtSound() {
        return "undeadplus:cordiehit";
    }

	@Override
    protected String getDeathSound() {
        return "undeadplus:cordiedie";
    }
	
	@Override
	public void onDeath(DamageSource damagesource) {
		if (damagesource.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)damagesource.getEntity();
			player.addStat(UPAchievements.cordieKill, 1);
		}

		super.onDeath(damagesource);
	}

}
