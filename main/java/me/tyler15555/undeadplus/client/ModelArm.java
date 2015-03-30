package me.tyler15555.undeadplus.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArm extends ModelBase {
    ModelRenderer limbBase;
    ModelRenderer limbBone;
  
  public ModelArm() {
      textureWidth = 64;
      textureHeight = 32;
    
      limbBase = new ModelRenderer(this, 0, 0);
      limbBase.addBox(0F, 0F, 0F, 4, 4, 12);
      limbBase.setRotationPoint(0F, 20F, -8F);
      limbBase.setTextureSize(64, 32);
      limbBase.mirror = true;
      setRotation(limbBase, 0F, 0F, 0F);
      limbBone = new ModelRenderer(this, 0, 0);
      limbBone.addBox(0F, 0F, 0F, 2, 2, 6);
      limbBone.setRotationPoint(1F, 21F, 4F);
      limbBone.setTextureSize(64, 32);
      limbBone.mirror = true;
      setRotation(limbBone, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    limbBase.render(f5);
    limbBone.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
