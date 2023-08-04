package com.xaku.firstmod.datagen;

import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
        stairsBlock(Registration.MOURN_STAIRS.get(), modLoc("block/mourn_planks"));
        doorBlock(Registration.MOURN_DOOR.get(), modLoc("block/mourn_door_bottom"), modLoc("block/mourn_door_top"));
        pressurePlateBlock(Registration.MOURN_PRESSURE_PLATE.get(), modLoc("block/mourn_planks"));
        trapdoorBlock(Registration.MOURN_TRAPDOOR.get(), modLoc("block/mourn_trapdoor"), true);
        buttonBlock(Registration.MOURN_BUTTON.get(), modLoc("block/mourn_planks"));
        slabBlock(Registration.MOURN_SLAB.get(), modLoc("block/mourn_planks"), modLoc("block/mourn_planks"));
        fenceGateBlock(Registration.MOURN_FENCE_GATE.get(), modLoc("block/mourn_planks"));
        fenceBlock(Registration.MOURN_FENCE.get(), modLoc("block/mourn_planks"));
        signBlock(Registration.MOURN_SIGN.get(), Registration.MOURN_WALL_SIGN.get(), modLoc("block/mourn_planks"));
        ladderBlock(Registration.MOURN_LADDER.get(), modLoc("block/mourn_ladder"));

        // Generation of custom block model
        models().fenceInventory("mourn_fence", modLoc("block/mourn_planks"));
        models().buttonInventory("mourn_button", modLoc("block/mourn_planks"));
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

    private void ladderBlock(LadderBlock block, ResourceLocation texture) {
        ResourceLocation resource = ForgeRegistries.BLOCKS.getKey(block);
        if(resource == null) throw new NullPointerException ("Ladder block: " + block + " has null registry name");
        ModelFile ladderModel = models().getBuilder(resource.getPath()).parent(models().getExistingFile(mcLoc(ModelProvider.BLOCK_FOLDER + "/ladder")))
                .texture("all", texture);
        getVariantBuilder(block).forAllStates(state -> {
            // Get the direction the block is placed
            Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);
            return ConfiguredModel.builder().modelFile(ladderModel).rotationY((int)facing.toYRot()).build();
        });
    }
}
