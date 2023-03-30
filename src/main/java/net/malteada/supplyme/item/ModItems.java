package net.malteada.supplyme.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.malteada.supplyme.SupplyMe;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SupplyMe.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SupplyMe.LOGGER.debug("Registering Mod Items for " + SupplyMe.MOD_ID);
    }
}
