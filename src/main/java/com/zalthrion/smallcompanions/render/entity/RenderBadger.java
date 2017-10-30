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

import com.zalthrion.smallcompanions.entity.EntityBadger;
import com.zalthrion.smallcompanions.model.entity.ModelBadger;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT) public class RenderBadger extends RenderLiving<EntityBadger> {
	private static final ResourceLocation badgerTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Badger.png");
	public ModelBase modelBase;
	
	public RenderBadger(RenderManager manager) {
		super(manager, new ModelBadger(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityBadger badger) {
		return badgerTexture;
	}
	
	@Override protected void renderLivingAt(EntityBadger entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.2F, 1.2F, 1.2F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityBadger> {
		@Override public Render<? super EntityBadger> createRenderFor(RenderManager manager) {
			return new RenderBadger(manager);
		}
	}
}