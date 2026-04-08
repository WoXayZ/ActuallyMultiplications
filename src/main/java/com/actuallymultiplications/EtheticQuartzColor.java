package com.actuallymultiplications;

import net.minecraft.world.level.material.MapColor;

public enum EtheticQuartzColor {
    RED("red", MapColor.COLOR_RED),
    ORANGE("orange", MapColor.COLOR_ORANGE),
    MAGENTA("magenta", MapColor.COLOR_MAGENTA),
    LIGHT_BLUE("light_blue", MapColor.COLOR_LIGHT_BLUE),
    YELLOW("yellow", MapColor.COLOR_YELLOW),
    LIME("lime", MapColor.COLOR_LIGHT_GREEN),
    PINK("pink", MapColor.COLOR_PINK),
    GRAY("gray", MapColor.COLOR_GRAY),
    CYAN("cyan", MapColor.COLOR_CYAN),
    PURPLE("purple", MapColor.COLOR_PURPLE),
    BLUE("blue", MapColor.COLOR_BLUE),
    LIGHT_GRAY("light_gray", MapColor.COLOR_LIGHT_GRAY),
    BROWN("brown", MapColor.COLOR_BROWN);

    private final String id;
    private final MapColor mapColor;

    EtheticQuartzColor(String id, MapColor mapColor) {
        this.id = id;
        this.mapColor = mapColor;
    }

    public String id() {
        return id;
    }

    public MapColor mapColor() {
        return mapColor;
    }

    /** Block id stem for smooth block and variant prefixes: {@code ethetic_<id>_quartz}. */
    public String stem() {
        return "ethetic_" + id + "_quartz";
    }

    public String chiseledBlockId() {
        return "chiseled_ethetic_" + id + "_quartz";
    }
}
