package com.actuallymultiplications;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ArmorSetEffectsConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DIAMATINE_ENABLED;
    public static final ModConfigSpec.IntValue DIAMATINE_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> DIAMATINE_EFFECT;

    public static final ModConfigSpec.BooleanValue EMERADIC_ENABLED;
    public static final ModConfigSpec.IntValue EMERADIC_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> EMERADIC_EFFECT;

    public static final ModConfigSpec.BooleanValue ENORI_ENABLED;
    public static final ModConfigSpec.IntValue ENORI_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> ENORI_EFFECT;

    public static final ModConfigSpec.BooleanValue BLACK_QUARTZ_ENABLED;
    public static final ModConfigSpec.IntValue BLACK_QUARTZ_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> BLACK_QUARTZ_EFFECT;

    public static final ModConfigSpec.BooleanValue VOID_ENABLED;
    public static final ModConfigSpec.IntValue VOID_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> VOID_EFFECT;

    public static final ModConfigSpec.BooleanValue RESTONIA_ENABLED;
    public static final ModConfigSpec.IntValue RESTONIA_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> RESTONIA_EFFECT;

    public static final ModConfigSpec.BooleanValue PALIS_ENABLED;
    public static final ModConfigSpec.IntValue PALIS_AMPLIFIER;
    public static final ModConfigSpec.ConfigValue<String> PALIS_EFFECT;

    public static final ModConfigSpec SPEC;

    static {
        BUILDER.comment(
                "Full armor set bonus (4 matching pieces).",
                "amplifier: 0 = level I, 1 = level II, etc.",
                "effect: mob effect id, e.g. minecraft:regeneration"
        );

        BUILDER.push("diamatine");
        BUILDER.comment("Default: regeneration I");
        DIAMATINE_ENABLED = BUILDER.define("enabled", true);
        DIAMATINE_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        DIAMATINE_EFFECT = BUILDER.define("effect", "minecraft:regeneration");
        BUILDER.pop();

        BUILDER.push("emeradic");
        BUILDER.comment("Default: speed I");
        EMERADIC_ENABLED = BUILDER.define("enabled", true);
        EMERADIC_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        EMERADIC_EFFECT = BUILDER.define("effect", "minecraft:speed");
        BUILDER.pop();

        BUILDER.push("enori");
        BUILDER.comment("Default: jump boost I");
        ENORI_ENABLED = BUILDER.define("enabled", true);
        ENORI_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        ENORI_EFFECT = BUILDER.define("effect", "minecraft:jump_boost");
        BUILDER.pop();

        BUILDER.push("black_quartz");
        BUILDER.comment("Default: resistance I");
        BLACK_QUARTZ_ENABLED = BUILDER.define("enabled", true);
        BLACK_QUARTZ_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        BLACK_QUARTZ_EFFECT = BUILDER.define("effect", "minecraft:resistance");
        BUILDER.pop();

        BUILDER.push("void");
        BUILDER.comment("Default: night vision I");
        VOID_ENABLED = BUILDER.define("enabled", true);
        VOID_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        VOID_EFFECT = BUILDER.define("effect", "minecraft:night_vision");
        BUILDER.pop();

        BUILDER.push("restonia");
        BUILDER.comment("Default: haste I");
        RESTONIA_ENABLED = BUILDER.define("enabled", true);
        RESTONIA_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        RESTONIA_EFFECT = BUILDER.define("effect", "minecraft:haste");
        BUILDER.pop();

        BUILDER.push("palis");
        BUILDER.comment("Default: water breathing I");
        PALIS_ENABLED = BUILDER.define("enabled", true);
        PALIS_AMPLIFIER = BUILDER.defineInRange("amplifier", 0, 0, 255);
        PALIS_EFFECT = BUILDER.define("effect", "minecraft:water_breathing");
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    private ArmorSetEffectsConfig() {
    }
}
