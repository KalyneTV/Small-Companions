package com.zalthrion.smallcompanions.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//TODO Check all mappings, reorganize methods, etc.
public class EntityFancyBadger extends EntityAnimal {
	public EntityFancyBadger(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		this.setCustomNameTag("FancyBadger");
	}
	
	@Override public void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.CARROT_ON_A_STICK, false));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.CARROT, false));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.getControllingPassenger());
		return riding != null && !this.isChild();
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PIG_AMBIENT;
	}
	
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_PIG_HURT;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PIG_DEATH;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}
	
	public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		if (stack != null && stack.getItem() == Items.CARROT && player.isSneaking()) {
			if (!this.world.isRemote) {
				EntityBadger entitybadger = new EntityBadger(this.world);
				entitybadger.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				this.setDead();
				this.world.spawnEntity(entitybadger);
			}
			
			for (int i = 0; i < 7; ++ i) {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
			}
			
			stack.shrink(1);
		}
		
		if (super.processInteract(player, hand)) {
			return true;
		} else if (!this.world.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking() && stack == null) {
			player.startRiding(this);
			return true;
		} else {
			return false;
		}
	}
	
	@Override protected Item getDropItem() {
		return this.isBurning() ? Items.COOKED_PORKCHOP : Items.PORKCHOP;
	}
	
	@Override protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.COOKED_PORKCHOP, 1);
			}
			else {
				this.dropItem(Items.PORKCHOP, 1);
			}
		}
	}
	
	@Override public EntityFancyBadger createChild(EntityAgeable ageable) {
		return new EntityFancyBadger(this.world);
	}
	
	@Override public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.WHEAT;
	}
}