package com.actuallymultiplications.registry;

import com.actuallymultiplications.ActuallyMultiplications;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public final class ActuallyMultiplicationsCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ActuallyMultiplications.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.actuallymultiplications"))
                    .icon(() -> new ItemStack(ActuallyMultiplicationsItems.RESTONIA_CHESTPLATE.get()))
                    .displayItems((params, output) -> {
                        for (CrystalMaterialTier tier : CrystalMaterialTier.values()) {
                            tier.addTo(output);
                        }
                        for (var blockItem : ActuallyMultiplicationsBlocks.allBlockItemsView()) {
                            output.accept(blockItem.get());
                        }
                    })
                    .build());

    private enum CrystalMaterialTier {
        RESTONIA(
                ActuallyMultiplicationsItems.RESTONIA_HELMET,
                ActuallyMultiplicationsItems.RESTONIA_CHESTPLATE,
                ActuallyMultiplicationsItems.RESTONIA_LEGGINGS,
                ActuallyMultiplicationsItems.RESTONIA_BOOTS,
                ActuallyMultiplicationsToolItems.RESTONIA_SHOVEL,
                ActuallyMultiplicationsToolItems.RESTONIA_PICKAXE,
                ActuallyMultiplicationsToolItems.RESTONIA_AXE,
                ActuallyMultiplicationsToolItems.RESTONIA_HOE,
                ActuallyMultiplicationsToolItems.RESTONIA_SWORD,
                ActuallyMultiplicationsToolItems.RESTONIA_AIOT
        ),
        PALIS(
                ActuallyMultiplicationsItems.PALIS_HELMET,
                ActuallyMultiplicationsItems.PALIS_CHESTPLATE,
                ActuallyMultiplicationsItems.PALIS_LEGGINGS,
                ActuallyMultiplicationsItems.PALIS_BOOTS,
                ActuallyMultiplicationsToolItems.PALIS_SHOVEL,
                ActuallyMultiplicationsToolItems.PALIS_PICKAXE,
                ActuallyMultiplicationsToolItems.PALIS_AXE,
                ActuallyMultiplicationsToolItems.PALIS_HOE,
                ActuallyMultiplicationsToolItems.PALIS_SWORD,
                ActuallyMultiplicationsToolItems.PALIS_AIOT
        ),
        DIAMATINE(
                ActuallyMultiplicationsItems.DIAMATINE_HELMET,
                ActuallyMultiplicationsItems.DIAMATINE_CHESTPLATE,
                ActuallyMultiplicationsItems.DIAMATINE_LEGGINGS,
                ActuallyMultiplicationsItems.DIAMATINE_BOOTS,
                ActuallyMultiplicationsToolItems.DIAMATINE_SHOVEL,
                ActuallyMultiplicationsToolItems.DIAMATINE_PICKAXE,
                ActuallyMultiplicationsToolItems.DIAMATINE_AXE,
                ActuallyMultiplicationsToolItems.DIAMATINE_HOE,
                ActuallyMultiplicationsToolItems.DIAMATINE_SWORD,
                ActuallyMultiplicationsToolItems.DIAMATINE_AIOT
        ),
        VOID(
                ActuallyMultiplicationsItems.VOID_HELMET,
                ActuallyMultiplicationsItems.VOID_CHESTPLATE,
                ActuallyMultiplicationsItems.VOID_LEGGINGS,
                ActuallyMultiplicationsItems.VOID_BOOTS,
                ActuallyMultiplicationsToolItems.VOID_SHOVEL,
                ActuallyMultiplicationsToolItems.VOID_PICKAXE,
                ActuallyMultiplicationsToolItems.VOID_AXE,
                ActuallyMultiplicationsToolItems.VOID_HOE,
                ActuallyMultiplicationsToolItems.VOID_SWORD,
                ActuallyMultiplicationsToolItems.VOID_AIOT
        ),
        EMERADIC(
                ActuallyMultiplicationsItems.EMERADIC_HELMET,
                ActuallyMultiplicationsItems.EMERADIC_CHESTPLATE,
                ActuallyMultiplicationsItems.EMERADIC_LEGGINGS,
                ActuallyMultiplicationsItems.EMERADIC_BOOTS,
                ActuallyMultiplicationsToolItems.EMERADIC_SHOVEL,
                ActuallyMultiplicationsToolItems.EMERADIC_PICKAXE,
                ActuallyMultiplicationsToolItems.EMERADIC_AXE,
                ActuallyMultiplicationsToolItems.EMERADIC_HOE,
                ActuallyMultiplicationsToolItems.EMERADIC_SWORD,
                ActuallyMultiplicationsToolItems.EMERADIC_AIOT
        ),
        ENORI(
                ActuallyMultiplicationsItems.ENORI_HELMET,
                ActuallyMultiplicationsItems.ENORI_CHESTPLATE,
                ActuallyMultiplicationsItems.ENORI_LEGGINGS,
                ActuallyMultiplicationsItems.ENORI_BOOTS,
                ActuallyMultiplicationsToolItems.ENORI_SHOVEL,
                ActuallyMultiplicationsToolItems.ENORI_PICKAXE,
                ActuallyMultiplicationsToolItems.ENORI_AXE,
                ActuallyMultiplicationsToolItems.ENORI_HOE,
                ActuallyMultiplicationsToolItems.ENORI_SWORD,
                ActuallyMultiplicationsToolItems.ENORI_AIOT
        ),
        BLACK_QUARTZ(
                ActuallyMultiplicationsItems.BLACK_QUARTZ_HELMET,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_CHESTPLATE,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_LEGGINGS,
                ActuallyMultiplicationsItems.BLACK_QUARTZ_BOOTS,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_SHOVEL,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_PICKAXE,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_AXE,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_HOE,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_SWORD,
                ActuallyMultiplicationsToolItems.BLACK_QUARTZ_AIOT
        );

        private final List<DeferredItem<Item>> items;

        @SafeVarargs
        CrystalMaterialTier(DeferredItem<Item>... items) {
            this.items = List.of(items);
        }

        void addTo(CreativeModeTab.Output output) {
            for (DeferredItem<Item> item : items) {
                output.accept(item.get());
            }
        }
    }

    private ActuallyMultiplicationsCreativeTabs() {
    }
}
