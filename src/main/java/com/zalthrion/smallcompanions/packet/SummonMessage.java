package com.zalthrion.smallcompanions.packet;

import com.zalthrion.smallcompanions.SmallCompanions;
import com.zalthrion.smallcompanions.entity.mount.MountDeathcharger;
import com.zalthrion.smallcompanions.entity.mount.MountPlaguedHorse;
import com.zalthrion.smallcompanions.entity.mount.MountSavageBadger;
import com.zalthrion.smallcompanions.entity.mount.MountSwiftUnicorn;
import com.zalthrion.smallcompanions.entity.mount.MountWarTortoise;
import com.zalthrion.smallcompanions.handler.MountCapability.MountData;
import com.zalthrion.smallcompanions.reference.Reference.MountIDs;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SummonMessage implements IMessage {
	private int summon;
	
	public SummonMessage() {}
	public SummonMessage(int summon) {
		this.summon = summon;
	}
	
	@Override public void fromBytes(ByteBuf buffer) {
		this.summon = buffer.readInt();
	}
	
	@Override public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.summon);
	}
	
	public static class Handler implements IMessageHandler<SummonMessage, IMessage> {
		@Override public IMessage onMessage(final SummonMessage message, final MessageContext context) {
			IThreadListener handler = (WorldServer) context.getServerHandler().player.world;
			handler.addScheduledTask(new Runnable() {
				@Override public void run() {
					EntityPlayer player = context.getServerHandler().player;
					if (player != null) {
						MountData data = player.getCapability(SmallCompanions.MOUNT_CAP, null);
						if (message.summon == MountIDs.deathcharger) {
							MountDeathcharger deathcharger = new MountDeathcharger(player.world);
							deathcharger.copyLocationAndAnglesFrom(player);
							deathcharger.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
							deathcharger.setOwnerUniqueId(player.getUniqueID());
							deathcharger.isSummoned(true);
							deathcharger.setTamedBy(player);
							player.world.spawnEntity(deathcharger);
							player.startRiding(deathcharger);
							player.getCapability(SmallCompanions.MOUNT_CAP, null).updateMountData("TEST1", 101);
						} else if (message.summon == MountIDs.plaguedHorse) {
							MountPlaguedHorse plaguedHorse = new MountPlaguedHorse(player.world);
							plaguedHorse.copyLocationAndAnglesFrom(player);
							plaguedHorse.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
							plaguedHorse.setOwnerUniqueId(player.getUniqueID());
							plaguedHorse.isSummoned(true);
							plaguedHorse.setTamedBy(player);
							player.world.spawnEntity(plaguedHorse);
							player.startRiding(plaguedHorse);
							player.getCapability(SmallCompanions.MOUNT_CAP, null).updateMountData("TEST2", 102);
						} else if (message.summon == MountIDs.savageBadger) {
							MountSavageBadger badger = new MountSavageBadger(player.world);
							badger.copyLocationAndAnglesFrom(player);
							badger.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
							badger.setOwnerUniqueId(player.getUniqueID());
							badger.isSummoned(true);
							badger.setTamedBy(player);
							player.world.spawnEntity(badger);
							player.startRiding(badger);
							player.getCapability(SmallCompanions.MOUNT_CAP, null).updateMountData("TEST3", 103);
						} else if (message.summon == MountIDs.swiftUnicorn) {
							MountSwiftUnicorn swiftUnicorn = new MountSwiftUnicorn(player.world);
							swiftUnicorn.copyLocationAndAnglesFrom(player);
							swiftUnicorn.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
							swiftUnicorn.setOwnerUniqueId(player.getUniqueID());
							swiftUnicorn.isSummoned(true);
							swiftUnicorn.setTamedBy(player);
							player.world.spawnEntity(swiftUnicorn);
							player.startRiding(swiftUnicorn);
							player.getCapability(SmallCompanions.MOUNT_CAP, null).updateMountData("TEST4", 104);
						} else if (message.summon == MountIDs.warTortoise) {
							MountWarTortoise warTortoise = new MountWarTortoise(player.world);
							warTortoise.copyLocationAndAnglesFrom(player);
							warTortoise.onInitialSpawn(player.world.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
							warTortoise.setOwnerUniqueId(player.getUniqueID());
							warTortoise.isSummoned(true);
							warTortoise.setTamedBy(player);
							player.world.spawnEntity(warTortoise);
							player.startRiding(warTortoise);
							player.getCapability(SmallCompanions.MOUNT_CAP, null).updateMountData("TEST5", 105);
						}
					}					
				}
			});
			return new SummonedMountMessage(message.summon);
		}
	}
}