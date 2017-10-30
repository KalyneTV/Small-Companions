package com.zalthrion.smallcompanions.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.smallcompanions.entity.EntityStag;
import com.zalthrion.smallcompanions.model.entity.ModelStag;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT)
 public class RenderStag extends RenderLiving<EntityStag> {
	private static final ResourceLocation stagTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Stag.png");
	
	public RenderStag(RenderManager renderManager) {
		super(renderManager, new ModelStag(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityStag stag) {
		return stagTexture;
	}
	
	@Override protected void renderLivingAt(EntityStag entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		
		EntityStag stag = (EntityStag) entity;
		
		if (stag.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.4F, 1.4F, 1.4F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityStag> {
		@Override public Render<? super EntityStag> createRenderFor(RenderManager manager) {
			return new RenderStag(manager);
		}
	}
}