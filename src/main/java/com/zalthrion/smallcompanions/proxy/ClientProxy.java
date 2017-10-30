package com.zalthrion.smallcompanions.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.zalthrion.smallcompanions.entity.*;
import com.zalthrion.smallcompanions.entity.mount.MountDeathcharger;
import com.zalthrion.smallcompanions.entity.mount.MountPlaguedHorse;
import com.zalthrion.smallcompanions.entity.mount.MountSavageBadger;
import com.zalthrion.smallcompanions.entity.mount.MountSwiftUnicorn;
import com.zalthrion.smallcompanions.entity.mount.MountWarTortoise;
import com.zalthrion.smallcompanions.event.KeyInputEventListener;
import com.zalthrion.smallcompanions.render.entity.*;
import com.zalthrion.smallcompanions.render.entity.mount.RenderDeathcharger;
import com.zalthrion.smallcompanions.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.smallcompanions.render.entity.mount.RenderSavageBadger;
import com.zalthrion.smallcompanions.render.entity.mount.RenderSwiftUnicorn;
import com.zalthrion.smallcompanions.render.entity.mount.RenderWarTortoise;

public class ClientProxy extends CommonProxy {

	@Override public void preInit() {
		super.preInit();
		this.registerEntityRenderers();
	}
	
	@Override public void init() {
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyInputEventListener());
	}
	
	@Override public void postInit() {
		super.postInit();
	}
	
	public void registerEntityRenderers() {
		/* Animals */
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, new RenderBadger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityFancyBadger.class, new RenderFancyBadger.Factory());
		/* Mobs */
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new RenderDeer.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new RenderStag.Factory());
		/* Mounts */
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountSavageBadger.class, new RenderSavageBadger.Factory());
		RenderingRegistry.registerEntityRenderingHandler(MountSwiftUnicorn.class, new RenderSwiftUnicorn.Factory());
	}
}