package com.zalthrion.smallcompanions.proxy;

import com.zalthrion.smallcompanions.SmallCompanions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.zalthrion.smallcompanions.event.MountEntityEventListener;
import com.zalthrion.smallcompanions.handler.GuiHandler;
import com.zalthrion.smallcompanions.lib.ModInit;

public class CommonProxy {
	public void preInit() {
		ModInit.preInit();
	}
	
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SmallCompanions.instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new MountEntityEventListener());
		ModInit.init();
	}
	
	public void postInit() {}
}