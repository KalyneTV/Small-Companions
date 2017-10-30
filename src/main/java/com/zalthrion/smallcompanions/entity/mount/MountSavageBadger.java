package com.zalthrion.smallcompanions.entity.mount;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.smallcompanions.reference.Reference;

//TODO Check all mappings, Reorganize methods
public class MountSavageBadger extends MountBase {
	public MountSavageBadger(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		this.setCustomNameTag("Savage Badger");
	}

	@Override public boolean processInteract(EntityPlayer player, EnumHand hand) {
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		ItemStack stack = player.inventory.getItemStack();

		if (!this.world.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking() && stack == null && this.isOwner(player)) {
			player.startRiding(this);
		}
		if (!this.isOwner(player) && !this.world.isRemote) {
			player.sendMessage(new TextComponentTranslation("msg." + Reference.MOD_ID + ":mount.owned"));
		}

		return true;
	}
}