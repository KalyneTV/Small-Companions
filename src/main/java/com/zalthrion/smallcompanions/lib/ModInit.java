package com.zalthrion.smallcompanions.lib;

import com.zalthrion.smallcompanions.SmallCompanions;
import com.zalthrion.smallcompanions.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.zalthrion.smallcompanions.entity.mount.MountDeathcharger;
import com.zalthrion.smallcompanions.entity.mount.MountPlaguedHorse;
import com.zalthrion.smallcompanions.entity.mount.MountSavageBadger;
import com.zalthrion.smallcompanions.entity.mount.MountSwiftUnicorn;
import com.zalthrion.smallcompanions.entity.mount.MountWarTortoise;
import com.zalthrion.smallcompanions.handler.KeyHandler;
import com.zalthrion.smallcompanions.packet.PacketHandler;

public class ModInit {
	public static class EntityInit {
		private static int nextEntityID = 0;

		private static int getNextEntityID() {
			nextEntityID ++;
			return nextEntityID;
		}

		public static void registerEntity(ResourceLocation resource, Class<? extends Entity> entityClass, String entityName, boolean hasEgg, int bgEggColor, int fgEggColor) {
			EntityRegistry.registerModEntity(new ResourceLocation(Reference.RESOURCE_PREFIX), entityClass, entityName, getNextEntityID(), SmallCompanions.instance, 80, 4, true);
		}

		public static void init() {
			registerEntity(new ResourceLocation(Reference.RESOURCE_PREFIX + "deathcharger"), MountDeathcharger.class, "Deathcharger", false, 0, 0);
			registerEntity(new ResourceLocation(Reference.RESOURCE_PREFIX + "plaguedhorse"),MountPlaguedHorse.class, "PlaguedHorse", false, 0, 0);
			registerEntity(new ResourceLocation(Reference.RESOURCE_PREFIX + "wartortoise"),MountWarTortoise.class, "WarTortoise", false, 0, 0);
			registerEntity(new ResourceLocation(Reference.RESOURCE_PREFIX + "savagebadger"),MountSavageBadger.class, "SavageBadger", false, 0, 0);
			registerEntity(new ResourceLocation(Reference.RESOURCE_PREFIX + "swiftunicorn"),MountSwiftUnicorn.class, "SwiftUnicorn", false, 0, 0);
		}
	}
	
	public static void preInit() {
		PacketHandler.preInit();
		KeyHandler.preInit();
	}
	
	public static void init() {
		EntityInit.init();
	}
}