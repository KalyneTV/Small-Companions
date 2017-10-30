package com.zalthrion.smallcompanions.event;

import com.zalthrion.smallcompanions.SmallCompanions;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.smallcompanions.handler.MountCapability.MountData;
import com.zalthrion.smallcompanions.reference.Reference;

public class PlayerEventListener {
	@SubscribeEvent public void onAttachCapabilities(AttachCapabilitiesEvent event) {
		event.addCapability(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "MountData"), new ICapabilitySerializable<NBTPrimitive>() {
			MountData instance = SmallCompanions.MOUNT_CAP.getDefaultInstance();
			@Override public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
				return capability == SmallCompanions.MOUNT_CAP;
			}

			@Override public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
				return capability == SmallCompanions.MOUNT_CAP ? SmallCompanions.MOUNT_CAP.<T>cast(instance) : null;
			}

			@Override public NBTPrimitive serializeNBT() {
				return (NBTPrimitive) SmallCompanions.MOUNT_CAP.getStorage().writeNBT(
						SmallCompanions.MOUNT_CAP, instance, null);
			}

			@Override public void deserializeNBT(NBTPrimitive nbt) {
				SmallCompanions.MOUNT_CAP.getStorage().readNBT(SmallCompanions.MOUNT_CAP, instance, null, nbt);
			}
		});
	}
}