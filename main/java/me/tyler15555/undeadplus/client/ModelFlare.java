package me.tyler15555.undeadplus.client;

import me.tyler15555.undeadplus.entity.EntityFlare;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class ModelFlare extends ModelZombie {

	  public ModelFlare() {
	    this(0.0F);
	  }

	  public ModelFlare(float par1) {
	      super(par1, 0.0F, 64, 32);
	      this.bipedRightArm = new ModelRenderer(this, 40, 16);
	      this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, par1);
	      this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
	      this.bipedLeftArm = new ModelRenderer(this, 40, 16);
	      this.bipedLeftArm.mirror = true;
	      this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, par1);
	      this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
	      this.bipedRightLeg = new ModelRenderer(this, 0, 16);
	      this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, par1);
	      this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
	      this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
	      this.bipedLeftLeg.mirror = true;
	      this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, par1);
	      this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
	    }
}
