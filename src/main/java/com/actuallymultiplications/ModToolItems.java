package com.actuallymultiplications;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

/**
 * Outils cristal : mêmes {@link ModToolTier} que les armures. Enregistrés sur {@link ModItems#ITEMS}.
 */
public final class ModToolItems {

    public static final DeferredItem<Item> DIAMATINE_SHOVEL =
            ModItems.ITEMS.registerItem("diamatine_shovel", p -> new ShovelItem(ModToolTier.DIAMATINE, p));
    public static final DeferredItem<Item> DIAMATINE_PICKAXE =
            ModItems.ITEMS.registerItem("diamatine_pickaxe", p -> new PickaxeItem(ModToolTier.DIAMATINE, p));
    public static final DeferredItem<Item> DIAMATINE_AXE =
            ModItems.ITEMS.registerItem("diamatine_axe", p -> new AxeItem(ModToolTier.DIAMATINE, p));
    public static final DeferredItem<Item> DIAMATINE_HOE =
            ModItems.ITEMS.registerItem("diamatine_hoe", p -> new HoeItem(ModToolTier.DIAMATINE, p));
    public static final DeferredItem<Item> DIAMATINE_SWORD =
            ModItems.ITEMS.registerItem("diamatine_sword", p -> new SwordItem(ModToolTier.DIAMATINE, p));
    public static final DeferredItem<Item> DIAMATINE_AIOT =
            ModItems.ITEMS.registerItem("diamatine_aiot", p -> new CrystalAllInOneTool(ModToolTier.DIAMATINE, p));

    public static final DeferredItem<Item> EMERADIC_SHOVEL =
            ModItems.ITEMS.registerItem("emeradic_shovel", p -> new ShovelItem(ModToolTier.EMERADIC, p));
    public static final DeferredItem<Item> EMERADIC_PICKAXE =
            ModItems.ITEMS.registerItem("emeradic_pickaxe", p -> new PickaxeItem(ModToolTier.EMERADIC, p));
    public static final DeferredItem<Item> EMERADIC_AXE =
            ModItems.ITEMS.registerItem("emeradic_axe", p -> new AxeItem(ModToolTier.EMERADIC, p));
    public static final DeferredItem<Item> EMERADIC_HOE =
            ModItems.ITEMS.registerItem("emeradic_hoe", p -> new HoeItem(ModToolTier.EMERADIC, p));
    public static final DeferredItem<Item> EMERADIC_SWORD =
            ModItems.ITEMS.registerItem("emeradic_sword", p -> new SwordItem(ModToolTier.EMERADIC, p));
    public static final DeferredItem<Item> EMERADIC_AIOT =
            ModItems.ITEMS.registerItem("emeradic_aiot", p -> new CrystalAllInOneTool(ModToolTier.EMERADIC, p));

    public static final DeferredItem<Item> ENORI_SHOVEL =
            ModItems.ITEMS.registerItem("enori_shovel", p -> new ShovelItem(ModToolTier.ENORI, p));
    public static final DeferredItem<Item> ENORI_PICKAXE =
            ModItems.ITEMS.registerItem("enori_pickaxe", p -> new PickaxeItem(ModToolTier.ENORI, p));
    public static final DeferredItem<Item> ENORI_AXE =
            ModItems.ITEMS.registerItem("enori_axe", p -> new AxeItem(ModToolTier.ENORI, p));
    public static final DeferredItem<Item> ENORI_HOE =
            ModItems.ITEMS.registerItem("enori_hoe", p -> new HoeItem(ModToolTier.ENORI, p));
    public static final DeferredItem<Item> ENORI_SWORD =
            ModItems.ITEMS.registerItem("enori_sword", p -> new SwordItem(ModToolTier.ENORI, p));
    public static final DeferredItem<Item> ENORI_AIOT =
            ModItems.ITEMS.registerItem("enori_aiot", p -> new CrystalAllInOneTool(ModToolTier.ENORI, p));

