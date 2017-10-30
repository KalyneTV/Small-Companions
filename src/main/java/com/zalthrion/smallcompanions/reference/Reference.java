package com.zalthrion.smallcompanions.reference;

public class Reference {
	public static final String MOD_ID = "smallcompanions";
	public static final String MOD_NAME = "Small COmpanions";
	public static final String MINECRAFT_VERSION = "1.12.2";
	public static final String VERSION = "1.0.0";
	public static final String CLIENT_PROXY = "com.zalthrion.smallcompanions.proxy.ClientProxy";
	public static final String COMMON_PROXY = "com.zalthrion.smallcompanions.proxy.CommonProxy";
	public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";
	
	public static class GuiIDs {
		public static final int SUMMON = 0;
	}
	
	/**
	 * This class is for referencing IDs related to mounts/pets for use in packets/GUIs.<br>
	 * Whenever an ID is added include it in:<br>
	 * {@link SummonMessage.Handler}<br>
	 * {@link GuiSummon}
	 */
	public static class MountIDs {
		public static final int deathcharger = 0;
		public static final int plaguedHorse = 1;
		public static final int savageBadger = 2;
		public static final int swiftUnicorn = 3;
		public static final int warTortoise = 4;
	}
}