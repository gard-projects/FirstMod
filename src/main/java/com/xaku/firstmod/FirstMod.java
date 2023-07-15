package com.xaku.firstmod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FirstMod.MODID)
public class FirstMod {
    public static final String MODID = "firstmod";

    public FirstMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.init(modEventBus);

    }
}
