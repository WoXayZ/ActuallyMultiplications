package com.actuallymultiplications;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ActuallyMultiplications.MOD_ID)
public final class ActuallyMultiplications {

    public static final String MOD_ID = "actuallymultiplications";

    public static ResourceLocation loc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public ActuallyMultiplications(IEventBus modEventBus, ModContainer container) {
        ModEtheticQuartzBlocks.BLOCKS.register(modEventBus);
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        container.registerConfig(ModConfig.Type.COMMON, ArmorSetEffectsConfig.SPEC, "actuallymultiplications-common.toml");

        NeoForge.EVENT_BUS.addListener(ArmorSetBonusHandler::onPlayerTick);
    }
}
