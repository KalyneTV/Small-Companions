package com.zalthrion.smallcompanions.entity.mount;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

//TODO Check all mappings, Reorganize methods
public class MountBaseHorse extends EntityTameableHorse {
	public boolean isSummoned = false;
	public boolean canDespawn;
	protected Entity entity;
	protected EntityPlayer player;
	protected EntityTameableHorse tameableHorse;
	protected NBTTagCompound tagCompound;
	
	public MountBaseHorse(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.setSize(1.0F, 1.0F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
	}
	
	@Override public void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.7D));
	}
	
	@Override public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : (Entity) list.get(0);
	}
	
	public boolean isSummonAlive() {
		return this.isSummoned;
	}
	
	public boolean isEntity(Entity entity) {
		if (entity instanceof Entity) {
			entity = this.entity;
		}
		if (entity instanceof EntityPlayer) {
			entity = this.player;
		}
		if (entity instanceof EntityTameableHorse) {
			entity = this.tameableHorse;
		}
		
		return this.isEntity(entity);
	}
	
	public boolean isSummoned(boolean summoned) {
		if (summoned == true) {
			this.isSummoned = true;
			this.setHorseTamed(true);
			this.setHorseSaddled(true);
			this.isHorseSaddled();
		}
		
		return summoned;
	}
	
	@Override public boolean setTamedBy(EntityPlayer player) {
		this.setOwnerUniqueId(player.getUniqueID());
		this.setHorseTamed(true);
		return true;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setBoolean("Tame", this.isTame());
		tagCompound.setBoolean("Saddled", this.isHorseSaddled());
		tagCompound.setBoolean("Summoned", this.isSummoned(true));
		tagCompound.setUniqueId("OwnerUUID", this.getOwnerUniqueId());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		
		this.tagCompound = tagCompund;
		this.setHorseTamed(tagCompund.getBoolean("Tame"));
		this.setHorseSaddled(tagCompund.getBoolean("Saddled"));
		this.isSummoned(tagCompund.getBoolean("Summoned"));
		
		this.tagCompound.getBoolean("Summoned");
		
		if (tagCompund.hasKey("OwnerUUID", 8)) {
			this.setOwnerUniqueId(tagCompund.getUniqueId("OwnerUUID"));
		}
	}
	
	@Override public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
	}
	
	@Override
	public void openGUI(EntityPlayer p_110199_1_) {
		if (!this.isSummoned) super.openGUI(p_110199_1_);
	}
	
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	/** Checks if the entity can be leashed or not */
	/* @Override
	public boolean allowLeashing() {
		return false;
	} */
	
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		if (!this.isSummoned || source == DamageSource.OUT_OF_WORLD) {
			return false;
		}
		
		return true;
	}
	
	@Override public boolean isChild() {
		return false;
	}
	
	@Override public double getMountedYOffset() {
		return 1.2F;
	}

	@Override public UUID getOwnerId() {
		return this.getOwnerUniqueId();
	}
}