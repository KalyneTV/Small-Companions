package com.zalthrion.smallcompanions.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.zalthrion.smallcompanions.gui.GuiSummon;
import com.zalthrion.smallcompanions.reference.Reference.GuiIDs;

public class GuiHandler implements IGuiHandler {
	@Override public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch (ID) {
			case GuiIDs.SUMMON:
				return new GuiSummon();
		}
		return null;
	}

	@Override public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

		return null;
	}
}