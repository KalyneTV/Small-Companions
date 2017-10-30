package com.zalthrion.smallcompanions.event;

import com.zalthrion.smallcompanions.SmallCompanions;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import com.zalthrion.smallcompanions.handler.KeyHandler;
import com.zalthrion.smallcompanions.packet.KeyPressMessage;
import com.zalthrion.smallcompanions.packet.PacketHandler;
import com.zalthrion.smallcompanions.reference.Reference.GuiIDs;

public class KeyInputEventListener {
	@SubscribeEvent public void keyPressed(InputEvent.KeyInputEvent event) {
		if (KeyHandler.openSummonGui.isPressed()) {
			EntityPlayer player = Minecraft.getMinecraft().player;
			KeyPressMessage message = new KeyPressMessage();
			PacketHandler.network.sendToServer(message);
			player.openGui(SmallCompanions.instance, GuiIDs.SUMMON, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
}