package net.malteada.supplyme.block.custom;

import net.fabricmc.loader.impl.lib.sat4j.specs.IVec;
import net.malteada.supplyme.block.ModBlocks;
import net.malteada.supplyme.block.blockentities.CrateAirDropBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class CrateAirDropBlock extends HorizontalFacingBlock implements InventoryProvider {
    private DefaultedList<ItemStack> inventory;
    public static final IntegerProperty INVENTORY_SIZE = IntegerProperty.of("inventory_size", 0, 6);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CrateAirDropBlock(Settings settings) {

        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
        this.setDefaultState(this.getDefaultState().with(INVENTORY_SIZE, 0));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


//

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        // Create a new CrateAirDropBlockEntity
        return new CrateAirDropBlockEntity(pos, state);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        // Add the INVENTORY_SIZE property to the block state
        builder.add(INVENTORY_SIZE);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Set the block state with the initial inventory size
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(INVENTORY_SIZE, 0);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            // Get the block entity for the crate
            CrateAirDropBlockEntity blockEntity = (CrateAirDropBlockEntity) world.getBlockEntity(pos);
            if (blockEntity != null) {
                // Open the container screen for the player
                player.openHandledScreen(blockEntity);
            }
            return ActionResult.CONSUME;
        }
    }
    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        // Get the block entity for the crate and return its inventory
        CrateAirDropBlockEntity blockEntity = (CrateAirDropBlockEntity) world.getBlockEntity(pos);
        return blockEntity.getInventory(state);
    }
}
