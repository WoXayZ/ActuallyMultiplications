package com.actuallymultiplications;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ActuallyMultiplications.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.actuallymultiplications"))
                    .icon(() -> new ItemStack(ModItems.RESTONIA_CHESTPLATE.get()))
                    .displayItems((params, output) -> {
                        addTier(output,
                                ModItems.RESTONIA_HELMET, ModItems.RESTONIA_CHESTPLATE, ModItems.RESTONIA_LEGGINGS, ModItems.RESTONIA_BOOTS,
                                ModToolItems.RESTONIA_SHOVEL, ModToolItems.RESTONIA_PICKAXE, ModToolItems.RESTONIA_AXE, ModToolItems.RESTONIA_HOE,
                                ModToolItems.RESTONIA_SWORD, ModToolItems.RESTONIA_AIOT);
                        addTier(output,
                                ModItems.PALIS_HELMET, ModItems.PALIS_CHESTPLATE, ModItems.PALIS_LEGGINGS, ModItems.PALIS_BOOTS,
                                ModToolItems.PALIS_SHOVEL, ModToolItems.PALIS_PICKAXE, ModToolItems.PALIS_AXE, ModToolItems.PALIS_HOE,
                                ModToolItems.PALIS_SWORD, ModToolItems.PALIS_AIOT);
                        addTier(output,
                                ModItems.DIAMATINE_HELMET, ModItems.DIAMATINE_CHESTPLATE, ModItems.DIAMATINE_LEGGINGS, ModItems.DIAMATINE_BOOTS,
                                ModToolItems.DIAMATINE_SHOVEL, ModToolItems.DIAMATINE_PICKAXE, ModToolItems.DIAMATINE_AXE, ModToolItems.DIAMATINE_HOE,
                                ModToolItems.DIAMATINE_SWORD, ModToolItems.DIAMATINE_AIOT);
                        addTier(output,
                                ModItems.VOID_HELMET, ModItems.VOID_CHESTPLATE, ModItems.VOID_LEGGINGS, ModItems.VOID_BOOTS,
                                ModToolItems.VOID_SHOVEL, ModToolItems.VOID_PICKAXE, ModToolItems.VOID_AXE, ModToolItems.VOID_HOE,
                                ModToolItems.VOID_SWORD, ModToolItems.VOID_AIOT);
                        addTier(output,
                                ModItems.EMERADIC_HELMET, ModItems.EMERADIC_CHESTPLATE, ModItems.EMERADIC_LEGGINGS, ModItems.EMERADIC_BOOTS,
                                ModToolItems.EMERADIC_SHOVEL, ModToolItems.EMERADIC_PICKAXE, ModToolItems.EMERADIC_AXE, ModToolItems.EMERADIC_HOE,
                                ModToolItems.EMERADIC_SWORD, ModToolItems.EMERADIC_AIOT);
                        addTier(output,
                                ModItems.ENORI_HELMET, ModItems.ENORI_CHESTPLATE, ModItems.ENORI_LEGGINGS, ModItems.ENORI_BOOTS,
                                ModToolItems.ENORI_SHOVEL, ModToolItems.ENORI_PICKAXE, ModToolItems.ENORI_AXE, ModToolItems.ENORI_HOE,
                                ModToolItems.ENORI_SWORD, ModToolItems.ENORI_AIOT);
                        addTier(output,
                                ModItems.BLACK_QUARTZ_HELMET, ModItems.BLACK_QUARTZ_CHESTPLATE, ModItems.BLACK_QUARTZ_LEGGINGS, ModItems.BLACK_QUARTZ_BOOTS,
                                ModToolItems.BLACK_QUARTZ_SHOVEL, ModToolItems.BLACK_QUARTZ_PICKAXE, ModToolItems.BLACK_QUARTZ_AXE, ModToolItems.BLACK_QUARTZ_HOE,
                                ModToolItems.BLACK_QUARTZ_SWORD, ModToolItems.BLACK_QUARTZ_AIOT);
                    })
                    .build());

    @SafeVarargs
    private static void addTier(CreativeModeTab.Output output, DeferredItem<?>... items) {
        for (DeferredItem<?> item : items) {
            output.accept(item.get());
        }
    }

    private ModCreativeTabs() {
    }
}
