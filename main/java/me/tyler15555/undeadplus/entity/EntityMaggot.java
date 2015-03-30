package me.tyler15555.undeadplus.entity;

import me.tyler15555.undeadplus.util.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.World;

public class EntityMaggot extends EntitySilverfish {

	public EntityMaggot(World worldIn) {
		super(worldIn);
		this.setSize(0.3F, 0.7F);
		this.experienceValue = 2;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.275);
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		super.attackEntityAsMob(entity);
		if(this.rand.nextInt(3) == 1 && ConfigHandler.enableTweaks) {
			this.heal(1); //My own touch, since maggots eat flesh in real life
		}
		return true;
	}

}
