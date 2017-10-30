package com.zalthrion.smallcompanions.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.smallcompanions.entity.EntityDeer;
import com.zalthrion.smallcompanions.model.entity.ModelDeer;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderDeer extends RenderLiving<EntityDeer> {
	private static final ResourceLocation deerTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Deer.png");
	
	public ModelBase modelBase;
	
	public RenderDeer(RenderManager renderManager) {
		super(renderManager, new ModelDeer(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityDeer deer) {
		return deerTexture;
	}
	
	@Override protected void renderLivingAt(EntityDeer entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		}
		
		else {
			GlStateManager.scale(1.2F, 1.2F, 1.2F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityDeer> {
		@Override public Render<? super EntityDeer> createRenderFor(RenderManager manager) {
			return new RenderDeer(manager);
		}
	}
}