package meldexun.better_diving.init;

import meldexun.better_diving.BetterDiving;
import meldexun.better_diving.network.handler.CPacketHandlerSyncConfig;
import meldexun.better_diving.network.handler.CPacketHandlerSyncOxygen;
import meldexun.better_diving.network.handler.CPacketHandlerSyncPlayerInput;
import meldexun.better_diving.network.handler.SPacketHandlerCraftRecipe;
import meldexun.better_diving.network.handler.SPacketHandlerSyncPlayerInput;
import meldexun.better_diving.network.packet.CPacketCraftRecipe;
import meldexun.better_diving.network.packet.CPacketSyncPlayerInput;
import meldexun.better_diving.network.packet.SPacketSyncConfig;
import meldexun.better_diving.network.packet.SPacketSyncOxygen;
import meldexun.better_diving.network.packet.SPacketSyncPlayerInput;
import net.minecraftforge.fml.relauncher.Side;

public class ModPackets {

	// Start the IDs at 1 so any unregistered messages (ID 0) throw a more obvious
	// exception when received
	private static int messageID = 1;

	private ModPackets() {

	}

	public static void registerMessages() {
		BetterDiving.network.registerMessage(CPacketHandlerSyncOxygen.class, SPacketSyncOxygen.class, ModPackets.messageID++, Side.CLIENT);
		BetterDiving.network.registerMessage(CPacketHandlerSyncConfig.class, SPacketSyncConfig.class, ModPackets.messageID++, Side.CLIENT);
		BetterDiving.network.registerMessage(CPacketHandlerSyncPlayerInput.class, SPacketSyncPlayerInput.class, ModPackets.messageID++, Side.CLIENT);
		BetterDiving.network.registerMessage(SPacketHandlerSyncPlayerInput.class, CPacketSyncPlayerInput.class, ModPackets.messageID++, Side.SERVER);
		BetterDiving.network.registerMessage(SPacketHandlerCraftRecipe.class, CPacketCraftRecipe.class, ModPackets.messageID++, Side.SERVER);
	}

}
