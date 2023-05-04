package net.malteada.supplyme.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.malteada.supplyme.SupplyMe;
import net.malteada.supplyme.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
                new Identifier(SupplyMe.MOD_ID, "crate"), () -> new ItemStack(ModBlocks.CRATE));

}