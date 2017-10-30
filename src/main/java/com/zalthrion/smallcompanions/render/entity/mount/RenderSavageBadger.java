package com.zalthrion.smallcompanions.render.entity.mount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.smallcompanions.entity.mount.MountSavageBadger;
import com.zalthrion.smallcompanions.model.entity.ModelSavageBadger;
import com.zalthrion.smallcompanions.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderSavageBadger extends RenderLiving<MountSavageBadger> {
	private static final ResourceLocation savageBadgerTextures = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/mounts/SavageBadger.png");
	public ModelBase modelBase;
	
	public RenderSavageBadger(RenderManager manager) {
		super(manager, new ModelSavageBadger(), 0.5F);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(MountSavageBadger savageBadger) {
		return savageBadgerTextures;
	}
	
	@Override
	protected void renderLivingAt(MountSavageBadger entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.2F, 1.2F, 1.2F);
		}
	}
	
	public static class Factory implements IRenderFactory<MountSavageBadger> {
		@Override public Render<? super MountSavageBadger> createRenderFor(RenderManager manager) {
			return new RenderSavageBadger(manager);
		}
	}
}