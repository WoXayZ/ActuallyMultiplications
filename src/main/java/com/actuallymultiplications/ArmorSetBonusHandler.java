package com.actuallymultiplications;

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

        refresh(player, ModItems.DIAMATINE_HELMET.get(), ModItems.DIAMATINE_CHESTPLATE.get(),
                ModItems.DIAMATINE_LEGGINGS.get(), ModItems.DIAMATINE_BOOTS.get(),
                ArmorSetEffectsConfig.DIAMATINE_ENABLED, ArmorSetEffectsConfig.DIAMATINE_AMPLIFIER,
                ArmorSetEffectsConfig.DIAMATINE_EFFECT);

        refresh(player, ModItems.EMERADIC_HELMET.get(), ModItems.EMERADIC_CHESTPLATE.get(),
                ModItems.EMERADIC_LEGGINGS.get(), ModItems.EMERADIC_BOOTS.get(),
                ArmorSetEffectsConfig.EMERADIC_ENABLED, ArmorSetEffectsConfig.EMERADIC_AMPLIFIER,
                ArmorSetEffectsConfig.EMERADIC_EFFECT);

        refresh(player, ModItems.ENORI_HELMET.get(), ModItems.ENORI_CHESTPLATE.get(),
                ModItems.ENORI_LEGGINGS.get(), ModItems.ENORI_BOOTS.get(),
                ArmorSetEffectsConfig.ENORI_ENABLED, ArmorSetEffectsConfig.ENORI_AMPLIFIER,
                ArmorSetEffectsConfig.ENORI_EFFECT);

        refresh(player, ModItems.BLACK_QUARTZ_HELMET.get(), ModItems.BLACK_QUARTZ_CHESTPLATE.get(),
                ModItems.BLACK_QUARTZ_LEGGINGS.get(), ModItems.BLACK_QUARTZ_BOOTS.get(),
                ArmorSetEffectsConfig.BLACK_QUARTZ_ENABLED, ArmorSetEffectsConfig.BLACK_QUARTZ_AMPLIFIER,
                ArmorSetEffectsConfig.BLACK_QUARTZ_EFFECT);

        refresh(player, ModItems.VOID_HELMET.get(), ModItems.VOID_CHESTPLATE.get(),
                ModItems.VOID_LEGGINGS.get(), ModItems.VOID_BOOTS.get(),
                ArmorSetEffectsConfig.VOID_ENABLED, ArmorSetEffectsConfig.VOID_AMPLIFIER,
                ArmorSetEffectsConfig.VOID_EFFECT);

        refresh(player, ModItems.RESTONIA_HELMET.get(), ModItems.RESTONIA_CHESTPLATE.get(),
                ModItems.RESTONIA_LEGGINGS.get(), ModItems.RESTONIA_BOOTS.get(),
                ArmorSetEffectsConfig.RESTONIA_ENABLED, ArmorSetEffectsConfig.RESTONIA_AMPLIFIER,
                ArmorSetEffectsConfig.RESTONIA_EFFECT);

        refresh(player, ModItems.PALIS_HELMET.get(), ModItems.PALIS_CHESTPLATE.get(),
                ModItems.PALIS_LEGGINGS.get(), ModItems.PALIS_BOOTS.get(),
                ArmorSetEffectsConfig.PALIS_ENABLED, ArmorSetEffectsConfig.PALIS_AMPLIFIER,
                ArmorSetEffectsConfig.PALIS_EFFECT);
    }

    private static void refresh(
            Player player,
            Item helmet,
            Item chestplate,
            Item leggings,
            Item boots,
            ModConfigSpec.BooleanValue enabled,
            ModConfigSpec.IntValue amplifier,
            ModConfigSpec.ConfigValue<String> effectId
    ) {
        if (!enabled.get()) {
            return;
        }
        if (!fullSet(player, helmet, chestplate, leggings, boots)) {
            return;
        }
        Holder<MobEffect> effect = resolveEffect(effectId.get());
        if (effect == null) {
            return;
        }
        player.addEffect(new MobEffectInstance(effect, REFRESH_TICKS, amplifier.get(), false, false, true));
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
