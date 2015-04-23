package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrute extends ModelBase {

	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	
	public ModelBrute() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 10, 10, 10);
		head.setRotationPoint(0F, -5F, 0F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 55, 44);
		body.addBox(-4F, 0F, -2F, 10, 14, 6);
		body.setRotationPoint(0F, -3F, 0F);
		body.setTextureSize(128, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 0, 44);
		rightarm.addBox(-3F, -2F, -2F, 6, 14, 6);
		rightarm.setRotationPoint(-7F, -1F, 0F);
		rightarm.setTextureSize(128, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 0, 44);
		leftarm.addBox(-1F, -2F, -2F, 6, 14, 6);
		leftarm.setRotationPoint(7F, -1F, 0F);
		leftarm.setTextureSize(128, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 30, 45);
		rightleg.addBox(-2F, 0F, -2F, 5, 13, 6);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(128, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 30, 45);
		leftleg.addBox(-2F, 0F, -2F, 5, 13, 6);
		leftleg.setRotationPoint(3F, 11F, 0F);
		leftleg.setTextureSize(128, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}

	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		head.rotateAngleY = f3 / 57.29578F;
		head.rotateAngleX = f4 / 57.29578F;
		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;
		if (isRiding) {
			rightarm.rotateAngleX += -0.6283185F;
			leftarm.rotateAngleX += -0.6283185F;
			rightleg.rotateAngleX = -1.256637F;
			leftleg.rotateAngleX = -1.256637F;
			rightleg.rotateAngleY = 0.3141593F;
			leftleg.rotateAngleY = -0.3141593F;
		}
		rightarm.rotateAngleY = 0.0F;
		leftarm.rotateAngleY = 0.0F;
		rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;


	}

}
