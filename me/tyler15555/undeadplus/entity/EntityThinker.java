package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.UPAchievements;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityThinker extends EntityMob {

	public EntityThinker(World world) {
		super(world);
		experienceValue = 5;
		((PathNavigateGround)this.getNavigator()).func_179688_b(true); //Sets door breaking
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIBreakDoor(this));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
		tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
		tasks.addTask(0, new EntityAIOpenDoor(this, true));
		tasks.addTask(8, new EntityAIWander(this, 1.0D));
		tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
		tasks.addTask(10, new EntityAILookIdle(this));
        tasks.addTask(4, new EntityAIFleeSun(this, 1.0D));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
	}

	protected void dropFewItems(boolean b, int i)
	{
		super.dropFewItems(b, i);

		int j = rand.nextInt(3 + i);
		for (int k = 0; k < j; k++)
		{
			dropItem(Items.paper, 1);
		}
		dropRareDrop(1);
	}

	protected void dropRareDrop(int i)
	{
		dropItem(Items.book, 1);
	}
	@Override
	public void onDeath(DamageSource damagesource) {
		if (damagesource.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)damagesource.getEntity();
			player.addStat(UPAchievements.thinkerKill, 1);
		}

		super.onDeath(damagesource);
	} 
	/*
	protected String getLivingSound()
	{
		return "undeadPlusAudio.mobs.thinker.growl";
	}

	protected String getHurtSound()
	{
		return "undeadPlusAudio.mobs.thinker.hit";
	}

	protected String getDeathSound()
	{
		return "undeadPlusAudio.mobs.thinker.die";
	} */

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

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

	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 64D);

		if (entityplayer != null && canEntityBeSeen(entityplayer))
		{
			return entityplayer;
		}
		else
		{
			return null;
		}
	}

	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(16, new Byte((byte)0));
	}

	public boolean isOnLadder() {
		return func_40149_l_();
	}

	public boolean func_40149_l_() {
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

}
