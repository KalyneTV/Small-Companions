package com.zalthrion.smallcompanions.render.entity;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.smallcompanions.entity.EntityRainbowPig;

public class LayerRainbowPigSaddle implements LayerRenderer<EntityRainbowPig> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/pig/pig_saddle.png");
	private final RenderRainbowPig pigRenderer;
	private final ModelPig pigModel = new ModelPig(0.5F);
	
	public LayerRainbowPigSaddle(RenderRainbowPig pigRendererIn) {
		this.pigRenderer = pigRendererIn;
	}
	
	@Override public void doRenderLayer(EntityRainbowPig entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		if (entitylivingbaseIn.getSaddled()) {
			this.pigRenderer.bindTexture(TEXTURE);
			this.pigModel.setModelAttributes(this.pigRenderer.getMainModel());
			this.pigModel.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
		}
	}
	
	@Override public boolean shouldCombineTextures() {
		return false;
	}
}
