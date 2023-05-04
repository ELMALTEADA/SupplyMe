package net.malteada.supplyme.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.malteada.supplyme.SupplyMe;
import net.malteada.supplyme.block.custom.CrateAirDropBlock;
import net.malteada.supplyme.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",

            new Block(FabricBlockSettings.of(Material.METAL).strength(4F).requiresTool()), ModItemGroup.TANZANITE);
    public static final Block CRATE = registerBlock("crate",
            new CrateAirDropBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4F).requiresTool().nonOpaque()), ModItemGroup.TANZANITE);




    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(SupplyMe.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(SupplyMe.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks(){
        SupplyMe.LOGGER.info("Registering ModBlocks for "+ SupplyMe.MOD_ID);
    }
}
