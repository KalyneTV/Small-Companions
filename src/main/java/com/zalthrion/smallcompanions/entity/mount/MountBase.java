package com.zalthrion.smallcompanions.entity.mount;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.google.common.base.Optional;

//TODO Check all mappings, Reorganize methods
public class MountBase extends EntityHorse {
	public boolean isSummoned = false;
	public boolean canDespawn;
	
	private static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityHorse.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	
	protected Entity entity;
	protected EntityPlayer player;
	protected EntityTameable tameableMount;
	
	protected NBTTagCompound tagCompound;
	
	public MountBase(World world) {
		super(world);
		this.setSize(1F, 1F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		
		this.isImmuneToFire = true;
	}
	
	@Override protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.7D));
	}
	
	@Override protected void entityInit() {
		super.entityInit();
		this.dataManager.register(OWNER_UNIQUE_ID, Optional.<UUID> absent());
	}
	
	@Override public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : (Entity) list.get(0);
	}
	
	/** Checks if the entity summoned is alive. */
	public boolean isSummonAlive() {
		return this.isSummoned;
	}
	
	/** Entity check */
	public boolean isEntity(Entity entity) {
		
		if (entity instanceof Entity) {
			entity = this.entity;
		}
		
		if (entity instanceof EntityPlayer) {
			entity = this.player;
		}
		
		if (entity instanceof EntityTameable) {
			entity = this.tameableMount;
		}
		
		return this.isEntity(entity);
	}
	
	/** Gives the horse special attributes */
	public boolean isSummoned(boolean summoned) {
		
		if (summoned == true) {
			this.isSummoned = true;
			this.setHorseTamed(true);
			this.setHorseSaddled(true);
			this.isHorseSaddled();
			
			this.isTame();
		}
		
		return summoned;
	}
	
	@Override public boolean setTamedBy(EntityPlayer p_110263_1_) {
		this.setOwnerUniqueId(p_110263_1_.getUniqueID());
		this.setHorseTamed(true);
		return true;
	}
	
	@Override public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setBoolean("Summoned", this.isSummoned(true));
	}
	
	@Override public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		
		this.tagCompound = tagCompund;
		this.isSummoned(tagCompund.getBoolean("Summoned"));
		
		this.tagCompound.getBoolean("Summoned");
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}
	
	@Override protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	/** Sets what GUI should open when the player opens his inventory while
	 * mounting the entity */
	@Override
	public void openGUI(EntityPlayer p_110199_1_) {
		
		if (this.isSummoned)
			;
		
		else super.openGUI(p_110199_1_);
	}
	
	/** Returns true if the rider of the entity should be dismounted on water */
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	/** Returns true if the entity can breath underwater */
	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}
	
	/** Returns true if the entity can despawn */
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	/** Checks if the entity can be leashed or not */
	/*@Override
	public boolean allowLeashing() {
		return false;
	}*/
	
	/** Checks if the entity is invulnerable or not */
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		if (!this.isSummoned || source == DamageSource.OUT_OF_WORLD) {
			return false;
		}
		
		return true;
	}
	
	/** returns true if all the conditions for steering the entity are met. For
	 * pigs, this is true if it is being ridden by a player and the player is
	 * holding a carrot-on-a-stick */
	@Override public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.getControllingPassenger());
		return riding != null && !this.isChild();
	}
	
	public boolean isOwner(EntityLivingBase entityIn) {
		return entityIn.getUniqueID() == this.getOwnerUniqueId();
	}
	
	@Override
	public UUID getOwnerUniqueId() {
		return (UUID)((Optional<UUID>) this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
	}
	
	@Override
	public void setOwnerUniqueId(UUID uniqueId) {
		this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(uniqueId));
	}
	
	@Override public boolean isChild() {
		return false;
	}
}