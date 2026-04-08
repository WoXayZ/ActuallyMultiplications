package com.actuallymultiplications;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public final class ModToolItems {

    public static final DeferredItem<Item> DIAMATINE_SHOVEL = registerShovel(ModToolTier.DIAMATINE, "diamatine_shovel");
    public static final DeferredItem<Item> DIAMATINE_PICKAXE = registerPickaxe(ModToolTier.DIAMATINE, "diamatine_pickaxe");
    public static final DeferredItem<Item> DIAMATINE_AXE = registerAxe(ModToolTier.DIAMATINE, "diamatine_axe");
    public static final DeferredItem<Item> DIAMATINE_HOE = registerHoe(ModToolTier.DIAMATINE, "diamatine_hoe");
    public static final DeferredItem<Item> DIAMATINE_SWORD = registerSword(ModToolTier.DIAMATINE, "diamatine_sword");
    public static final DeferredItem<Item> DIAMATINE_AIOT = registerAiot(ModToolTier.DIAMATINE, "diamatine_aiot");

    public static final DeferredItem<Item> EMERADIC_SHOVEL = registerShovel(ModToolTier.EMERADIC, "emeradic_shovel");
    public static final DeferredItem<Item> EMERADIC_PICKAXE = registerPickaxe(ModToolTier.EMERADIC, "emeradic_pickaxe");
    public static final DeferredItem<Item> EMERADIC_AXE = registerAxe(ModToolTier.EMERADIC, "emeradic_axe");
    public static final DeferredItem<Item> EMERADIC_HOE = registerHoe(ModToolTier.EMERADIC, "emeradic_hoe");
    public static final DeferredItem<Item> EMERADIC_SWORD = registerSword(ModToolTier.EMERADIC, "emeradic_sword");
    public static final DeferredItem<Item> EMERADIC_AIOT = registerAiot(ModToolTier.EMERADIC, "emeradic_aiot");

    public static final DeferredItem<Item> ENORI_SHOVEL = registerShovel(ModToolTier.ENORI, "enori_shovel");
    public static final DeferredItem<Item> ENORI_PICKAXE = registerPickaxe(ModToolTier.ENORI, "enori_pickaxe");
    public static final DeferredItem<Item> ENORI_AXE = registerAxe(ModToolTier.ENORI, "enori_axe");
    public static final DeferredItem<Item> ENORI_HOE = registerHoe(ModToolTier.ENORI, "enori_hoe");
    public static final DeferredItem<Item> ENORI_SWORD = registerSword(ModToolTier.ENORI, "enori_sword");
    public static final DeferredItem<Item> ENORI_AIOT = registerAiot(ModToolTier.ENORI, "enori_aiot");

    public static final DeferredItem<Item> PALIS_SHOVEL = registerShovel(ModToolTier.PALIS, "palis_shovel");
    public static final DeferredItem<Item> PALIS_PICKAXE = registerPickaxe(ModToolTier.PALIS, "palis_pickaxe");
    public static final DeferredItem<Item> PALIS_AXE = registerAxe(ModToolTier.PALIS, "palis_axe");
    public static final DeferredItem<Item> PALIS_HOE = registerHoe(ModToolTier.PALIS, "palis_hoe");
    public static final DeferredItem<Item> PALIS_SWORD = registerSword(ModToolTier.PALIS, "palis_sword");
    public static final DeferredItem<Item> PALIS_AIOT = registerAiot(ModToolTier.PALIS, "palis_aiot");

    public static final DeferredItem<Item> RESTONIA_SHOVEL = registerShovel(ModToolTier.RESTONIA, "restonia_shovel");
    public static final DeferredItem<Item> RESTONIA_PICKAXE = registerPickaxe(ModToolTier.RESTONIA, "restonia_pickaxe");
    public static final DeferredItem<Item> RESTONIA_AXE = registerAxe(ModToolTier.RESTONIA, "restonia_axe");
    public static final DeferredItem<Item> RESTONIA_HOE = registerHoe(ModToolTier.RESTONIA, "restonia_hoe");
    public static final DeferredItem<Item> RESTONIA_SWORD = registerSword(ModToolTier.RESTONIA, "restonia_sword");
    public static final DeferredItem<Item> RESTONIA_AIOT = registerAiot(ModToolTier.RESTONIA, "restonia_aiot");

    public static final DeferredItem<Item> VOID_SHOVEL = registerShovel(ModToolTier.VOID, "void_shovel");
    public static final DeferredItem<Item> VOID_PICKAXE = registerPickaxe(ModToolTier.VOID, "void_pickaxe");
    public static final DeferredItem<Item> VOID_AXE = registerAxe(ModToolTier.VOID, "void_axe");
    public static final DeferredItem<Item> VOID_HOE = registerHoe(ModToolTier.VOID, "void_hoe");
    public static final DeferredItem<Item> VOID_SWORD = registerSword(ModToolTier.VOID, "void_sword");
    public static final DeferredItem<Item> VOID_AIOT = registerAiot(ModToolTier.VOID, "void_aiot");

    public static final DeferredItem<Item> BLACK_QUARTZ_SHOVEL = registerShovel(ModToolTier.BLACK_QUARTZ, "black_quartz_shovel");
    public static final DeferredItem<Item> BLACK_QUARTZ_PICKAXE = registerPickaxe(ModToolTier.BLACK_QUARTZ, "black_quartz_pickaxe");
    public static final DeferredItem<Item> BLACK_QUARTZ_AXE = registerAxe(ModToolTier.BLACK_QUARTZ, "black_quartz_axe");
    public static final DeferredItem<Item> BLACK_QUARTZ_HOE = registerHoe(ModToolTier.BLACK_QUARTZ, "black_quartz_hoe");
    public static final DeferredItem<Item> BLACK_QUARTZ_SWORD = registerSword(ModToolTier.BLACK_QUARTZ, "black_quartz_sword");
    public static final DeferredItem<Item> BLACK_QUARTZ_AIOT = registerAiot(ModToolTier.BLACK_QUARTZ, "black_quartz_aiot");

    public static final List<DeferredItem<Item>> SHOVELS = List.of(
            RESTONIA_SHOVEL, PALIS_SHOVEL, DIAMATINE_SHOVEL, VOID_SHOVEL, EMERADIC_SHOVEL, ENORI_SHOVEL, BLACK_QUARTZ_SHOVEL
    );
    public static final List<DeferredItem<Item>> PICKAXES = List.of(
            RESTONIA_PICKAXE, PALIS_PICKAXE, DIAMATINE_PICKAXE, VOID_PICKAXE, EMERADIC_PICKAXE, ENORI_PICKAXE, BLACK_QUARTZ_PICKAXE
    );
    public static final List<DeferredItem<Item>> AXES = List.of(
            RESTONIA_AXE, PALIS_AXE, DIAMATINE_AXE, VOID_AXE, EMERADIC_AXE, ENORI_AXE, BLACK_QUARTZ_AXE
    );
    public static final List<DeferredItem<Item>> HOES = List.of(
            RESTONIA_HOE, PALIS_HOE, DIAMATINE_HOE, VOID_HOE, EMERADIC_HOE, ENORI_HOE, BLACK_QUARTZ_HOE
    );
    public static final List<DeferredItem<Item>> SWORDS = List.of(
            RESTONIA_SWORD, PALIS_SWORD, DIAMATINE_SWORD, VOID_SWORD, EMERADIC_SWORD, ENORI_SWORD, BLACK_QUARTZ_SWORD
    );
    public static final List<DeferredItem<Item>> AIOTS = List.of(
            RESTONIA_AIOT, PALIS_AIOT, DIAMATINE_AIOT, VOID_AIOT, EMERADIC_AIOT, ENORI_AIOT, BLACK_QUARTZ_AIOT
    );

    private static DeferredItem<Item> registerShovel(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new ShovelItem(tier, tier.withShovel(p)));
    }

    private static DeferredItem<Item> registerPickaxe(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new PickaxeItem(tier, tier.withPickaxe(p)));
    }

    private static DeferredItem<Item> registerAxe(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new AxeItem(tier, tier.withAxe(p)));
    }

    private static DeferredItem<Item> registerHoe(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new HoeItem(tier, tier.withHoe(p)));
    }

    private static DeferredItem<Item> registerSword(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new SwordItem(tier, tier.withSword(p)));
    }

    private static DeferredItem<Item> registerAiot(ModToolTier tier, String id) {
        return ModItems.ITEMS.registerItem(id, p -> new CrystalAllInOneTool(tier, p));
    }

    private ModToolItems() {
    }
}
