package com.xaku.firstmod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MODID);

    public static final RegistryObject<Item> VOID_METAL = ITEMS.register("void_metal", () -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC)
            .stacksTo(128)
            .fireResistant()
    ));
    public static final RegistryObject<Item> VOID_FRUIT = ITEMS.register("void_fruit", () -> new Item(new Item.Properties()
            .rarity(Rarity.UNCOMMON)
            .stacksTo(64)
            .fireResistant()
            .food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(1f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 5), 1)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3000, 5), 1)
                    .alwaysEat()
                    .meat()
                    .build())
            ));


    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
