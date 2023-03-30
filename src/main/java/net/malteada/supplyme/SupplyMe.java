package net.malteada.supplyme;

import net.fabricmc.api.ModInitializer;
import net.malteada.supplyme.block.ModBlocks;
import net.malteada.supplyme.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupplyMe implements ModInitializer {
	public static final String MOD_ID = "supplyme";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}

}
