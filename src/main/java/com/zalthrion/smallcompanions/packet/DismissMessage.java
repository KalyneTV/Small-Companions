package com.zalthrion.smallcompanions.packet;

import com.zalthrion.smallcompanions.SmallCompanions;
import io.netty.buffer.ByteBuf;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zalthrion.smallcompanions.handler.MountCapability.MountData;

public class DismissMessage implements IMessage {
	public DismissMessage() {}
	
	@Override public void fromBytes(ByteBuf buf) {}
	@Override public void toBytes(ByteBuf buf) {}
	
	public static class Handler implements IMessageHandler<DismissMessage, IMessage> {
		@Override public IMessage onMessage(DismissMessage message, final MessageContext ctx) {
			IThreadListener handler = (WorldServer) ctx.getServerHandler().player.world;
			handler.addScheduledTask(new Runnable() {
				@Override public void run() {
					EntityPlayer player = ctx.getServerHandler().player;
					if (player != null) {
						MountData data = player.getCapability(SmallCompanions.MOUNT_CAP, null);
						if (data.ownsMount()) {
							Iterator<Entity> iterator = player.world.loadedEntityList.iterator();
							while (iterator.hasNext()) {
								Entity anEntity = iterator.next();
								if (anEntity.getUniqueID().toString().equalsIgnoreCase(data.getOwnedMount())) anEntity.setDead();
							}
							data.disownMount();
						}
					}
				}
			});
			return new SummonedMountMessage();
		}
	}
}