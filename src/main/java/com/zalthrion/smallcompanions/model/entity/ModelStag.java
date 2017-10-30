package com.zalthrion.smallcompanions.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** ModelDeer - Zalthrion Created using Tabula 4.1.1 */

//TODO Check all mappings, reorganize methods
@SideOnly(Side.CLIENT) public class ModelStag extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer Neck;
	public ModelRenderer FrontLeftLeg;
	public ModelRenderer FrontRightLeg;
	public ModelRenderer BackLeftLeg;
	public ModelRenderer BackRightLeg;
	public ModelRenderer Tail;
	public ModelRenderer Head;
	public ModelRenderer RightAntler;
	public ModelRenderer LeftAntler;
	public ModelRenderer LeftTopAntler;
	public ModelRenderer RightTopAntler;
	public ModelRenderer RightEar;
	public ModelRenderer LeftEar;
	public ModelRenderer Nose;
	public ModelRenderer FrontBottomLeftLeg;
	public ModelRenderer FrontLeftHoof;
	public ModelRenderer FrontBottomRightLeg;
	public ModelRenderer FrontRightHoof;
	public ModelRenderer BackBottomLeftLeg;
	public ModelRenderer BackLeftHoof;
	public ModelRenderer BackBottomRightLeg;
	public ModelRenderer BackRightHoof;
	
	public ModelStag() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.Nose = new ModelRenderer(this, 11, 2);
		this.Nose.setRotationPoint(1.5F, -0.2F, -0.2F);
		this.Nose.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.BackLeftHoof = new ModelRenderer(this, 67, 12);
		this.BackLeftHoof.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.BackLeftHoof.addBox(0.0F, 0.0F, -0.2F, 3, 2, 3, 0.0F);
		this.BackBottomRightLeg = new ModelRenderer(this, 58, 12);
		this.BackBottomRightLeg.setRotationPoint(0.5F, 4.0F, 0.5F);
		this.BackBottomRightLeg.addBox(0.0F, 0.0F, -0.2F, 2, 3, 2, 0.0F);
		this.FrontBottomRightLeg = new ModelRenderer(this, 58, 12);
		this.FrontBottomRightLeg.setRotationPoint(0.5F, 4.0F, 0.5F);
		this.FrontBottomRightLeg.addBox(0.0F, 0.0F, -0.2F, 2, 3, 2, 0.0F);
		this.LeftAntler = new ModelRenderer(this, 21, 6);
		this.LeftAntler.setRotationPoint(8.5F, -4.1F, 7.7F);
		this.LeftAntler.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
		this.setRotateAngle(LeftAntler, 0.0F, 0.0F, 0.778067780539072F);
		this.BackBottomLeftLeg = new ModelRenderer(this, 58, 12);
		this.BackBottomLeftLeg.setRotationPoint(0.5F, 4.0F, 0.5F);
		this.BackBottomLeftLeg.addBox(0.0F, 0.0F, -0.2F, 2, 3, 2, 0.0F);
		this.LeftTopAntler = new ModelRenderer(this, 28, 8);
		this.LeftTopAntler.setRotationPoint(5.0F, -5.1F, 7.7F);
		this.LeftTopAntler.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(LeftTopAntler, 0.0F, 0.0F, 5.999743836655707F);
		this.LeftEar = new ModelRenderer(this, 112, 17);
		this.LeftEar.setRotationPoint(4.8F, -1.3F, 6.7F);
		this.LeftEar.addBox(0.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(LeftEar, 0.0F, 0.0F, -5.503546730313719F);
		this.FrontLeftLeg = new ModelRenderer(this, 62, 2);
		this.FrontLeftLeg.setRotationPoint(1.1F, 15.0F, -10.1F);
		this.FrontLeftLeg.addBox(0.0F, 0.0F, -0.2F, 3, 5, 3, 0.0F);
		this.RightTopAntler = new ModelRenderer(this, 28, 8);
		this.RightTopAntler.setRotationPoint(-0.5F, -5.2F, 7.7F);
		this.RightTopAntler.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(RightTopAntler, 0.0F, 0.0F, -5.999743836655707F);
		this.Tail = new ModelRenderer(this, 10, 6);
		this.Tail.setRotationPoint(-1.5F, 0.55F, 19.1F);
		this.Tail.addBox(0.0F, 0.0F, 0.0F, 3, 4, 1, 0.0F);
		this.setRotateAngle(Tail, -5.860216741864899F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 80, 17);
		this.Head.setRotationPoint(0.0F, 6.4F, -6.3F);
		this.Head.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
		this.setRotateAngle(Head, 0.9560913642424937F, 0.0F, 0.0F);
		this.FrontBottomLeftLeg = new ModelRenderer(this, 58, 12);
		this.FrontBottomLeftLeg.setRotationPoint(0.5F, 4.0F, 0.5F);
		this.FrontBottomLeftLeg.addBox(0.0F, 0.0F, -0.2F, 2, 3, 2, 0.0F);
		this.BackLeftLeg = new ModelRenderer(this, 62, 2);
		this.BackLeftLeg.setRotationPoint(1.1F, 15.0F, 7.1F);
		this.BackLeftLeg.addBox(0.0F, 0.0F, -0.2F, 3, 5, 3, 0.0F);
		this.FrontRightHoof = new ModelRenderer(this, 67, 12);
		this.FrontRightHoof.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.FrontRightHoof.addBox(0.0F, 0.0F, -0.2F, 3, 2, 3, 0.0F);
		this.FrontLeftHoof = new ModelRenderer(this, 67, 12);
		this.FrontLeftHoof.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.FrontLeftHoof.addBox(0.0F, 0.0F, -0.2F, 3, 2, 3, 0.0F);
		this.RightAntler = new ModelRenderer(this, 21, 6);
		this.RightAntler.setRotationPoint(-4.0F, -3.1F, 7.7F);
		this.RightAntler.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
		this.setRotateAngle(RightAntler, 0.0F, 0.0F, -0.8154178265317507F);
		this.BackRightHoof = new ModelRenderer(this, 67, 12);
		this.BackRightHoof.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.BackRightHoof.addBox(0.0F, 0.0F, -0.2F, 3, 2, 3, 0.0F);
		this.Body = new ModelRenderer(this, 16, 2);
		this.Body.setRotationPoint(0.0F, 7.0F, -10.2F);
		this.Body.addBox(-4.0F, 0.0F, 0.0F, 8, 9, 20, 0.0F);
		this.Neck = new ModelRenderer(this, 83, 3);
		this.Neck.setRotationPoint(-2.5F, 3.5F, -10.5F);
		this.Neck.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6, 0.0F);
		this.setRotateAngle(Neck, -0.8178612874845427F, 0.0F, 0.0F);
		this.BackRightLeg = new ModelRenderer(this, 62, 2);
		this.BackRightLeg.setRotationPoint(-4.1F, 15.0F, 7.1F);
		this.BackRightLeg.addBox(0.0F, 0.0F, -0.2F, 3, 5, 3, 0.0F);
		this.FrontRightLeg = new ModelRenderer(this, 62, 2);
		this.FrontRightLeg.setRotationPoint(-4.1F, 15.0F, -10.1F);
		this.FrontRightLeg.addBox(0.0F, 0.0F, -0.2F, 3, 5, 3, 0.0F);
		this.RightEar = new ModelRenderer(this, 112, 17);
		this.RightEar.setRotationPoint(-1.1F, -0.1F, 6.7F);
		this.RightEar.addBox(0.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(RightEar, 0.010821041362364843F, 0.0F, -6.956533332598998F);
		this.Head.addChild(this.Nose);
		this.BackLeftLeg.addChild(this.BackLeftHoof);
		this.BackRightLeg.addChild(this.BackBottomRightLeg);
		this.FrontRightLeg.addChild(this.FrontBottomRightLeg);
		this.Head.addChild(this.LeftAntler);
		this.BackLeftLeg.addChild(this.BackBottomLeftLeg);
		this.Head.addChild(this.LeftTopAntler);
		this.Head.addChild(this.LeftEar);
		this.Head.addChild(this.RightTopAntler);
		this.Body.addChild(this.Tail);
		this.Neck.addChild(this.Head);
		this.FrontLeftLeg.addChild(this.FrontBottomLeftLeg);
		this.FrontRightLeg.addChild(this.FrontRightHoof);
		this.FrontLeftLeg.addChild(this.FrontLeftHoof);
		this.Head.addChild(this.RightAntler);
		this.BackRightLeg.addChild(this.BackRightHoof);
		this.Head.addChild(this.RightEar);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if (this.isChild) {
			float f6 = 1.2F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GlStateManager.translate(0.0F, 3.0F * f5, 0.0F);
			this.FrontLeftLeg.render(f5);
			this.BackLeftLeg.render(f5);
			this.Body.render(f5);
			this.Neck.render(f5);
			this.BackRightLeg.render(f5);
			this.FrontRightLeg.render(f5);
			GlStateManager.popMatrix();
		} else {
			this.FrontLeftLeg.render(f5);
			this.BackLeftLeg.render(f5);
			this.Body.render(f5);
			this.Neck.render(f5);
			this.BackRightLeg.render(f5);
			this.FrontRightLeg.render(f5);
		}
	}
	
	/** This is a helper function from Tabula to set the rotation of model parts */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.5F) * 0.6F * p_78087_2_;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.5F + (float) Math.PI) * 0.6F * p_78087_2_;
		this.FrontRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.5F + (float) Math.PI) * 0.67F * p_78087_2_;
		this.BackRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.5F) * 0.6F * p_78087_2_;
	}
}