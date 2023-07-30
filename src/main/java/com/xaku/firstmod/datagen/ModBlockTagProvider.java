package com.xaku.firstmod.datagen;

import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Tag for blocks that can be mined with a pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.VOID_METAL_BLOCK.get());

        // Add common blocks under minecraft tags
        tag(BlockTags.PLANKS).add(Registration.MOURN_PLANKS.get());
        tag(BlockTags.LOGS).add(Registration.MOURN_LOG.get());

        // Tag for blocks that can be mined with a stone pickaxe or better
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(Registration.VOID_METAL_BLOCK.get());
    }
}
