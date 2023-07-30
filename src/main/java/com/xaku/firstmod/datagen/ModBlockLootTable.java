package com.xaku.firstmod.datagen;


import com.xaku.firstmod.Registration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import java.util.Collections;


public class ModBlockLootTable extends BlockLootSubProvider {

    protected ModBlockLootTable() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        createSingleItemTable(Registration.VOID_METAL_BLOCK_ITEM.get());
    }
}
