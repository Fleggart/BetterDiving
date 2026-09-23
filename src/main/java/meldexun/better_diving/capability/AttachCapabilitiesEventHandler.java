package meldexun.better_diving.capability;

import meldexun.better_diving.BetterDiving;
import meldexun.better_diving.capability.diving.CapabilityDivingAttributesProvider;
import meldexun.better_diving.capability.item.energy.CapabilityEnergyStorageItemProvider;
import meldexun.better_diving.capability.item.inventory.CapabilityItemHandlerItemProvider;
import meldexun.better_diving.capability.item.oxygen.CapabilityOxygenProvider;
import meldexun.better_diving.capability.inventory.CapabilityItemHandlerProvider;
import meldexun.better_diving.item.ItemDivingChest;
import meldexun.better_diving.item.ItemEnergyStorage;
import meldexun.better_diving.item.ItemTool;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = BetterDiving.MOD_ID)
public class AttachCapabilitiesEventHandler {

	private AttachCapabilitiesEventHandler() {

	}

	@SubscribeEvent
	public static void onAttachCapabilitiesEntityEvent(AttachCapabilitiesEvent<Entity> event) {
		Entity entity = event.getObject();
		if (entity instanceof EntityPlayer) {
			event.addCapability(CapabilityDivingAttributesProvider.LOCATION_DIVING_ATTRIBUTES, CapabilityDivingAttributesProvider.createProvider((EntityPlayer) entity));
		}
	}

	@SubscribeEvent
	public static void onAttachCapabilitiesItemStackEvent(AttachCapabilitiesEvent<ItemStack> event) {
		ItemStack stack = event.getObject();
		Item item = stack.getItem();
		if (item instanceof ItemDivingChest) {
			event.addCapability(CapabilityOxygenProvider.LOCATION_OXYGEN, CapabilityOxygenProvider.createProvider(stack));
		} else if (item instanceof ItemEnergyStorage) {
			event.addCapability(CapabilityEnergyStorageProvider.LOCATION_ENERGY_STORAGE, CapabilityEnergyStorageItemProvider.createProvider(stack));
		} else if (item instanceof ItemTool) {
			event.addCapability(CapabilityItemHandlerProvider.LOCATION_ITEM_STACK_HANDLER, CapabilityItemHandlerItemProvider.createProvider(stack, 1));
		}
	}

}
