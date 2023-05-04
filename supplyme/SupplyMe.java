package net.malteada.supplyme;

import net.fabricmc.api.ModInitializer;
import net.malteada.supplyme.block.ModBlocks;
import net.malteada.supplyme.block.blockentities.CrateAirDropBlockEntity;
import net.malteada.supplyme.item.ModItems;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupplyMe implements ModInitializer {
	public static final String MOD_ID = "supplyme";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final BlockEntityType<CrateAirDropBlockEntity> CRATE_BLOCK_ENTITY_TYPE =
			BlockEntityType.Builder.create(CrateAirDropBlockEntity::createCrateAirDropBlockEntity, 	SupplyMe.CRATE).build(null);
	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("supplyme", "crate_airdrop"), CRATE_BLOCK_ENTITY_TYPE);

	}

}
