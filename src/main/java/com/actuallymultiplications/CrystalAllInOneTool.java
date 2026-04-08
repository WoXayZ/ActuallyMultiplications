package com.actuallymultiplications;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

/**
 * OTEU / AIOT : pioche + pelle + hache + houe (minage) + interactions vanilla.
 * Le composant {@link DataComponents#TOOL} doit fusionner les règles des quatre tags
 * {@code mineable/*} : un seul tag datapack listant d'autres tags ne suffit pas pour la vitesse.
 */
public class CrystalAllInOneTool extends TieredItem {

    private static final List<ItemAbility> ACTIONS = List.of(
            ItemAbilities.AXE_DIG,
            ItemAbilities.HOE_DIG,
            ItemAbilities.PICKAXE_DIG,
            ItemAbilities.SHOVEL_DIG,
            ItemAbilities.HOE_TILL,
            ItemAbilities.SHOVEL_FLATTEN,
            ItemAbilities.AXE_STRIP
    );

    public CrystalAllInOneTool(ModToolTier tier, net.minecraft.world.item.Item.Properties properties) {
        super(
                tier,
                properties
                        .durability(tier.getUses() * 4)
                        .component(DataComponents.TOOL, createAiotTool(tier))
                        // Dégâts cibles pierre 6 / fer 7 / diamant 8 (paliers interpolés) ; ~2 attaques/s (-2.0)
                        .attributes(PickaxeItem.createAttributes(tier, tier.getAiotAttackDamageAdd(), -2.0F))
        );
    }

    private static Tool createAiotTool(ModToolTier tier) {
        Tool pick = tier.createToolProperties(BlockTags.MINEABLE_WITH_PICKAXE);
        Tool shovel = tier.createToolProperties(BlockTags.MINEABLE_WITH_SHOVEL);
        Tool axe = tier.createToolProperties(BlockTags.MINEABLE_WITH_AXE);
        Tool hoe = tier.createToolProperties(BlockTags.MINEABLE_WITH_HOE);
        List<Tool.Rule> rules = Stream.of(pick, shovel, axe, hoe)
                .flatMap(t -> t.rules().stream())
                .toList();
        return new Tool(rules, pick.defaultMiningSpeed(), pick.damagePerBlock());
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility toolAction) {
        if (ACTIONS.contains(toolAction)) {
            return true;
        }
        return super.canPerformAction(stack, toolAction);
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() == null) {
            return InteractionResult.FAIL;
        }
        if (context.getPlayer().isCrouching()) {
            return Items.IRON_SHOVEL.useOn(context);
        }
        InteractionResult axe = Items.IRON_AXE.useOn(context);
        if (axe == InteractionResult.SUCCESS) {
            return axe;
        }
        return Items.IRON_HOE.useOn(context);
    }
}
