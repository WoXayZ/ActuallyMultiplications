package com.actuallymultiplications;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ActuallyMultiplications.MOD_ID);

    public static final DeferredItem<Item> DIAMATINE_HELMET = armor("diamatine_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_CHESTPLATE = armor("diamatine_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_LEGGINGS = armor("diamatine_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_BOOTS = armor("diamatine_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.DIAMATINE);

    public static final DeferredItem<Item> EMERADIC_HELMET = armor("emeradic_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_CHESTPLATE = armor("emeradic_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_LEGGINGS = armor("emeradic_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_BOOTS = armor("emeradic_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.EMERADIC);

    public static final DeferredItem<Item> ENORI_HELMET = armor("enori_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_CHESTPLATE = armor("enori_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_LEGGINGS = armor("enori_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_BOOTS = armor("enori_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.ENORI);

    public static final DeferredItem<Item> PALIS_HELMET = armor("palis_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_CHESTPLATE = armor("palis_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_LEGGINGS = armor("palis_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_BOOTS = armor("palis_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.PALIS);

    public static final DeferredItem<Item> RESTONIA_HELMET = armor("restonia_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_CHESTPLATE = armor("restonia_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_LEGGINGS = armor("restonia_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_BOOTS = armor("restonia_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.RESTONIA);

    public static final DeferredItem<Item> VOID_HELMET = armor("void_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_CHESTPLATE = armor("void_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_LEGGINGS = armor("void_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_BOOTS = armor("void_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.VOID);

    public static final DeferredItem<Item> BLACK_QUARTZ_HELMET = armor("black_quartz_helmet", ArmorItem.Type.HELMET, ModArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_CHESTPLATE = armor("black_quartz_chestplate", ArmorItem.Type.CHESTPLATE, ModArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_LEGGINGS = armor("black_quartz_leggings", ArmorItem.Type.LEGGINGS, ModArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_BOOTS = armor("black_quartz_boots", ArmorItem.Type.BOOTS, ModArmorMaterials.BLACK_QUARTZ);

    static {
        ModToolItems.SHOVELS.size();
    }

    private static DeferredItem<Item> armor(
            String name,
            ArmorItem.Type type,
            DeferredHolder<ArmorMaterial, ArmorMaterial> material
    ) {
        return ITEMS.registerItem(name, props -> {
            Holder<ArmorMaterial> holder = material;
            return new ArmorItem(holder, type, props.stacksTo(1));
        });
    }

    private ModItems() {
    }
}
