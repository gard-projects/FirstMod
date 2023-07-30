package com.xaku.firstmod.datagen;

import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // simpleBlock - generates the block model and the blockstate for the block (these blocks have no properties, i.e. state)
        simpleBlock(Registration.VOID_METAL_BLOCK.get());
        simpleBlock(Registration.MOURN_PLANKS.get());
        simpleBlock(Registration.MOURN_DIRT.get());
        leafBlock(Registration.MOURN_LEAVES.get(), modLoc("block/mourn_leaves"));



        // Generation of directional blocks (example wood log)
        axisBlock((RotatedPillarBlock) Registration.MOURN_LOG.get(), modLoc("block/mourn_log"), modLoc("block/mourn_log_top"));
        axisBlock((RotatedPillarBlock) Registration.STRIPPED_MOURN_LOG.get(), modLoc("block/stripped_mourn_log"), modLoc("block/stripped_mourn_log_top"));
        woodBlock((RotatedPillarBlock) Registration.MOURN_WOOD.get(), modLoc("block/mourn_log"));
        woodBlock((RotatedPillarBlock) Registration.STRIPPED_MOURN_WOOD.get(), modLoc("block/stripped_mourn_log"));
    }




    /***
    Functions for generating block models and blockstates for blocks unique to the mod
     ***/

    private void leafBlock(Block block, ResourceLocation texture) {
        ResourceLocation resource = ForgeRegistries.BLOCKS.getKey(block);
        if(resource == null) throw new NullPointerException ("Leaf block: " + block + " has null registry name");
        ModelFile leafModel = models().getBuilder(resource.getPath())
                .parent(models().getExistingFile(mcLoc(ModelProvider.BLOCK_FOLDER + "/leaves")))
                .texture("all", texture);
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(leafModel));
    }

    private void woodBlock(RotatedPillarBlock block, ResourceLocation texture) {
        ResourceLocation resource = ForgeRegistries.BLOCKS.getKey(block);
        if(resource == null) throw new NullPointerException ("Wood block: " + block + " has null registry name");
        ModelFile woodModel = models().getBuilder(resource.getPath())
                .parent(models().getExistingFile(mcLoc(ModelProvider.BLOCK_FOLDER + "/cube_column")))
                .texture("end", texture)
                .texture("side", texture);
        axisBlock(block, woodModel, woodModel);
    }


}
