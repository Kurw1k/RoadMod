package com.Kurw1k.roadmod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RoadMod.MODID)
public class RoadMod {
    public static final String MODID = "roadmod";

    public RoadMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        com.Kurw1k.roadmod.ModItems.register(modEventBus);
        ModCreativeTab.register(modEventBus);
    }


}