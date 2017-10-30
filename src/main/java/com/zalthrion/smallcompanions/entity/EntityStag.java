package com.zalthrion.smallcompanions.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

//TODO Check all mappings, reorganize methods, etc.
public class EntityStag extends EntityTameable {
	public EntityStag(World world) {
		super(world);
		this.setSize(1.0F, 1.1F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
	}
	
	@Override public void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.75D));
		this.tasks.addTask(4, new EntityAITempt(this, 0.6D, Items.CARROT, true));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 16.0F, 0.8D, 1.45D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
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
	
	@Override public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.inventory.getItemStack();
		if (super.processInteract(player, hand)) {
			return true;
		} else if (!this.isChild() && stack != null && stack.getItem() == Items.CARROT && player.getDistance(this) < 9.0D && !this.isTamed() && player.isSneaking()) {
			if (!this.world.isRemote) {
				if (!player.capabilities.isCreativeMode) {
					stack.shrink(1);
				}
				
				if (stack.getCount() <= 0) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
				}
				
				this.setTamed(true);
				this.setOwnerId(player.getUniqueID());
			}
			
			this.playTameEffect(true);
			return true;
		} else if (!this.world.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && this.isTamed() && !player.isSneaking()) {
			player.startRiding(this);
			return true;
		} else {
			return false;
		}
	}
	
	@Override protected Item getDropItem() {
		return this.isBurning() ? Items.COOKED_BEEF : Items.BEEF;
	}
	
	@Override protected void dropFewItems(boolean check, int p2) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p2);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.COOKED_BEEF, 1);
			} else {
				this.dropItem(Items.BEEF, 1);
			}
		}
	}
	
	@Override public boolean canMateWith(EntityAnimal entity) {
		if (!this.isInLove() || !entity.isInLove()) return false;
		
		if (entity == this)
			return false;
		else if (entity instanceof EntityDeer) return true;
		
		return false;
	}
	
	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		int breed = rand.nextInt((1 - 0) + 1) + 0;
		
		if (breed == 1) {
			return new EntityStag(world);
		} else return new EntityDeer(world);
	}
	
	@Override public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.WHEAT;
	}
	
	@Override public double getMountedYOffset() {
		return 1.5F;
	}
}