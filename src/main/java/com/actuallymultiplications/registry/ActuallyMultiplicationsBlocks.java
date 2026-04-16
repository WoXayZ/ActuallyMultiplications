package com.actuallymultiplications.registry;

import com.actuallymultiplications.ActuallyMultiplications;
import com.actuallymultiplications.world.block.ethetic.EtheticQuartzColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class ActuallyMultiplicationsBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ActuallyMultiplications.MOD_ID);

    public static final List<DeferredItem<BlockItem>> ALL_BLOCK_ITEMS = new ArrayList<>();

    public static final QuartzFamily ETHETIC_QUARTZ_TILES =
            registerFamily("ethetic_quartz_tiles", "ethetic_quartz_tile", false, MapColor.QUARTZ);
    public static final QuartzFamily CHISELED_ETHETIC_QUARTZ =
            registerFamily("chiseled_ethetic_quartz", "chiseled_ethetic_quartz", false, MapColor.QUARTZ);
    public static final QuartzFamily ETHETIC_QUARTZ_BRICKS =
            registerFamily("ethetic_quartz_bricks", "ethetic_quartz_brick", false, MapColor.QUARTZ);
    public static final QuartzFamily ETHETIC_QUARTZ_PILLAR =
            registerFamily("ethetic_quartz_pillar", "ethetic_quartz_pillar", true, MapColor.QUARTZ);

    public static final QuartzFamily ETHETIC_GREEN_QUARTZ_TILES =
            registerFamily("ethetic_green_quartz_tiles", "ethetic_green_quartz_tile", false, MapColor.COLOR_GREEN);
    public static final QuartzFamily CHISELED_ETHETIC_GREEN_QUARTZ =
            registerFamily("chiseled_ethetic_green_quartz", "chiseled_ethetic_green_quartz", false, MapColor.COLOR_GREEN);
    public static final QuartzFamily ETHETIC_GREEN_QUARTZ_BRICKS =
            registerFamily("ethetic_green_quartz_bricks", "ethetic_green_quartz_brick", false, MapColor.COLOR_GREEN);
    public static final QuartzFamily ETHETIC_GREEN_QUARTZ_PILLAR =
            registerFamily("ethetic_green_quartz_pillar", "ethetic_green_quartz_pillar", true, MapColor.COLOR_GREEN);

    public static final List<ColoredEtheticSet> COLORED_ETHETIC = new ArrayList<>();

    static {
        for (EtheticQuartzColor c : EtheticQuartzColor.values()) {
            COLORED_ETHETIC.add(registerColoredLine(c));
        }

        addItems(
                ETHETIC_QUARTZ_TILES,
                CHISELED_ETHETIC_QUARTZ,
                ETHETIC_QUARTZ_BRICKS,
                ETHETIC_QUARTZ_PILLAR,
                ETHETIC_GREEN_QUARTZ_TILES,
                CHISELED_ETHETIC_GREEN_QUARTZ,
                ETHETIC_GREEN_QUARTZ_BRICKS,
                ETHETIC_GREEN_QUARTZ_PILLAR
        );
        for (ColoredEtheticSet set : COLORED_ETHETIC) {
            ALL_BLOCK_ITEMS.addAll(set.allItems());
        }
    }

    private ActuallyMultiplicationsBlocks() {
    }

    private static void addItems(QuartzFamily... families) {
        for (QuartzFamily f : families) {
            ALL_BLOCK_ITEMS.addAll(f.items());
        }
    }

    private static ColoredEtheticSet registerColoredLine(EtheticQuartzColor c) {
        MapColor mc = c.mapColor();
        String stem = c.stem();
        QuartzFamily smooth = registerFamily(stem, stem, false, mc);
        QuartzFamily tiles = registerFamily(stem + "_tiles", stem + "_tile", false, mc);
        String chiseledId = c.chiseledBlockId();
        QuartzFamily chiseled = registerFamily(chiseledId, chiseledId, false, mc);
        QuartzFamily bricks = registerFamily(stem + "_bricks", stem + "_brick", false, mc);
        QuartzFamily pillar = registerFamily(stem + "_pillar", stem + "_pillar", true, mc);
        return new ColoredEtheticSet(c, smooth, tiles, chiseled, bricks, pillar);
    }

    private static BlockBehaviour.Properties blockProps(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(0.8F, 6.0F)
                .sound(SoundType.DEEPSLATE_TILES)
                .requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties wallProps(MapColor mapColor) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL)
                .strength(0.8F, 6.0F)
                .sound(SoundType.DEEPSLATE_TILES)
                .requiresCorrectToolForDrops()
                .mapColor(mapColor);
    }

    private static QuartzFamily registerFamily(
            String blockId,
            String shapeStem,
            boolean pillar,
            MapColor mapColor
    ) {
        BlockBehaviour.Properties fullProps = blockProps(mapColor);
        DeferredBlock<Block> full = BLOCKS.register(blockId, () -> pillar
                ? new RotatedPillarBlock(fullProps)
                : new Block(fullProps));

        DeferredBlock<SlabBlock> slab = BLOCKS.register(shapeStem + "_slab", () -> {
            Block b = full.get();
            return new SlabBlock(BlockBehaviour.Properties.ofFullCopy(b));
        });

        DeferredBlock<StairBlock> stairs = BLOCKS.register(shapeStem + "_stairs", () -> {
            Block b = full.get();
            BlockState baseForStairs = pillar ? Blocks.STONE.defaultBlockState() : b.defaultBlockState();
            return new StairBlock(baseForStairs, BlockBehaviour.Properties.ofFullCopy(b));
        });

        DeferredBlock<WallBlock> wall = BLOCKS.register(shapeStem + "_wall", () -> new WallBlock(wallProps(mapColor)));

        DeferredItem<BlockItem> fullItem = blockItem(blockId, full);
        DeferredItem<BlockItem> slabItem = blockItem(shapeStem + "_slab", slab);
        DeferredItem<BlockItem> stairsItem = blockItem(shapeStem + "_stairs", stairs);
        DeferredItem<BlockItem> wallItem = blockItem(shapeStem + "_wall", wall);

        return new QuartzFamily(full, slab, stairs, wall, fullItem, slabItem, stairsItem, wallItem);
    }

    private static <B extends Block> DeferredItem<BlockItem> blockItem(String id, DeferredBlock<B> block) {
        return ActuallyMultiplicationsItems.ITEMS.registerItem(id, p -> new BlockItem(block.get(), p));
    }

    public record QuartzFamily(
            DeferredBlock<Block> block,
            DeferredBlock<SlabBlock> slab,
            DeferredBlock<StairBlock> stairs,
            DeferredBlock<WallBlock> wall,
            DeferredItem<BlockItem> blockItem,
            DeferredItem<BlockItem> slabItem,
            DeferredItem<BlockItem> stairsItem,
            DeferredItem<BlockItem> wallItem
    ) {
        List<DeferredItem<BlockItem>> items() {
            return List.of(blockItem, slabItem, stairsItem, wallItem);
        }
    }

    public record ColoredEtheticSet(
            EtheticQuartzColor color,
            QuartzFamily smooth,
            QuartzFamily tiles,
            QuartzFamily chiseled,
            QuartzFamily bricks,
            QuartzFamily pillar
    ) {
        List<DeferredItem<BlockItem>> allItems() {
            return Stream.of(smooth, tiles, chiseled, bricks, pillar)
                    .flatMap(f -> f.items().stream())
                    .toList();
        }
    }

    public static List<DeferredItem<BlockItem>> allBlockItemsView() {
        return Collections.unmodifiableList(ALL_BLOCK_ITEMS);
    }
}
