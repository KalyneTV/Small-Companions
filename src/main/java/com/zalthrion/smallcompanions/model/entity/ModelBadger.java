package com.zalthrion.smallcompanions.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.smallcompanions.entity.EntityFancyBadger;

/**
 * Badger - Zalthrion
 * Created using Tabula 4.1.1
 */
@SideOnly(Side.CLIENT) public class ModelBadger extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer BottomLeftLeg;
	public ModelRenderer BottomRightLeg;
	public ModelRenderer TopLeftLeg;
	public ModelRenderer TopRightLeg;
	public ModelRenderer Tail;
	public ModelRenderer TopHatBase;
	public ModelRenderer Head;
	public ModelRenderer TopHatTop;
	public ModelRenderer Mouth;
	public ModelRenderer RightEar;
	public ModelRenderer LeftEar;
	public ModelRenderer Nose;
	
	public ModelBadger() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(-3.0F, 15.0F, -5.0F);
		this.Body.addBox(-1.0F, 0.0F, 0.0F, 8, 7, 11, 0.0F);
		this.Nose = new ModelRenderer(this, 0, 0);
		this.Nose.setRotationPoint(1.5F, 1.2F, -0.4F);
		this.Nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(Nose, 0.0F, 0.0F, -0.007504915783575617F);
		this.BottomLeftLeg = new ModelRenderer(this, 30, 20);
		this.BottomLeftLeg.setRotationPoint(0.6F, 20.0F, 2.4F);
		this.BottomLeftLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.TopRightLeg = new ModelRenderer(this, 30, 20);
		this.TopRightLeg.setRotationPoint(-3.6F, 20.0F, -4.4F);
		this.TopRightLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.LeftEar = new ModelRenderer(this, 47, 20);
		this.LeftEar.setRotationPoint(3.7F, -0.6F, 2.0F);
		this.LeftEar.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.TopLeftLeg = new ModelRenderer(this, 30, 20);
		this.TopLeftLeg.setRotationPoint(0.6F, 20.0F, -4.4F);
		this.TopLeftLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.Mouth = new ModelRenderer(this, 45, 12);
		this.Mouth.setRotationPoint(0.5F, 1.5F, -2.0F);
		this.Mouth.addBox(0.0F, 0.0F, 0.0F, 4, 3, 2, 0.0F);
		this.setRotateAngle(Mouth, 0.12845623294678266F, 0.0F, 0.0F);
		this.BottomRightLeg = new ModelRenderer(this, 30, 20);
		this.BottomRightLeg.setRotationPoint(-3.6F, 20.0F, 2.4F);
		this.BottomRightLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
		this.Tail = new ModelRenderer(this, 5, 20);
		this.Tail.setRotationPoint(-1.5F, 16.0F, 4.4F);
		this.Tail.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
		this.setRotateAngle(Tail, -0.7740535232594852F, 0.0F, 0.0F);
		this.TopHatBase = new ModelRenderer(this, 40, 24);
		this.TopHatBase.setRotationPoint(-3.0F, 14.6F, -10.5F);
		this.TopHatBase.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
		this.setRotateAngle(TopHatBase, 0.10646508437165408F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 40, 0);
		this.Head.setRotationPoint(-2.5F, 15.0F, -10.0F);
		this.Head.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
		this.setRotateAngle(Head, 0.10646508437165408F, 0.0F, 0.0F);
		this.RightEar = new ModelRenderer(this, 47, 20);
		this.RightEar.setRotationPoint(-0.7F, -0.6F, 2.0F);
		this.RightEar.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.TopHatTop = new ModelRenderer(this, 25, 29);
		this.TopHatTop.setRotationPoint(1.0F, -3.0F, 1.0F);
		this.TopHatTop.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
		this.Mouth.addChild(this.Nose);
		this.Head.addChild(this.LeftEar);
		this.Head.addChild(this.Mouth);
		this.Head.addChild(this.RightEar);
		this.TopHatBase.addChild(this.TopHatTop);
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
		
		this.Head.render(scale);
		this.Tail.render(scale);
		this.Body.render(scale);
		this.BottomLeftLeg.render(scale);
		this.TopRightLeg.render(scale);
		this.BottomRightLeg.render(scale);
		this.TopLeftLeg.render(scale);
		
		if (entityIn instanceof EntityFancyBadger) {
			this.TopHatBase.render(scale);
		}
	}
	
	@Override public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.Tail.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * -0.5F;
		this.TopLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BottomLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.TopRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.BottomRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}