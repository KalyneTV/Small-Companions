package com.zalthrion.smallcompanions.entity.mount;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Optional;

public abstract class EntityTameableHorse extends EntityHorse implements IEntityOwnable {
	private static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityTameableHorse.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	private static final DataParameter<Boolean> TAMED = EntityDataManager.<Boolean>createKey(EntityTameableHorse.class, DataSerializers.BOOLEAN);
	
	/* Constructors */
	
	public EntityTameableHorse(World worldIn) {
		super(worldIn);
	}
	
	/* Custom Methods */
	
	public boolean isOwner(EntityLivingBase entityIn) {
		return entityIn == this.getOwner();
	}
	
	public boolean shouldAttackEntity(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
		return true;
	} //TODO EntityAIOwnerHurtTarget & EntityAIOwnerHurtByTarget
	
	/* Overridden */
	
	@Override public Entity getOwner() {
		try {
			UUID uuid = this.getOwnerUniqueId();
			return uuid == null ? null : this.world.getPlayerEntityByUUID(uuid);
		} catch (IllegalArgumentException illegalargumentexception) {
			return null;
		}
	}
	
	@Override public UUID getOwnerUniqueId() {
		return (UUID) ((Optional<UUID>) this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
	}
	
	@Override public Team getTeam() {
		if (this.isTame()) {
			EntityLivingBase entitylivingbase = (EntityLivingBase) this.getOwner();
			
			if (entitylivingbase != null) { return entitylivingbase.getTeam(); }
		}
		
		return super.getTeam();
	}
	
	@Override protected void entityInit() {
		super.entityInit();
		this.dataManager.register(TAMED, Boolean.FALSE);
		this.dataManager.register(OWNER_UNIQUE_ID, Optional.<UUID> absent());
	}
	
	@Override @SideOnly(Side.CLIENT) public void handleStatusUpdate(byte id) {
		if (id == 7) {
			this.spawnHorseParticles(true);
		} else if (id == 6) {
			this.spawnHorseParticles(false);
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
	@Override public boolean isOnSameTeam(Entity entityIn) {
		if (this.isTame()) {
			EntityLivingBase entitylivingbase1 = (EntityLivingBase) this.getOwner();
			
			if (entityIn == entitylivingbase1) { return true; }
			
			if (entitylivingbase1 != null) { return entitylivingbase1.isOnSameTeam(entityIn); }
		}
		
		return super.isOnSameTeam(entityIn);
	}
	
	@Override public boolean isTame() {
		return this.dataManager.get(TAMED).booleanValue();
	}
	
	@Override public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey("OwnerUUID")) {
			this.setOwnerUniqueId(compound.getUniqueId("OwnerUUID"));
			this.setHorseTamed(true);
		}
	}
	
	@Override public void setHorseTamed(boolean tamed) {
		this.dataManager.set(TAMED, tamed);
	}
	
	@Override public void setOwnerUniqueId(UUID uniqueId) {
		this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(uniqueId));
	}
	
	@Override protected void spawnHorseParticles(boolean happy) {
		for (int i = 0; i < 7; i ++) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.spawnParticle(happy ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
		}
	}
	
	@Override public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		if (this.getOwnerId() != null) compound.setUniqueId("OwnerUUID", this.getOwnerId());
	}
}