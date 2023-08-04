package com.xaku.firstmod.datagen;

import com.xaku.firstmod.Registration;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import java.util.function.BiConsumer;


public class ModAdvancementLootTable implements LootTableSubProvider {
    // Custom class for creating loot tables for advancements
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> writer) {
        // Create a loot table builder object first
        writer.accept(createTableLocation("obtain_void_armor"), createTable(1.0F, 4.0F,
                Registration.VOID_METAL.get(), Registration.VOID_FRUIT.get()));
    }



    // Create an entry (item) for the loot table
    public LootPoolEntryContainer.Builder<?> createEntry(ItemLike item, Float itemDrops) {
        return LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(itemDrops)));
    }

    // Associate a resource location with the loot table for a specific advancement
    public ResourceLocation createTableLocation(String advancementName) {
        return new ResourceLocation("firstmod", "advancements/" + advancementName);
    }

    // Creates a LootTable.Builder object with one pool for each entry item
    public LootTable.Builder createTable(Float numberOfRolls, Float itemDrops,  ItemLike ... entryItems) {
        LootTable.Builder lootTableBuilder = LootTable.lootTable();
        for(ItemLike item : entryItems) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(numberOfRolls))
                    .add(createEntry(item, itemDrops));
            lootTableBuilder.withPool(poolBuilder);
        }
        return lootTableBuilder;
    }
}
