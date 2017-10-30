package com.zalthrion.smallcompanions.handler;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class MountCapability {
	public interface MountData {
		void disownMount();
		String getOwnedMount();
		int getOwnedMountId();
		boolean ownsMount();
		void updateMountData(String ownedMount, int ownedMountId);
	}
	
	public static class Storage implements IStorage<MountData> {
		@Override public void readNBT(Capability<MountData> capability, MountData instance, EnumFacing side, NBTBase nbt) {
			instance.updateMountData(((NBTTagCompound) nbt).getString("ownedMount"), ((NBTTagCompound) nbt).getInteger("ownedMountId"));
		}

		@Override public NBTBase writeNBT(Capability<MountData> capability, MountData instance, EnumFacing side) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("ownedMount", instance.getOwnedMount());
			compound.setInteger("ownedMountId", instance.getOwnedMountId());
			return compound;
		}
	}
	
	public static class DefaultMountData implements MountData {
		private String ownedMount = "";
		private int ownedMountId = -1;
		
		@Override public void disownMount() {
			this.ownedMount = "";
			this.ownedMountId = -1;
		}
		
		@Override public String getOwnedMount() {
			return this.ownedMount;
		}
		
		@Override public int getOwnedMountId() {
			return this.ownedMountId;
		}
		
		@Override public boolean ownsMount() {
			return this.ownedMount.length() > 0;
		}
		
		@Override public void updateMountData(String ownedMount, int ownedMountId) {
			this.ownedMount = ownedMount;
			this.ownedMountId = ownedMountId;
		}
	}
}