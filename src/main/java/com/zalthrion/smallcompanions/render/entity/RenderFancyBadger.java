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

import com.zalthrion.smallcompanions.entity.EntityFancyBadger;
import com.zalthrion.smallcompanions.model.entity.ModelBadger;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT) public class RenderFancyBadger extends RenderLiving<EntityFancyBadger> {
	private static final ResourceLocation fancybadgerTextures = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Badger.png");
	public ModelBase modelBase;
	
	public RenderFancyBadger(RenderManager manager) {
		super(manager, new ModelBadger(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityFancyBadger fancybadger) {
		return fancybadgerTextures;
	}
	
	@Override protected void renderLivingAt(EntityFancyBadger entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.2F, 1.2F, 1.2F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityFancyBadger> {
		@Override public Render<? super EntityFancyBadger> createRenderFor(RenderManager manager) {
			return new RenderFancyBadger(manager);
		}
	}
}