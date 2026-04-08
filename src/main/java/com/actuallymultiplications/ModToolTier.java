package com.actuallymultiplications;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/**
 * Stats d'outils alignées sur la logique des armures (réf. vanilla {@link net.minecraft.world.item.Tiers}).
 */
public enum ModToolTier implements Tier {

    /** = fer. */
    BLACK_QUARTZ(250, 6.0F, 2.0F, 14, BlockTags.INCORRECT_FOR_IRON_TOOL, "black_quartz_armor_repair_materials"),

    /** ~mailles / bas. */
    VOID(180, 5.0F, 1.0F, 12, BlockTags.INCORRECT_FOR_STONE_TOOL, "void_armor_repair_materials"),

    /** mailles + 0,5. */
    PALIS(230, 5.75F, 1.75F, 12, BlockTags.INCORRECT_FOR_IRON_TOOL, "palis_armor_repair_materials"),

    RESTONIA(230, 5.75F, 1.75F, 12, BlockTags.INCORRECT_FOR_IRON_TOOL, "restonia_armor_repair_materials"),

    /** fer + 1 (bonus dégâts matériau). */
    ENORI(300, 6.5F, 3.0F, 15, BlockTags.INCORRECT_FOR_IRON_TOOL, "enori_armor_repair_materials"),

    /** diamant + 1. */
    DIAMATINE(1650, 8.5F, 4.0F, 10, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "diamatine_armor_repair_materials"),

    /** diamantine + 0,5 (arrondi). */
    EMERADIC(1850, 9.0F, 5.0F, 12, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "emeradic_armor_repair_materials");

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final TagKey<Item> repairTag;

    ModToolTier(
            int uses,
            float speed,
            float attackDamageBonus,
            int enchantmentValue,
            TagKey<Block> incorrectBlocksForDrops,
            String repairTagPath
    ) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairTag = TagKey.create(Registries.ITEM, ActuallyMultiplications.loc(repairTagPath));
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(repairTag);
    }

    /**
     * Dégâts d'attaque cibles pour l'OTEU (réf. pierre 6, fer 7, diamant 8), alignés sur la progression des armures.
     */
    public float getAiotTargetAttackDamage() {
        return switch (this) {
            case VOID -> 6.0F;
            case PALIS, RESTONIA -> 6.5F;
            case BLACK_QUARTZ -> 7.0F;
            case ENORI -> 8.0F;
            case DIAMATINE -> 9.0F;
            case EMERADIC -> 9.5F;
        };
    }

    /**
     * Second argument de {@link net.minecraft.world.item.PickaxeItem#createAttributes(Tier, float, float)} :
     * complément pour atteindre {@link #getAiotTargetAttackDamage()}.
     */
    public float getAiotAttackDamageAdd() {
        return getAiotTargetAttackDamage() - getAttackDamageBonus();
    }
}
