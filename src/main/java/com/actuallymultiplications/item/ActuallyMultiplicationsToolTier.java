package com.actuallymultiplications.item;

import com.actuallymultiplications.ActuallyMultiplications;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum ActuallyMultiplicationsToolTier implements Tier {

    BLACK_QUARTZ(250, 6.0F, 2.0F, 14, BlockTags.INCORRECT_FOR_IRON_TOOL, "black_quartz_armor_repair_materials"),
    VOID(180, 5.0F, 1.0F, 12, BlockTags.INCORRECT_FOR_STONE_TOOL, "void_armor_repair_materials"),
    PALIS(230, 5.75F, 1.75F, 12, BlockTags.INCORRECT_FOR_IRON_TOOL, "palis_armor_repair_materials"),
    RESTONIA(230, 5.75F, 1.75F, 12, BlockTags.INCORRECT_FOR_IRON_TOOL, "restonia_armor_repair_materials"),
    ENORI(300, 6.5F, 3.0F, 15, BlockTags.INCORRECT_FOR_IRON_TOOL, "enori_armor_repair_materials"),
    DIAMATINE(1650, 8.5F, 4.0F, 10, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "diamatine_armor_repair_materials"),
    EMERADIC(1850, 9.0F, 5.0F, 12, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "emeradic_armor_repair_materials");

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final TagKey<Item> repairTag;

    ActuallyMultiplicationsToolTier(
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

    public Item.Properties withPickaxe(Item.Properties p) {
        return p.attributes(PickaxeItem.createAttributes(this, PICKAXE_DAMAGE_EXTRA, PICKAXE_ATTACK_SPEED));
    }

    public Item.Properties withShovel(Item.Properties p) {
        return p.attributes(DiggerItem.createAttributes(this, SHOVEL_DAMAGE_EXTRA, SHOVEL_ATTACK_SPEED));
    }

    public Item.Properties withAxe(Item.Properties p) {
        return p.attributes(DiggerItem.createAttributes(this, AXE_DAMAGE_EXTRA, AXE_ATTACK_SPEED));
    }

    public Item.Properties withHoe(Item.Properties p) {
        return p.attributes(DiggerItem.createAttributes(this, HOE_DAMAGE_EXTRA, HOE_ATTACK_SPEED));
    }

    public Item.Properties withSword(Item.Properties p) {
        return p.attributes(SwordItem.createAttributes(this, SWORD_DAMAGE_EXTRA, SWORD_ATTACK_SPEED));
    }

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

    public float getAiotAttackDamageAdd() {
        return getAiotTargetAttackDamage() - getAttackDamageBonus();
    }

    private static final float PICKAXE_DAMAGE_EXTRA = 1.0F;
    private static final float PICKAXE_ATTACK_SPEED = -2.8F;
    private static final float SHOVEL_DAMAGE_EXTRA = 1.5F;
    private static final float SHOVEL_ATTACK_SPEED = -3.0F;
    private static final float AXE_DAMAGE_EXTRA = 5.0F;
    private static final float AXE_ATTACK_SPEED = -3.1F;
    private static final float HOE_DAMAGE_EXTRA = 0.0F;
    private static final float HOE_ATTACK_SPEED = -3.0F;
    private static final int SWORD_DAMAGE_EXTRA = 3;
    private static final float SWORD_ATTACK_SPEED = -2.4F;
}