    public static final DeferredItem<Item> PALIS_SHOVEL =
            ModItems.ITEMS.registerItem("palis_shovel", p -> new ShovelItem(ModToolTier.PALIS, p));
    public static final DeferredItem<Item> PALIS_PICKAXE =
            ModItems.ITEMS.registerItem("palis_pickaxe", p -> new PickaxeItem(ModToolTier.PALIS, p));
    public static final DeferredItem<Item> PALIS_AXE =
            ModItems.ITEMS.registerItem("palis_axe", p -> new AxeItem(ModToolTier.PALIS, p));
    public static final DeferredItem<Item> PALIS_HOE =
            ModItems.ITEMS.registerItem("palis_hoe", p -> new HoeItem(ModToolTier.PALIS, p));
    public static final DeferredItem<Item> PALIS_SWORD =
            ModItems.ITEMS.registerItem("palis_sword", p -> new SwordItem(ModToolTier.PALIS, p));
    public static final DeferredItem<Item> PALIS_AIOT =
            ModItems.ITEMS.registerItem("palis_aiot", p -> new CrystalAllInOneTool(ModToolTier.PALIS, p));

    public static final DeferredItem<Item> RESTONIA_SHOVEL =
            ModItems.ITEMS.registerItem("restonia_shovel", p -> new ShovelItem(ModToolTier.RESTONIA, p));
    public static final DeferredItem<Item> RESTONIA_PICKAXE =
            ModItems.ITEMS.registerItem("restonia_pickaxe", p -> new PickaxeItem(ModToolTier.RESTONIA, p));
    public static final DeferredItem<Item> RESTONIA_AXE =
            ModItems.ITEMS.registerItem("restonia_axe", p -> new AxeItem(ModToolTier.RESTONIA, p));
    public static final DeferredItem<Item> RESTONIA_HOE =
            ModItems.ITEMS.registerItem("restonia_hoe", p -> new HoeItem(ModToolTier.RESTONIA, p));
    public static final DeferredItem<Item> RESTONIA_SWORD =
            ModItems.ITEMS.registerItem("restonia_sword", p -> new SwordItem(ModToolTier.RESTONIA, p));
    public static final DeferredItem<Item> RESTONIA_AIOT =
            ModItems.ITEMS.registerItem("restonia_aiot", p -> new CrystalAllInOneTool(ModToolTier.RESTONIA, p));

    public static final DeferredItem<Item> VOID_SHOVEL =
            ModItems.ITEMS.registerItem("void_shovel", p -> new ShovelItem(ModToolTier.VOID, p));
    public static final DeferredItem<Item> VOID_PICKAXE =
            ModItems.ITEMS.registerItem("void_pickaxe", p -> new PickaxeItem(ModToolTier.VOID, p));
    public static final DeferredItem<Item> VOID_AXE =
            ModItems.ITEMS.registerItem("void_axe", p -> new AxeItem(ModToolTier.VOID, p));
    public static final DeferredItem<Item> VOID_HOE =
            ModItems.ITEMS.registerItem("void_hoe", p -> new HoeItem(ModToolTier.VOID, p));
    public static final DeferredItem<Item> VOID_SWORD =
            ModItems.ITEMS.registerItem("void_sword", p -> new SwordItem(ModToolTier.VOID, p));
    public static final DeferredItem<Item> VOID_AIOT =
            ModItems.ITEMS.registerItem("void_aiot", p -> new CrystalAllInOneTool(ModToolTier.VOID, p));

    public static final DeferredItem<Item> BLACK_QUARTZ_SHOVEL =
            ModItems.ITEMS.registerItem("black_quartz_shovel", p -> new ShovelItem(ModToolTier.BLACK_QUARTZ, p));
    public static final DeferredItem<Item> BLACK_QUARTZ_PICKAXE =
            ModItems.ITEMS.registerItem("black_quartz_pickaxe", p -> new PickaxeItem(ModToolTier.BLACK_QUARTZ, p));
    public static final DeferredItem<Item> BLACK_QUARTZ_AXE =
            ModItems.ITEMS.registerItem("black_quartz_axe", p -> new AxeItem(ModToolTier.BLACK_QUARTZ, p));
    public static final DeferredItem<Item> BLACK_QUARTZ_HOE =
            ModItems.ITEMS.registerItem("black_quartz_hoe", p -> new HoeItem(ModToolTier.BLACK_QUARTZ, p));
    public static final DeferredItem<Item> BLACK_QUARTZ_SWORD =
            ModItems.ITEMS.registerItem("black_quartz_sword", p -> new SwordItem(ModToolTier.BLACK_QUARTZ, p));
    public static final DeferredItem<Item> BLACK_QUARTZ_AIOT =
            ModItems.ITEMS.registerItem("black_quartz_aiot", p -> new CrystalAllInOneTool(ModToolTier.BLACK_QUARTZ, p));

    /**
     * Ordre des paliers (cohérent avec l’onglet créatif) : restonia → palis → diamatine → void → emeradic → enori → black quartz.
     */
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

    private ModToolItems() {
    }
}
