package com.zalthrion.smallcompanions.event;

import com.zalthrion.smallcompanions.SmallCompanions;
import com.zalthrion.smallcompanions.handler.MountCapability.MountData;
import com.zalthrion.smallcompanions.reference.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventListener {
	@SubscribeEvent public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer) {
			System.out.println(SmallCompanions.MOUNT_CAP.toString());
			if(event.getCapabilities().get(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "mountdata")) == null){
				event.addCapability(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "mountdata"), new ICapabilitySerializable<NBTBase>() {
					MountData instance = SmallCompanions.MOUNT_CAP.getDefaultInstance();
					@Override public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
						return capability == SmallCompanions.MOUNT_CAP;
					}

					@Override public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
						return capability == SmallCompanions.MOUNT_CAP ? SmallCompanions.MOUNT_CAP.<T>cast(instance) : null;
					}

					@Override public NBTBase serializeNBT() {
						return SmallCompanions.MOUNT_CAP.getStorage().writeNBT(SmallCompanions.MOUNT_CAP, instance, null);
					}

					@Override public void deserializeNBT(NBTBase nbt) {
						SmallCompanions.MOUNT_CAP.getStorage().readNBT(SmallCompanions.MOUNT_CAP, instance, null, nbt);
					}
				});
			}
		}
	}
}