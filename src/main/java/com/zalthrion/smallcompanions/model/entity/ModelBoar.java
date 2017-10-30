package com.zalthrion.smallcompanions.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ModelBoar extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer backLeftLeg;
	public ModelRenderer frontLeftLeg;
	public ModelRenderer backRightLeg;
	public ModelRenderer frontRightLeg;
	public ModelRenderer head;
	public ModelRenderer leftTuskBase;
	public ModelRenderer leftTusk;
	public ModelRenderer rightTuskBase;
	public ModelRenderer rightTusk;
	public ModelRenderer snout;
	
    protected float field_78145_g = 8.0F;
    protected float field_78151_h = 4.0F;
	
    /* Constructors */
    
	public ModelBoar() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.backRightLeg = new ModelRenderer(this, 0, 16);
		this.backRightLeg.setRotationPoint(-3.0F, 17.0F, 5.5F);
		this.backRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.body = new ModelRenderer(this, 28, 8);
		this.body.setRotationPoint(0.0F, 11.0F, 2.0F);
		this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
		this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
		this.rightTusk = new ModelRenderer(this, 0, 0);
		this.rightTusk.setRotationPoint(-2.0F, 1.73F, -9.35F);
		this.rightTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(rightTusk, 2.280098134805392F, 0.0F, 0.0F);
		this.backLeftLeg = new ModelRenderer(this, 0, 16);
		this.backLeftLeg.setRotationPoint(3.0F, 17.0F, 5.5F);
		this.backLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.rightTuskBase = new ModelRenderer(this, 0, 0);
		this.rightTuskBase.setRotationPoint(-2.0F, 0.7F, -9.3F);
		this.rightTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.frontLeftLeg = new ModelRenderer(this, 0, 16);
		this.frontLeftLeg.setRotationPoint(3.0F, 17.0F, -5.0F);
		this.frontLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.snout = new ModelRenderer(this, 16, 16);
		this.snout.setRotationPoint(0.5F, -1.0F, 0.0F);
		this.snout.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F);
		this.leftTusk = new ModelRenderer(this, 0, 0);
		this.leftTusk.setRotationPoint(2.0F, 1.73F, -9.35F);
		this.leftTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(leftTusk, 2.280098134805392F, 0.0F, 0.0F);
		this.frontRightLeg = new ModelRenderer(this, 0, 16);
		this.frontRightLeg.setRotationPoint(-3.0F, 17.0F, -5.0F);
		this.frontRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.leftTuskBase = new ModelRenderer(this, 0, 0);
		this.leftTuskBase.setRotationPoint(2.0F, 0.7F, -9.3F);
		this.leftTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(-0.5F, 13.5F, -6.0F);
		this.head.addBox(-4.0F, -4.0F, -8.0F, 9, 7, 8, 0.0F);
		this.head.addChild(this.rightTusk);
		this.head.addChild(this.rightTuskBase);
		this.head.addChild(this.snout);
		this.head.addChild(this.leftTusk);
		this.head.addChild(this.leftTuskBase);
	}
	
	/* Custom Methods */
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	/* Overridden */
	
	@Override public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		if (this.isChild) {
			float f6 = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
			GlStateManager.translate(0.0F, field_78145_g * scale, field_78151_h * scale);
			this.head.render(scale);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.frontRightLeg.render(scale);
			this.frontLeftLeg.render(scale);
			this.backLeftLeg.render(scale);
			this.backRightLeg.render(scale);
			this.body.render(scale);
			GlStateManager.popMatrix();
		} else {
			this.head.render(scale);
			this.frontRightLeg.render(scale);
			this.frontLeftLeg.render(scale);
			this.backLeftLeg.render(scale);
			this.backRightLeg.render(scale);
			this.body.render(scale);
		}
	}
	
	@Override public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);
		this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.frontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.frontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.backLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.backRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}