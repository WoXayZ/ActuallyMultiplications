package com.actuallymultiplications.event;

import com.actuallymultiplications.config.ArmorSetEffectsConfig;
import com.actuallymultiplications.registry.ActuallyMultiplicationsItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import org.slf4j.Logger;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ArmorSetBonusHandler {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final int REFRESH_TICKS = 220;

    private static final Set<String> LOGGED_UNKNOWN_EFFECTS = ConcurrentHashMap.newKeySet();

    private ArmorSetBonusHandler() {
    }

    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }
        for (ConfiguredArmorSet set : ConfiguredArmorSet.values()) {
            refresh(player, set);
        }
    }

    private static void refresh(Player player, ConfiguredArmorSet set) {
        if (!set.enabled.get()) {
            return;
        }
        if (!fullSet(player, set.helmet.get(), set.chestplate.get(), set.leggings.get(), set.boots.get())) {
            return;
        }
        Holder<MobEffect> effect = resolveEffect(set.effectId.get());
        if (effect == null) {
            return;
        }
        player.addEffect(new MobEffectInstance(effect, REFRESH_TICKS, set.amplifier.get(), false, false, true));
    }

    private enum ConfiguredArmorSet {
        DIAMATINE(
                ActuallyMultiplicationsItems.DIAMATINE_HELMET,
                ActuallyMultiplicationsItems.DIAMATINE_CHESTPLATE,
                ActuallyMultiplicationsItems.DIAMATINE_LEGGINGS,
                ActuallyMultiplicationsItems.DIAMATINE_BOOTS,
                ArmorSetEffectsConfig.DIAMATINE_ENABLED,
                ArmorSetEffectsConfig.DIAMATINE_AMPLIFIER,
                ArmorSetEffectsConfig.DIAMATINE_EFFECT
        ),
        EMERADIC(
                ActuallyMultiplicationsItems.EMERADIC_HELMET,
                ActuallyMultiplicationsItems.EMERADIC_CHESTPLATE,
                ActuallyMultiplicationsItems.EMERADIC_LEGGINGS,
                ActuallyMultiplicationsItems.EMERADIC_BOOTS,
                ArmorSetEffectsConfig.EMERADIC_ENABLED,
                ArmorSetEffectsConfig.EMERADIC_AMPLIFIER,
                ArmorSetEffectsConfig.EMERADIC_EFFECT
        ),
        ENORI(
                ActuallyMultiplicationsItems.ENORI_HELMET,
                ActuallyMultiplicationsItems.ENORI_CHESTPLATE,
                ActuallyMultiplicationsItems.ENORI_LEGGINGS,
                ActuallyMultiplicationsItems.ENORI_BOOTS,
                ArmorSetEffectsConfig.ENORI_ENABLED,
                ArmorSetEffectsConfig.ENORI_AMPLIFIER,
                ArmorSetEffectsConfig.ENORI_EFFECT
        ),
        BLACK_QUARTZ(
                ActuallyMultiplicationsItems.BLACK_QUARTZ_HELMET,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_CHESTPLATE,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_LEGGINGS,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_BOOTS,
                ArmorSetEffectsConfig.BLACK_QUARTZ_ENABLED,
                ArmorSetEffectsConfig.BLACK_QUARTZ_AMPLIFIER,
                ArmorSetEffectsConfig.BLACK_QUARTZ_EFFECT
        ),
        VOID(
                ActuallyMultiplicationsItems.VOID_HELMET,
                ActuallyMultiplicationsItems.VOID_CHESTPLATE,
                ActuallyMultiplicationsItems.VOID_LEGGINGS,
                ActuallyMultiplicationsItems.VOID_BOOTS,
                ArmorSetEffectsConfig.VOID_ENABLED,
                ArmorSetEffectsConfig.VOID_AMPLIFIER,
                ArmorSetEffectsConfig.VOID_EFFECT
        ),
        RESTONIA(
                ActuallyMultiplicationsItems.RESTONIA_HELMET,
                ActuallyMultiplicationsItems.RESTONIA_CHESTPLATE,
                ActuallyMultiplicationsItems.RESTONIA_LEGGINGS,
                ActuallyMultiplicationsItems.RESTONIA_BOOTS,
                ArmorSetEffectsConfig.RESTONIA_ENABLED,
                ArmorSetEffectsConfig.RESTONIA_AMPLIFIER,
                ArmorSetEffectsConfig.RESTONIA_EFFECT
        ),
        PALIS(
                ActuallyMultiplicationsItems.PALIS_HELMET,
                ActuallyMultiplicationsItems.PALIS_CHESTPLATE,
                ActuallyMultiplicationsItems.PALIS_LEGGINGS,
                ActuallyMultiplicationsItems.PALIS_BOOTS,
                ArmorSetEffectsConfig.PALIS_ENABLED,
                ArmorSetEffectsConfig.PALIS_AMPLIFIER,
                ArmorSetEffectsConfig.PALIS_EFFECT
        );

        private final DeferredItem<Item> helmet;
        private final DeferredItem<Item> chestplate;
        private final DeferredItem<Item> leggings;
        private final DeferredItem<Item> boots;
        private final ModConfigSpec.BooleanValue enabled;
        private final ModConfigSpec.IntValue amplifier;
        private final ModConfigSpec.ConfigValue<String> effectId;

        ConfiguredArmorSet(
                DeferredItem<Item> helmet,
                DeferredItem<Item> chestplate,
                DeferredItem<Item> leggings,
                DeferredItem<Item> boots,
                ModConfigSpec.BooleanValue enabled,
                ModConfigSpec.IntValue amplifier,
                ModConfigSpec.ConfigValue<String> effectId
        ) {
            this.helmet = helmet;
            this.chestplate = chestplate;
            this.leggings = leggings;
            this.boots = boots;
            this.enabled = enabled;
            this.amplifier = amplifier;
            this.effectId = effectId;
        }
    }

    private static Holder<MobEffect> resolveEffect(String id) {
        ResourceLocation rl = ResourceLocation.tryParse(id);
        if (rl == null) {
            if (LOGGED_UNKNOWN_EFFECTS.add(id)) {
                LOGGER.warn("[Actually Multiplications] Invalid mob effect id (not a valid resource location): {}", id);
            }
            return null;
        }
        var holder = BuiltInRegistries.MOB_EFFECT.getHolder(rl);
        if (holder.isEmpty()) {
            if (LOGGED_UNKNOWN_EFFECTS.add(id)) {
                LOGGER.warn("[Actually Multiplications] Unknown mob effect: {}", id);
            }
            return null;
        }
        return holder.get();
    }

    private static boolean fullSet(Player player, Item helmet, Item chestplate, Item leggings, Item boots) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(helmet)
                && player.getItemBySlot(EquipmentSlot.CHEST).is(chestplate)
                && player.getItemBySlot(EquipmentSlot.LEGS).is(leggings)
                && player.getItemBySlot(EquipmentSlot.FEET).is(boots);
    }
}
