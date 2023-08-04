package com.xaku.firstmod.datagen;


import com.xaku.firstmod.Registration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import java.util.Collections;


public class ModBlockLootTable extends BlockLootSubProvider {

    public ModBlockLootTable() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    /***
     dropSelf(Block block)
     -> invokes dropOther()

     dropOther(Block block, ItemLike item)
     -> this is where the magic happens
     -> in generation of loot tables you need to manually associate the ResourceLocation of the block's loot table with the actual LootTable.Builder object
     ***/

    // Function responsible for generating the loot table for the block
    @Override
    protected void generate() {
        dropSelf(Registration.VOID_METAL_BLOCK.get());
        dropSelf(Registration.MOURN_WOOD.get());
        dropSelf(Registration.STRIPPED_MOURN_WOOD.get());
        dropSelf(Registration.MOURN_LOG.get());
        dropSelf(Registration.STRIPPED_MOURN_LOG.get());
        dropSelf(Registration.MOURN_PLANKS.get());
        dropSelf(Registration.MOURN_DIRT.get());
        dropSelf(Registration.MOURN_LEAVES.get()); // Needs to be changed once I create a sapling block
    }

    // This function makes sure that every block (in our DeferredRegister object) has a loot table (see Registration class)
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().flatMap(RegistryObject::stream)::iterator;
    }
}
