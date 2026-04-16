package com.actuallymultiplications.registry;

import com.actuallymultiplications.ActuallyMultiplications;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ActuallyMultiplicationsItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ActuallyMultiplications.MOD_ID);

    public static final DeferredItem<Item> DIAMATINE_HELMET = armor("diamatine_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_CHESTPLATE = armor("diamatine_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_LEGGINGS = armor("diamatine_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.DIAMATINE);
    public static final DeferredItem<Item> DIAMATINE_BOOTS = armor("diamatine_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.DIAMATINE);

    public static final DeferredItem<Item> EMERADIC_HELMET = armor("emeradic_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_CHESTPLATE = armor("emeradic_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_LEGGINGS = armor("emeradic_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.EMERADIC);
    public static final DeferredItem<Item> EMERADIC_BOOTS = armor("emeradic_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.EMERADIC);

    public static final DeferredItem<Item> ENORI_HELMET = armor("enori_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_CHESTPLATE = armor("enori_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_LEGGINGS = armor("enori_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.ENORI);
    public static final DeferredItem<Item> ENORI_BOOTS = armor("enori_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.ENORI);

    public static final DeferredItem<Item> PALIS_HELMET = armor("palis_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_CHESTPLATE = armor("palis_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_LEGGINGS = armor("palis_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.PALIS);
    public static final DeferredItem<Item> PALIS_BOOTS = armor("palis_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.PALIS);

    public static final DeferredItem<Item> RESTONIA_HELMET = armor("restonia_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_CHESTPLATE = armor("restonia_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_LEGGINGS = armor("restonia_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.RESTONIA);
    public static final DeferredItem<Item> RESTONIA_BOOTS = armor("restonia_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.RESTONIA);

    public static final DeferredItem<Item> VOID_HELMET = armor("void_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_CHESTPLATE = armor("void_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_LEGGINGS = armor("void_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.VOID);
    public static final DeferredItem<Item> VOID_BOOTS = armor("void_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.VOID);

    public static final DeferredItem<Item> BLACK_QUARTZ_HELMET = armor("black_quartz_helmet", ArmorItem.Type.HELMET, ActuallyMultiplicationsArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_CHESTPLATE = armor("black_quartz_chestplate", ArmorItem.Type.CHESTPLATE, ActuallyMultiplicationsArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_LEGGINGS = armor("black_quartz_leggings", ArmorItem.Type.LEGGINGS, ActuallyMultiplicationsArmorMaterials.BLACK_QUARTZ);
    public static final DeferredItem<Item> BLACK_QUARTZ_BOOTS = armor("black_quartz_boots", ArmorItem.Type.BOOTS, ActuallyMultiplicationsArmorMaterials.BLACK_QUARTZ);

    static {
        ActuallyMultiplicationsToolItems.SHOVELS.size();
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

    private ActuallyMultiplicationsItems() {
    }
}
