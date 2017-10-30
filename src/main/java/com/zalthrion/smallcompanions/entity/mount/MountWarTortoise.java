package com.zalthrion.smallcompanions.entity.mount;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.smallcompanions.reference.Reference;

//TODO Check all mappings, Reorganize methods
public class MountWarTortoise extends MountBase {
	public MountWarTortoise(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.setCustomNameTag("War Tortoise");
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
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PIG_AMBIENT;
	}

	@Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PIG_HURT;
	}

	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PIG_DEATH;
	}
	
	@Override protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}
}