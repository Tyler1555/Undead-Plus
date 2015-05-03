package me.tyler15555.undeadplus.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBuccaneer extends ModelBiped {

	public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightArm;
    public ModelRenderer leftArm;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
	
    public ModelBuccaneer() {
        this(0.0F);
    }

    public ModelBuccaneer(float par1)  {
        this(par1, 0.0F, 64, 32);
    }
    
	public ModelBuccaneer(float par1, float par2, int par3, int par) {
		super();
		this.bipedHead.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedRightLeg.isHidden = true;
		this.bipedLeftLeg.isHidden = true;
		
		this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
        this.body.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        //this.rightArm = new ModelRenderer(this, 40, 16);
        //this.rightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        //this.rightArm.setRotationPoint(-5.0F, 2.0F + par2, 0.0F);
        this.leftArm = new ModelRenderer(this, 40, 16);
        this.leftArm.mirror = true;
        this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        this.leftArm.setRotationPoint(5.0F, 2.0F + par2, 0.0F);
        this.rightLeg = new ModelRenderer(this, 0, 16);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.rightLeg.setRotationPoint(-1.9F, 12.0F + par2, 0.0F);
        this.leftLeg = new ModelRenderer(this, 0, 16);
        this.leftLeg.mirror = true;
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.leftLeg.setRotationPoint(1.9F, 12.0F + par2, 0.0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (this.isChild) {
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
            GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
            this.head.render(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.body.render(par7);
            //this.rightArm.render(par7);
            this.leftArm.render(par7);
            this.rightLeg.render(par7);
            this.leftLeg.render(par7);
            GL11.glPopMatrix();
        } else {
            this.head.render(par7);
            this.body.render(par7);
            super.bipedRightArm.render(par7);
            this.leftArm.render(par7);
            this.rightLeg.render(par7);
            this.leftLeg.render(par7);
        }
    }
		@Override
	    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
	    	this.head.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
	        this.head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
	        super.bipedRightArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 2.0F * p_78087_2_ * 0.5F;
	        this.leftArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
	        super.bipedRightArm.rotateAngleZ = 0.0F;
	        this.leftArm.rotateAngleZ = 0.0F;
	        this.rightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
	        this.leftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
	        this.rightLeg.rotateAngleY = 0.0F;
	        this.leftLeg.rotateAngleY = 0.0F;
	        float f6 = MathHelper.sin(0 * (float)Math.PI);
	        float f7 = MathHelper.sin((1.0F - (1.0F - 0) * (1.0F - 0)) * (float)Math.PI);
	        super.bipedRightArm.rotateAngleZ = 0.0F;
	        this.leftArm.rotateAngleZ = 0.0F;
	        super.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
	        this.leftArm.rotateAngleY = 0.1F - f6 * 0.6F;
	        super.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F);
	        this.leftArm.rotateAngleX = -((float)Math.PI / 2F);
	        super.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
	        this.leftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
	        super.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
	        this.leftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
	        super.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
	        this.leftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
	    }

}
