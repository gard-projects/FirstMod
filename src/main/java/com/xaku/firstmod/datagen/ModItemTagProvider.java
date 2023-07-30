package com.xaku.firstmod.datagen;

import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, blockTags.contentsGetter(), FirstMod.MODID, existingFileHelper);
    }

    public static final TagKey<Item> MOURN_LOGS = createTagKey("mourn_logs");
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Add common items under minecraft tags
        tag(ItemTags.PLANKS).add(Registration.MOURN_PLANKS_ITEM.get());
        tag(ItemTags.LOGS).add(Registration.MOURN_LOG_ITEM.get());
        tag(ItemTags.DIRT).add(Registration.MOURN_DIRT_ITEM.get());
        tag(ItemTags.LEAVES).add(Registration.MOURN_LEAVES_ITEM.get());

        // Creates the item tag for the block, by using the block tag (see ModBlockTagProvider)
        copy(ModBlockTagProvider.MOURN_LOGS, MOURN_LOGS);
    }

    public static TagKey<Item> createTagKey(String name) {
       return ItemTags.create(new ResourceLocation(FirstMod.MODID, name));
    }
}
