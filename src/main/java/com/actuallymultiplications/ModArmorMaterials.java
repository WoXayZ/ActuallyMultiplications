package com.actuallymultiplications;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, ActuallyMultiplications.MOD_ID);

    /** Diamond +1 (3/8/6/3 → 4/9/7/4). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> DIAMATINE =
            register("diamatine", 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F,
                    "diamatine_armor_repair_materials",
                    4, 7, 9, 4, 12);

    /** Diamatine +0.5 per piece (rounded half up). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> EMERADIC =
            register("emeradic", 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F,
                    "emeradic_armor_repair_materials",
                    5, 8, 10, 5, 13);

    /** Iron +1 (2/6/5/2 → 3/7/6/3). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENORI =
            register("enori", 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
                    "enori_armor_repair_materials",
                    3, 6, 7, 3, 12);

    /** Chainmail +0.5 (2/5/4/1 → 3/6/5/2). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PALIS =
            register("palis", 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F,
                    "palis_armor_repair_materials",
                    2, 5, 6, 3, 10);

    /** Same stats as Palis (chainmail +0.5). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> RESTONIA =
            register("restonia", 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F,
                    "restonia_armor_repair_materials",
                    2, 5, 6, 3, 10);

    /** Chainmail (2/5/4/1). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VOID =
            register("void", 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F,
                    "void_armor_repair_materials",
                    1, 4, 5, 2, 9);

    /** Iron (2/6/5/2). */
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BLACK_QUARTZ =
            register("black_quartz", 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
                    "black_quartz_armor_repair_materials",
                    2, 5, 6, 2, 11);

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name,
            int enchantability,
            Holder<SoundEvent> equipSound,
            float toughness,
            String repairTagPath,
            int boots,
            int leggings,
            int chestplate,
            int helmet,
            int body
    ) {
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(
                defense(boots, leggings, chestplate, helmet, body),
                enchantability,
                equipSound,
                () -> Ingredient.of(repairTag(repairTagPath)),
                layers(name),
                toughness,
                0.0F
        ));
    }

    private static EnumMap<ArmorItem.Type, Integer> defense(
            int boots, int leggings, int chestplate, int helmet, int body
    ) {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, boots);
            map.put(ArmorItem.Type.LEGGINGS, leggings);
            map.put(ArmorItem.Type.CHESTPLATE, chestplate);
            map.put(ArmorItem.Type.HELMET, helmet);
            map.put(ArmorItem.Type.BODY, body);
        });
    }

    private static List<ArmorMaterial.Layer> layers(String textureBase) {
        var id = ActuallyMultiplications.loc(textureBase);
        return List.of(
                new ArmorMaterial.Layer(id, "", false),
                new ArmorMaterial.Layer(id, "", false)
        );
    }

    private static TagKey<Item> repairTag(String path) {
        return TagKey.create(Registries.ITEM, ActuallyMultiplications.loc(path));
    }

    private ModArmorMaterials() {
    }
}
