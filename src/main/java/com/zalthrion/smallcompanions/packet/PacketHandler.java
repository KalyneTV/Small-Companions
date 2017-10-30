package com.zalthrion.smallcompanions.packet;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.zalthrion.smallcompanions.reference.Reference;

public class PacketHandler {
	public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	public static final int summonPacketID = 0;
	public static final int dismissPacketID = 1;
	public static final int ownedMountsPacketID = 2;
	public static final int keyPressPacketID = 3;
	
	public static void preInit() {
		network.registerMessage(SummonMessage.Handler.class, SummonMessage.class, summonPacketID, Side.SERVER);
		network.registerMessage(DismissMessage.Handler.class, DismissMessage.class, dismissPacketID, Side.SERVER);
		network.registerMessage(SummonedMountMessage.Handler.class, SummonedMountMessage.class, ownedMountsPacketID, Side.CLIENT);
		network.registerMessage(KeyPressMessage.Handler.class, KeyPressMessage.class, keyPressPacketID, Side.SERVER);
	}
}