package meldexun.better_diving.client;

import java.util.ArrayList;
import java.util.List;
import meldexun.better_diving.BetterDiving;
import meldexun.better_diving.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(modid = BetterDiving.MOD_ID, value = Side.CLIENT)
public class ItemModels {

	private ItemModels() {

	}

	
	private static final List<Item> REGISTERED_ITEM_MODELS = new ArrayList<>();

	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		for (Item item : ModItems.ItemRegistrationHandler.ITEMS) {
			if (!ItemModels.REGISTERED_ITEM_MODELS.contains(item)) {
				ItemModels.registerItemModel(item);
			}
		}
	}

	private static void registerItemModel(Item item) {
		ItemModels.registerCustomItemModel(item, 0, item.getRegistryName(), "inventory");
	}

	private static void registerCustomItemModel(Item item, int meta, ResourceLocation modelLocation, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modelLocation, variant));
		ItemModels.REGISTERED_ITEM_MODELS.add(item);
	}

}
