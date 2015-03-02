package me.tyler15555.undeadplus.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class EntityAIOpenDoors extends EntityAIDoorInteract {

	boolean field_75361_i;
    int field_75360_j;
    static boolean hasOpenedDoor;
	
	public EntityAIOpenDoors(EntityLiving entity, boolean par2) {
	  super(entity);
	  this.theEntity = entity;
	  this.field_75361_i = par2;
    }

	    
	    public boolean continueExecuting()
	    {
	        return this.field_75361_i && this.field_75360_j > 0 && super.continueExecuting();
	    }

	   
	    public void startExecuting()
	    {
	        this.field_75360_j = 20;
	        this.doorBlock.toggleDoor(this.theEntity.worldObj, this.doorPosition, true);
	        hasOpenedDoor = true;
	        System.out.println(hasOpenedDoor);
	    }

	    /**
	     * Resets the task
	     */
	    public void resetTask()
	    {
	        if (this.field_75361_i)
	        {
	            this.doorBlock.toggleDoor(this.theEntity.worldObj, this.doorPosition, true);
	        }
	    }

	    /**
	     * Updates the task
	     */
	    public void updateTask()
	    {
	        --this.field_75360_j;
	        super.updateTask();
	    }


		@Override
		public boolean shouldExecute() {
			return false;
		}

}
