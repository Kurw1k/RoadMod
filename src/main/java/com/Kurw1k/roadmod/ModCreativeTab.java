package com.Kurw1k.roadmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RoadMod.MODID);

    public static final RegistryObject<CreativeModeTab> ROAD_TAB = CREATIVE_MODE_TABS.register("road_tab",
            () -> CreativeModeTab.builder()
                    // Устанавливаем иконкой АСФАЛЬТ вместо мелка
                    .icon(() -> new ItemStack(ModBlocks.ASPHALT.get()))
                    .title(Component.translatable("creativetab.road_marking"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Обычные блоки
                        output.accept(ModBlocks.ASPHALT.get());
                        output.accept(ModBlocks.SIDEWALK.get());

                        // Линии
                        output.accept(ModBlocks.DOUBLE_SOLID.get());
                        output.accept(ModBlocks.LONG_DASHED.get());
                        output.accept(ModBlocks.SMALL_DASHED.get());
                        output.accept(ModBlocks.SOLID.get());
                        output.accept(ModBlocks.STOPLINE_BOK.get());
                        output.accept(ModBlocks.WHITECROSSING.get());
                        output.accept(ModBlocks.YELLOWCROSSING.get());
                        output.accept(ModBlocks.SOLIDCORNER.get());
                        output.accept(ModBlocks.SOLIDTRIPLE.get());
                        output.accept(ModBlocks.SOLIDQUATRO.get());


                        // Стрелки
                        output.accept(ModBlocks.LEFT.get());
                        output.accept(ModBlocks.RIGHT.get());
                        output.accept(ModBlocks.REVERSAL.get());
                        output.accept(ModBlocks.RIGHT_LEFT.get());
                        output.accept(ModBlocks.STOPLINE.get());
                        output.accept(ModBlocks.STRAIGHT.get());
                        output.accept(ModBlocks.STRAIGHT_LEFT.get());
                        output.accept(ModBlocks.STRAIGHT_LEFT_RIGHT.get());
                        output.accept(ModBlocks.STRAIGHT_REVERSAL.get());
                        output.accept(ModBlocks.STRAIGHT_RIGHT.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}