package com.zalthrion.smallcompanions.event;

import com.zalthrion.smallcompanions.SmallCompanions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.smallcompanions.entity.mount.MountBase;
import com.zalthrion.smallcompanions.entity.mount.MountBaseHorse;
import com.zalthrion.smallcompanions.handler.MountCapability.MountData;

public class MountEntityEventListener {
	@SubscribeEvent public void onEntityMount(EntityMountEvent event) {
		if (!event.isMounting()) {
			if (event.getEntityBeingMounted() instanceof MountBase || event.getEntityBeingMounted() instanceof MountBaseHorse) {
				event.getEntityBeingMounted().setDead();
				if (event.getEntityMounting() instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.getEntityMounting();
					MountData data = player.getCapability(SmallCompanions.MOUNT_CAP, null);
					if (data.ownsMount()) {
						data.disownMount();
					}
				}
			}
		}
	}
}