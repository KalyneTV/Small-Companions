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
//TODO Check all mappings, reorganize methods
@SideOnly(Side.CLIENT) public class ModelSavageBadger extends ModelBase {
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
	public ModelRenderer SaddleBase;
	public ModelRenderer SaddleBack;
	public ModelRenderer SaddleLeftString;
	public ModelRenderer SaddleFront;
	public ModelRenderer SaddleRightString;
	public ModelRenderer SaddleLeftMetal;
	public ModelRenderer SaddleRightMetal;
	
	public ModelSavageBadger() {
		this.textureWidth = 128;
		this.textureHeight = 128;
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
		
		this.SaddleBase = new ModelRenderer(this, 80, 0);
		this.SaddleBase.setRotationPoint(-4.5F, 14.0F, -3.5F);
		this.SaddleBase.addBox(0.0F, 0.0F, 0.0F, 9, 1, 8, 0.0F);
		
		this.SaddleBack = new ModelRenderer(this, 80, 9);
		this.SaddleBack.setRotationPoint(1.0F, -1.0F, 6.0F);
		this.SaddleBack.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
		this.SaddleFront = new ModelRenderer(this, 106, 9);
		this.SaddleFront.setRotationPoint(3.5F, -1.0F, 0.0F);
		this.SaddleFront.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		
		this.SaddleLeftString = new ModelRenderer(this, 70, 0);
		this.SaddleLeftString.setRotationPoint(8.4F, 1.0F, 2.0F);
		this.SaddleLeftString.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		
		this.SaddleLeftMetal = new ModelRenderer(this, 74, 0);
		this.SaddleLeftMetal.setRotationPoint(0.0F, 4.0F, -0.5F);
		this.SaddleLeftMetal.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
		
		this.SaddleRightString = new ModelRenderer(this, 80, 0);
		this.SaddleRightString.setRotationPoint(-0.4F, 1.0F, 2.0F);
		this.SaddleRightString.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		
		this.SaddleRightMetal = new ModelRenderer(this, 74, 4);
		this.SaddleRightMetal.setRotationPoint(0.0F, 4.0F, -0.5F);
		this.SaddleRightMetal.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
		
		this.Mouth.addChild(this.Nose);
		this.Head.addChild(this.LeftEar);
		this.Head.addChild(this.Mouth);
		this.Head.addChild(this.RightEar);
		this.TopHatBase.addChild(this.TopHatTop);
		this.SaddleBase.addChild(this.SaddleBack);
		this.SaddleBase.addChild(this.SaddleFront);
		this.SaddleBase.addChild(this.SaddleLeftString);
		this.SaddleLeftString.addChild(this.SaddleLeftMetal);
		this.SaddleRightString.addChild(this.SaddleRightMetal);
		this.SaddleBase.addChild(this.SaddleRightString);
		
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		this.Head.render(f5);
		this.Tail.render(f5);
		this.Body.render(f5);
		this.BottomLeftLeg.render(f5);
		this.TopRightLeg.render(f5);
		this.BottomRightLeg.render(f5);
		this.TopLeftLeg.render(f5);
		
		this.SaddleBase.render(f5);
		
		if (entity instanceof EntityFancyBadger) {
			this.TopHatBase.render(f5);
		}
		
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		
		this.Tail.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * -0.5F;
		
		this.TopLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
		this.BottomLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.TopRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.BottomRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
	}
}