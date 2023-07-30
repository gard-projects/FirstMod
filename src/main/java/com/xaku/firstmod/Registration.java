package com.xaku.firstmod;

import com.xaku.firstmod.util.material.ArmorMaterialInit;
import com.xaku.firstmod.util.tiers.ModToolTier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Registration {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MODID);

    // List for storing any type of object
    public static final List<Supplier<? extends ItemLike>> MOD_TAB_ITEMS = new ArrayList<>();


    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("mod_tab",
            () -> CreativeModeTab.builder()
                    .icon(Registration.VOID_METAL.get()::getDefaultInstance)
                    .title(Component.translatable("itemGroup.mod_tab"))
                    .withSearchBar()
                    .withLabelColor(11141120)
                    .withSlotColor(5636095)
                    .displayItems((displayParameters, output) -> {
                        MOD_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
                    })
                    .build()
    );
    public static final RegistryObject<Item> VOID_METAL = addToCreativeTab(ITEMS.register("void_metal", () -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC)
            .stacksTo(128)
            .fireResistant()
    )));
    public static final RegistryObject<Item> VOID_FRUIT = addToCreativeTab(ITEMS.register("void_fruit", () -> new Item(new Item.Properties()
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
            )));

    public static final RegistryObject<Block> VOID_METAL_BLOCK = BLOCKS.register("void_metal_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(5.0F, 5.0F)
            .sound(SoundType.METAL)
            .requiresCorrectToolForDrops()
            .lightLevel(state -> 5)
    ));
    public static final RegistryObject<Block> MOURN_WOOD = BLOCKS.register("mourn_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MOURN_WOOD = BLOCKS.register("stripped_mourn_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MOURN_LOG = BLOCKS.register("mourn_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MOURN_LOG = BLOCKS.register("stripped_mourn_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> MOURN_PLANKS = BLOCKS.register("mourn_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MOURN_DIRT = BLOCKS.register("mourn_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> MOURN_LEAVES = BLOCKS.register("mourn_leaves",() -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<BlockItem> VOID_METAL_BLOCK_ITEM = addToCreativeTab(ITEMS.register("void_metal_block", () -> new BlockItem(VOID_METAL_BLOCK.get(),
                new Item.Properties().rarity(Rarity.EPIC).stacksTo(64).fireResistant()
            )));
    public static final RegistryObject<BlockItem> MOURN_WOOD_ITEM = addToCreativeTab(ITEMS.register("mourn_wood", () -> new BlockItem(MOURN_WOOD.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> STRIPPED_MOURN_WOOD_ITEM = addToCreativeTab(ITEMS.register("stripped_mourn_wood", () -> new BlockItem(STRIPPED_MOURN_WOOD.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> MOURN_LOG_ITEM = addToCreativeTab(ITEMS.register("mourn_log", () -> new BlockItem(MOURN_LOG.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> STRIPPED_MOURN_LOG_ITEM = addToCreativeTab(ITEMS.register("stripped_mourn_log", () -> new BlockItem(STRIPPED_MOURN_LOG.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> MOURN_PLANKS_ITEM = addToCreativeTab(ITEMS.register("mourn_planks", () -> new BlockItem(MOURN_PLANKS.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> MOURN_DIRT_ITEM = addToCreativeTab(ITEMS.register("mourn_dirt", () -> new BlockItem(MOURN_DIRT.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));
    public static final RegistryObject<BlockItem> MOURN_LEAVES_ITEM = addToCreativeTab(ITEMS.register("mourn_leaves", () -> new BlockItem(MOURN_LEAVES.get(),
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(64)
    )));


    public static final RegistryObject<ArmorItem> VOID_HELMET = addToCreativeTab(ITEMS.register("void_metal_helmet",
            () -> new ArmorItem(ArmorMaterialInit.VOID, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.EPIC).fireResistant())));

    public static final RegistryObject<ArmorItem> VOID_CHESTPLATE = addToCreativeTab(ITEMS.register("void_metal_chestplate",
            () -> new ArmorItem(ArmorMaterialInit.VOID, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.EPIC).fireResistant())));

    public static final RegistryObject<ArmorItem> VOID_LEGGINGS = addToCreativeTab(ITEMS.register("void_metal_leggings",
            () -> new ArmorItem(ArmorMaterialInit.VOID, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.EPIC).fireResistant())));

    public static final RegistryObject<ArmorItem> VOID_BOOTS = addToCreativeTab(ITEMS.register("void_metal_boots",
            () -> new ArmorItem(ArmorMaterialInit.VOID, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.EPIC).fireResistant())));


    public static final RegistryObject<PickaxeItem> VOID_PICKAXE = addToCreativeTab(ITEMS.register("void_metal_pickaxe",
            () -> new PickaxeItem(ModToolTier.VOID_TIER, 2, -0.5F, new Item.Properties().fireResistant().rarity(Rarity.EPIC))));

    public static final RegistryObject<SwordItem> VOID_SWORD = addToCreativeTab(ITEMS.register("void_metal_sword",
            () -> new SwordItem(ModToolTier.VOID_TIER, 6, -0.5F, new Item.Properties().fireResistant().rarity(Rarity.EPIC))));

    public static final RegistryObject<ShovelItem> VOID_SHOVEL = addToCreativeTab(ITEMS.register("void_metal_shovel",
            () -> new ShovelItem(ModToolTier.VOID_TIER, 3, -0.5F, new Item.Properties().fireResistant().rarity(Rarity.EPIC))));

    public static final RegistryObject<AxeItem> VOID_AXE = addToCreativeTab(ITEMS.register("void_metal_axe",
            () -> new AxeItem(ModToolTier.VOID_TIER, 10, -0.5F, new Item.Properties().fireResistant().rarity(Rarity.EPIC))));

    public static final RegistryObject<HoeItem> VOID_HOE = addToCreativeTab(ITEMS.register("void_metal_hoe",
            () -> new HoeItem(ModToolTier.VOID_TIER, -2, 0, new Item.Properties().fireResistant().rarity(Rarity.EPIC))));



    // Registers def. objects to mod event bus
    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        TABS.register(modEventBus);
    }

    // Handles adding registry objects to mod tab list
    public static <T extends Item> RegistryObject<T> addToCreativeTab(RegistryObject<T> itemLike) {
        MOD_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
