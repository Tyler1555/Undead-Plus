package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZkuba extends ModelBase {

	ModelRenderer frontplate;
	ModelRenderer backplate;
	ModelRenderer helmet;
	ModelRenderer body;
	ModelRenderer rightArm;
	ModelRenderer leftArm;
	ModelRenderer rightLeg;
	ModelRenderer leftLeg;

	public ModelZkuba() {
		textureWidth = 64;
		textureHeight = 64;

		frontplate = new ModelRenderer(this, 32, 35);
		frontplate.addBox(-4F, -4.5F, -0.5F, 8, 9, 1);
		frontplate.setRotationPoint(0F, 6F, -3.5F);
		frontplate.setTextureSize(64, 64);
		frontplate.mirror = true;
		setRotation(frontplate, 0F, 0F, 0F);
		backplate = new ModelRenderer(this, 32, 46);
		backplate.addBox(-4F, -4.5F, -0.5F, 8, 9, 1);
		backplate.setRotationPoint(0F, 6F, 3.5F);
		backplate.setTextureSize(64, 64);
		backplate.mirror = true;
		setRotation(backplate, 0F, 0F, 0F);
		helmet = new ModelRenderer(this, 0, 0);
		helmet.addBox(-4F, -8F, -4F, 8, 8, 8);
		helmet.setRotationPoint(0F, 0F, 0F);
		helmet.setTextureSize(64, 64);
		helmet.mirror = true;
		setRotation(helmet, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-5F, 0F, -3F, 10, 12, 6);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightArm = new ModelRenderer(this, 32, 16);
		rightArm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightArm.setRotationPoint(-6F, 2F, 0F);
		rightArm.setTextureSize(64, 64);
		rightArm.mirror = true;
		setRotation(rightArm, 0F, 0F, 0F);
		leftArm = new ModelRenderer(this, 32, 16);
		leftArm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftArm.setRotationPoint(6F, 2F, 0F);
		leftArm.setTextureSize(64, 64);
		leftArm.mirror = true;
		setRotation(leftArm, 0F, 0F, 0F);
		leftArm.mirror = false;
		rightLeg = new ModelRenderer(this, 0, 35);
		rightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightLeg.setRotationPoint(-2F, 12F, 0F);
		rightLeg.setTextureSize(64, 64);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0F, 0F, 0F);
		leftLeg = new ModelRenderer(this, 0, 35);
		leftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftLeg.setRotationPoint(2F, 12F, 0F);
		leftLeg.setTextureSize(64, 64);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0F, 0F, 0F);
		leftLeg.mirror = false;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		frontplate.render(f5);
		backplate.render(f5);
		helmet.render(f5);
		body.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		helmet.rotateAngleY = f3 / 57.29578F;
		helmet.rotateAngleX = f4 / 57.29578F;
		rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
		leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		rightArm.rotateAngleZ = 0.0F;
		leftArm.rotateAngleZ = 0.0F;
		rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		rightLeg.rotateAngleY = 0.0F;
		leftLeg.rotateAngleY = 0.0F;
		if (isRiding) {
			rightArm.rotateAngleX += -0.6283185F;
			leftArm.rotateAngleX += -0.6283185F;
			rightLeg.rotateAngleX = -1.256637F;
			leftLeg.rotateAngleX = -1.256637F;
			rightLeg.rotateAngleY = 0.3141593F;
			leftLeg.rotateAngleY = -0.3141593F;
		}
		rightArm.rotateAngleY = 0.0F;
		leftArm.rotateAngleY = 0.0F;
		rightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
		leftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
		rightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
		leftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
	}
}

