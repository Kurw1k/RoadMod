package com.Kurw1k.roadmod; // Проверь, чтобы пакет совпадал с твоим проектом

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Создаем реестр для предметов
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RoadMod.MODID);

    // Регистрируем мелок (Chalk)
    public static final RegistryObject<Item> CHALK = ITEMS.register("chalk",
            () -> new Item(new Item.Properties().stacksTo(1).durability(64)));
    // stacksTo(1) и durability(64) добавят ему полоску прочности, если хочешь

    // Этот метод вызывается в главном классе мода
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}