package com.zalthrion.smallcompanions.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SummonedMountMessage implements IMessage {
	public static int summonedMountStatic = -1;
	private int summonedMount;
	
	public SummonedMountMessage() {
		this.summonedMount = -1;
	}
	
	public SummonedMountMessage(int summonedMount) {
		this.summonedMount = summonedMount;
	}
	
	@Override public void fromBytes(ByteBuf buf) {
		this.summonedMount = buf.readInt();
	}
	
	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(this.summonedMount);
	}
	
	public static class Handler implements IMessageHandler<SummonedMountMessage, IMessage> {
		@Override public IMessage onMessage(SummonedMountMessage message, MessageContext ctx) {
			SummonedMountMessage.summonedMountStatic = message.summonedMount;
			return null;
		}
	}
}