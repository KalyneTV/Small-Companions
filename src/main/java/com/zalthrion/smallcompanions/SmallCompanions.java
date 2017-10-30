package com.zalthrion.smallcompanions;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import com.zalthrion.smallcompanions.handler.ConfigurationHandler;
import com.zalthrion.smallcompanions.handler.MountCapability;
import com.zalthrion.smallcompanions.handler.MountCapability.MountData;
import com.zalthrion.smallcompanions.proxy.CommonProxy;
import com.zalthrion.smallcompanions.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
/*---------------------------------------------------------------------------*/
public class SmallCompanions {
	
	@Mod.Instance(Reference.MOD_ID) public static SmallCompanions instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY) public static CommonProxy proxy;
	@CapabilityInject(MountData.class) public static final Capability<MountData> MOUNT_CAP = null;
	
	@Mod.EventHandler public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
		CapabilityManager.INSTANCE.register(MountData.class, new MountCapability.Storage(), MountCapability.DefaultMountData.class);
		proxy.preInit();
	}
	
	@Mod.EventHandler public void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	@Mod.EventHandler public void serverStarting(FMLServerStartingEvent event) {
		proxy.init();
	}
}