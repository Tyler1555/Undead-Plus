package me.tyler15555.undeadplus.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
//Much simpler than the old poison ball. Much better to just let vanilla Minecraft handle all the calculations. No point trying to recreate them.
public class EntityPoisonBall extends EntityThrowable {

    public EntityPoisonBall(World world) {
        super(world);
    }
    
    public EntityPoisonBall(World world, EntityLivingBase thrower) {
    	super(world, thrower);
    }
    
    public EntityPoisonBall(World world, EntityLivingBase thrower, double x, double y, double z) {
    	super(world, x, y, z);
    }

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(mop.entityHit != null) {
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0, 0.5D, 0, 0);
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3.0F);
			if(mop.entityHit instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)mop.entityHit;
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 2));
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 2000, 2));
			}
		}
		if (!this.worldObj.isRemote) {
            this.setDead();
        }
	}
	
	@Override
	public void onUpdate() {
		if(!this.isDead) {
			this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX, this.posY, this.posZ, 0, 0.5, 0, 0);
		}
		super.onUpdate();
	}
	

}
         