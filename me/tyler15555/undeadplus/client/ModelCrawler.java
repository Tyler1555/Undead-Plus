package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrawler extends ModelBase {
	
		ModelRenderer Shape3;
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer Shape1;
		ModelRenderer Shape2;

		public ModelCrawler() {
			textureWidth = 64;
			textureHeight = 32;

			Shape3 = new ModelRenderer(this, 0, 16);
			Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
			Shape3.setRotationPoint(0F, 23.5F, 9.5F);
			Shape3.setTextureSize(64, 32);
			Shape3.mirror = true;
			setRotation(Shape3, 1.01983F, 0F, 0F);
			head = new ModelRenderer(this, 0, 0);
			head.addBox(-4F, -8F, -4F, 8, 8, 8);
			head.setRotationPoint(0F, 14F, 0F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			body = new ModelRenderer(this, 16, 16);
			body.addBox(-4F, 0F, -2F, 8, 12, 4);
			body.setRotationPoint(0F, 14F, -1F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0.7853982F, 0F, 0F);
			rightarm = new ModelRenderer(this, 40, 16);
			rightarm.addBox(-3F, -2F, -2F, 4, 11, 4);
			rightarm.setRotationPoint(-5F, 15F, 0F);
			rightarm.setTextureSize(64, 32);
			rightarm.mirror = true;
			setRotation(rightarm, 0F, 0F, 0F);
			leftarm = new ModelRenderer(this, 40, 16);
			leftarm.addBox(-1F, -2F, -2F, 4, 11, 4);
			leftarm.setRotationPoint(5F, 15F, 0F);
			leftarm.setTextureSize(64, 32);
			leftarm.mirror = true;
			setRotation(leftarm, 0F, 0F, 0F);
			Shape1 = new ModelRenderer(this, 0, 16);
			Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
			Shape1.setRotationPoint(0F, 22F, 8F);
			Shape1.setTextureSize(64, 32);
			Shape1.mirror = true;
			setRotation(Shape1, 0.7853982F, 0F, 0F);
			Shape2 = new ModelRenderer(this, 0, 16);
			Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
			Shape2.setRotationPoint(0F, 22.75F, 8.75F);
			Shape2.setTextureSize(64, 32);
			Shape2.mirror = true;
			setRotation(Shape2, 0.6981317F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5);
			Shape3.render(f5);
			head.render(f5);
			body.render(f5);
			rightarm.render(f5);
			leftarm.render(f5);
			Shape1.render(f5);
			Shape2.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
			head.rotateAngleY = f3 / 57.29578F;
			head.rotateAngleX = f4 / 57.29578F;
			rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;
			/*rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
			rightleg.rotateAngleY = 0.0F;
			leftleg.rotateAngleY = 0.0F;*/
			if (isRiding) {
				rightarm.rotateAngleX += -0.6283185F;
				leftarm.rotateAngleX += -0.6283185F;
				/*rightleg.rotateAngleX = -1.256637F;
				leftleg.rotateAngleX = -1.256637F;
				rightleg.rotateAngleY = 0.3141593F;
				leftleg.rotateAngleY = -0.3141593F;*/
			}
			rightarm.rotateAngleY = 0.0F;
			leftarm.rotateAngleY = 0.0F;
			/*if (onGround > -9990F)
			{
				float f6 = onGround;
				body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
				rightarm.rotationPointZ = MathHelper.sin(body.rotateAngleY) * 5F;
				rightarm.rotationPointX = -MathHelper.cos(body.rotateAngleY) * 5F;
				leftarm.rotationPointZ = -MathHelper.sin(body.rotateAngleY) * 5F;
				leftarm.rotationPointX = MathHelper.cos(body.rotateAngleY) * 5F;
				rightarm.rotateAngleY += body.rotateAngleY;
				leftarm.rotateAngleY += body.rotateAngleY;
				leftarm.rotateAngleX += body.rotateAngleY;
				f6 = 1.0F - onGround;
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				float f8 = MathHelper.sin(f6 * 3.141593F);
				float f10 = MathHelper.sin(onGround * 3.141593F) * -(head.rotateAngleX - 0.7F) * 0.75F;
				rightarm.rotateAngleX -= (double)f8 * 1.2D + (double)f10;
				rightarm.rotateAngleY += body.rotateAngleY * 2.0F;
				rightarm.rotateAngleZ = MathHelper.sin(onGround * 3.141593F) * -0.4F;
			} */


			rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;


	}
}
