package com.zalthrion.smallcompanions.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.smallcompanions.reference.Reference;

public class ConfigurationHandler {
	public static Configuration configuration;
	
	private static boolean enableHardcoreMode = false;
	private static boolean enableKyrul = true;
	private static boolean enableIridis = true;
	private static boolean enableGlaciem = true;
	private static int kyrulDimensionId = 47;
	private static int iridisDimensionId = 48;
	private static int glaciemDimensionId = 49;
	
	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
	private static void loadConfiguration() {
		enableHardcoreMode = configuration.getBoolean("Hardcore Mode", Configuration.CATEGORY_GENERAL, false, "Enable/Disable Hardcore Mode");
		enableKyrul = configuration.getBoolean("Enable Ky'rul", "Dimension", true, "Enable/Disable the Ky'rul Dimension");
		enableIridis = configuration.getBoolean("Enable Iri'dis", "Dimension", true, "Enable/Disable the Iri'dis Dimension");
		enableGlaciem = configuration.getBoolean("Enable Glaciem", "Dimension", true, "Enable/Disable the Glaciem Dimension");
		kyrulDimensionId = configuration.getInt("Ky'rul Dimension ID", "Dimension", 47, Integer.MIN_VALUE, Integer.MAX_VALUE, "The dimension ID for the Ky'rul Dimension.");
		iridisDimensionId = configuration.getInt("Iri'dis Dimension ID", "Dimension", 48, Integer.MIN_VALUE, Integer.MAX_VALUE, "The dimension ID for the Iri'dis Dimension.");
		glaciemDimensionId = configuration.getInt("Glaciem Dimension ID", "Dimension", 49, Integer.MIN_VALUE, Integer.MAX_VALUE, "The dimension ID for the Glaciem Dimension.");
		if (configuration.hasChanged()) {
			configuration.save();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}
	
	public static boolean getHardcoreModeEnabled() { return enableHardcoreMode; }
	public static boolean getKyrulEnabled() { return enableKyrul; }
	public static boolean getIridisEnabled() { return enableIridis; }
	public static boolean getGlaciemEnabled() { return enableGlaciem; }
	public static int getKyrulId() { return kyrulDimensionId; }
	public static int getIridisId() { return iridisDimensionId; }
	public static int getGlaciemId() { return glaciemDimensionId; }
}