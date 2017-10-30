package com.zalthrion.smallcompanions.render.entity;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Maps;
import com.zalthrion.smallcompanions.entity.EntitySkeletalHorse;

@SideOnly(Side.CLIENT)
public class RenderSkeletalHorse extends RenderLiving<EntitySkeletalHorse> {
	
	private static final Map<String, ResourceLocation> field_110852_a = Maps.<String, ResourceLocation>newHashMap();
	private static final ResourceLocation whiteHorseTextures = new ResourceLocation("textures/entity/horse/horse_white.png");
	private static final ResourceLocation muleTextures = new ResourceLocation("textures/entity/horse/mule.png");
	private static final ResourceLocation donkeyTextures = new ResourceLocation("textures/entity/horse/donkey.png");
	private static final ResourceLocation zombieHorseTextures = new ResourceLocation("textures/entity/horse/horse_zombie.png");
	private static final ResourceLocation skeletonHorseTextures = new ResourceLocation("textures/entity/horse/horse_skeleton.png");
	
	public RenderSkeletalHorse(RenderManager manager) {
		super(manager, new ModelHorse(), 0.5F);
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	@Override protected void preRenderCallback(EntitySkeletalHorse p_77041_1_, float p_77041_2_) {
		float f1 = 1.0F;
		
		GlStateManager.scale(f1, f1, f1);
		super.preRenderCallback(p_77041_1_, p_77041_2_);
	}
	
	/** Renders the model in RenderLiving */
	@Override protected void renderModel(EntitySkeletalHorse p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		if (p_77036_1_.isInvisible()) {
			this.mainModel.setRotationAngles(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, p_77036_1_);
		} else {
			this.bindEntityTexture(p_77036_1_);
			this.mainModel.render(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
		}
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(EntitySkeletalHorse p_110775_1_) {
		return this.func_110848_b(p_110775_1_);
	}
	
	private ResourceLocation func_110848_b(EntitySkeletalHorse p_110848_1_) {
		String s = p_110848_1_.getHorseTexture();
		ResourceLocation resourcelocation = (ResourceLocation) field_110852_a.get(s);
		
		if (resourcelocation == null) {
			resourcelocation = new ResourceLocation(s);
			Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(p_110848_1_.getVariantTexturePaths()));
			field_110852_a.put(s, resourcelocation);
		}
		
		return resourcelocation;
	}
	
	public static class Factory implements IRenderFactory<EntitySkeletalHorse> {
		@Override public Render<? super EntitySkeletalHorse> createRenderFor(RenderManager manager) {
			return new RenderSkeletalHorse(manager);
		}
	}
}