package com.Kurw1k.roadmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadMod.MODID);

    // --- Обычные блоки ---
    public static final RegistryObject<Block> ASPHALT = registerBlock("asphalt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SIDEWALK = registerBlock("sidewalk",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    // --- Направленные блоки (Разметка) ---
    public static final RegistryObject<Block> DOUBLE_SOLID = registerMarking("doublesolidline");
    public static final RegistryObject<Block> LONG_DASHED = registerMarking("longdashedline");
    public static final RegistryObject<Block> SMALL_DASHED = registerMarking("smalldashedline");
    public static final RegistryObject<Block> SOLID = registerMarking("solidline");
    public static final RegistryObject<Block> STOPLINE_BOK = registerMarking("stoplinebok");
    public static final RegistryObject<Block> WHITECROSSING = registerMarking("whitecrossing");
    public static final RegistryObject<Block> YELLOWCROSSING = registerMarking("yellowcrossing");
    public static final RegistryObject<Block> SOLIDCORNER = registerMarking("solidcorner");
    public static final RegistryObject<Block> SOLIDTRIPLE = registerMarking("solidtriple");
    public static final RegistryObject<Block> SOLIDQUATRO = registerMarking("solidquatro");


    // --- Направленные блоки (Стрелки) ---
    public static final RegistryObject<Block> LEFT = registerMarking("left");
    public static final RegistryObject<Block> RIGHT = registerMarking("right");
    public static final RegistryObject<Block> REVERSAL = registerMarking("reversal");
    public static final RegistryObject<Block> RIGHT_LEFT = registerMarking("rightleft");
    public static final RegistryObject<Block> STOPLINE = registerMarking("stopline");
    public static final RegistryObject<Block> STRAIGHT = registerMarking("straight");
    public static final RegistryObject<Block> STRAIGHT_LEFT = registerMarking("straightleft");
    public static final RegistryObject<Block> STRAIGHT_LEFT_RIGHT = registerMarking("straightleftright");
    public static final RegistryObject<Block> STRAIGHT_REVERSAL = registerMarking("straightreversal");
    public static final RegistryObject<Block> STRAIGHT_RIGHT = registerMarking("straightright");

    // Метод для регистрации разметки
    private static RegistryObject<Block> registerMarking(String name) {
        return registerBlock(name, () -> new RoadMarkingBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    }

    // Универсальный метод: регистрирует блок И предмет для него
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}