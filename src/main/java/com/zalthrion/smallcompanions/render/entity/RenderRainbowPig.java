package com.zalthrion.smallcompanions.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.smallcompanions.entity.EntityRainbowPig;
import com.zalthrion.smallcompanions.model.entity.ModelRainbowPig;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderRainbowPig extends RenderLiving<EntityRainbowPig> {
	private static final ResourceLocation pigTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig.png");
	
	public RenderRainbowPig(RenderManager renderManager) {
		super(renderManager, new ModelRainbowPig(), 0.5F);
        this.addLayer(new LayerRainbowPigSaddle(this));
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityRainbowPig p_110775_1_) {
		return pigTexture;
	}
	
	public static class Factory implements IRenderFactory<EntityRainbowPig> {
		@Override public Render<? super EntityRainbowPig> createRenderFor(RenderManager manager) {
			return new RenderRainbowPig(manager);
		}
	}
}