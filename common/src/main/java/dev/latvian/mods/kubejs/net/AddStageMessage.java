package dev.latvian.mods.kubejs.net;

import dev.architectury.networking.NetworkManager.PacketContext;
import dev.architectury.networking.simple.BaseS2CMessage;
import dev.architectury.networking.simple.MessageType;
import dev.latvian.mods.kubejs.stages.Stages;
import net.minecraft.network.FriendlyByteBuf;

import java.util.UUID;

/**
 * @author LatvianModder
 */
public class AddStageMessage extends BaseS2CMessage {
	private final UUID player;
	private final String stage;

	public AddStageMessage(UUID p, String s) {
		player = p;
		stage = s;
	}

	AddStageMessage(FriendlyByteBuf buf) {
		player = buf.readUUID();
		stage = buf.readUtf(Short.MAX_VALUE);
	}

	@Override
	public MessageType getType() {
		return KubeJSNet.ADD_STAGE;
	}

	@Override
	public void write(FriendlyByteBuf buf) {
		buf.writeUUID(player);
		buf.writeUtf(stage, Short.MAX_VALUE);
	}

	@Override
	public void handle(PacketContext context) {
		var p0 = context.getPlayer();
		var p = player.equals(p0.getUUID()) ? p0 : p0.level.getPlayerByUUID(player);

		if (p != null) {
			Stages.get(p).add(stage);
		}
	}
}