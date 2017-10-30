package com.zalthrion.smallcompanions.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.translation.I18n;

import com.zalthrion.smallcompanions.entity.mount.MountDeathcharger;
import com.zalthrion.smallcompanions.entity.mount.MountPlaguedHorse;
import com.zalthrion.smallcompanions.entity.mount.MountSavageBadger;
import com.zalthrion.smallcompanions.entity.mount.MountSwiftUnicorn;
import com.zalthrion.smallcompanions.entity.mount.MountWarTortoise;
import com.zalthrion.smallcompanions.packet.DismissMessage;
import com.zalthrion.smallcompanions.packet.PacketHandler;
import com.zalthrion.smallcompanions.packet.SummonMessage;
import com.zalthrion.smallcompanions.packet.SummonedMountMessage;

//TODO Check all mappings, reorganize methods, etc.
public class GuiSummon extends GuiScreen {
	private int currentlySelected = 0;
	private int summons = 5;
	private EntityLivingBase[] entities = new EntityLivingBase[] {
			new MountDeathcharger(Minecraft.getMinecraft().world),
			new MountPlaguedHorse(Minecraft.getMinecraft().world),
			new MountSavageBadger(Minecraft.getMinecraft().world),
			new MountSwiftUnicorn(Minecraft.getMinecraft().world),
			new MountWarTortoise(Minecraft.getMinecraft().world)
	};
	
	public GuiSummon() {
		super();
	}
	
	@Override protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id >= 0 && button.id < this.summons) {
			this.getButtonById(this.currentlySelected).enabled = true;
			((SummonDismissButton) this.getButtonById(this.summons)).setTrack(button.id);
			this.currentlySelected = button.id;
			button.enabled = false;
		}
		if (button.id == this.summons) {
			if (SummonedMountMessage.summonedMountStatic == this.currentlySelected) {
				DismissMessage message = new DismissMessage();
				PacketHandler.network.sendToServer(message);
			} else {
				if (SummonedMountMessage.summonedMountStatic != -1) {
					DismissMessage message = new DismissMessage();
					PacketHandler.network.sendToServer(message);
				}
				SummonMessage message = new SummonMessage(this.currentlySelected);
				PacketHandler.network.sendToServer(message);
			}
		}
		//TODO Implement scrolling.
	}
	
	@Override public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int xSize = 290;
		int ySize = 160;
		int xPos = ((this.width - xSize) / 2);
		int yPos = ((this.height - ySize) / 2);
		GuiInventory.drawEntityOnScreen(xPos + 215, yPos + 115, 40, 45, 0, this.entities[this.currentlySelected]);
		Gui.drawRect(xPos, yPos, xPos + xSize, yPos + ySize, 2130706432);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override public void initGui() {
		this.currentlySelected = 0;
		int xSize = 290;
		int ySize = 160;
		int xPos = ((this.width - xSize) / 2) + 20;
		int yPos = ((this.height - ySize) / 2) + 20;
		GuiButton initialButton = new GuiButton(0, xPos + 25, yPos, 100, 20, I18n.translateToLocal("entity.SmallCompanions:Deathcharger.name"));
		initialButton.enabled = false;
		this.buttonList.add(initialButton);
		this.buttonList.add(new GuiButton(1, xPos + 25, yPos + 25, 100, 20, I18n.translateToLocal("entity.SmallCompanions:Plagued_Horse.name")));
		this.buttonList.add(new GuiButton(2, xPos + 25, yPos + 50, 100, 20, I18n.translateToLocal("entity.SmallCompanions:SavageBadger.name")));
		this.buttonList.add(new GuiButton(3, xPos + 25, yPos + 75, 100, 20, I18n.translateToLocal("entity.SmallCompanions:SwiftUnicorn.name")));
		this.buttonList.add(new GuiButton(4, xPos + 25, yPos + 100, 100, 20, I18n.translateToLocal("entity.SmallCompanions:WarTortoise.name")));
		this.buttonList.add(new SummonDismissButton(this.summons, xPos + 150, yPos + 100, 100, 20, I18n.translateToLocal("gui.smallcompanions:summon")));
		GuiButton upButton = new GuiButton(this.summons + 1, xPos, yPos, 20, 20, "\u2191");
		GuiButton downButton = new GuiButton(this.summons + 2, xPos, yPos + 100, 20, 20, "\u2193");
		upButton.enabled = false;
		downButton.enabled = false;
		this.buttonList.add(upButton);
		this.buttonList.add(downButton);
	}
	
	GuiButton getButtonById(int id) {
		for (GuiButton button : this.buttonList) {
			if (button.id == id) return button;
		}
		return null;
	}
}