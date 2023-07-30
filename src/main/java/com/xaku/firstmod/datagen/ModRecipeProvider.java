package com.xaku.firstmod.datagen;

import com.xaku.firstmod.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Generation of shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.VOID_METAL_BLOCK.get())
                .define('#', Registration.VOID_METAL.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("firstmod")
                .unlockedBy("has_void_metal", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.VOID_METAL.get()).build()
                ))
                .save(consumer);

        planksFromLog(consumer, Registration.MOURN_PLANKS.get(), ItemTags.LOGS, 4);

        // Generation of shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.VOID_METAL.get(), 9)
                .requires(Registration.VOID_METAL_BLOCK.get())
                .group("firstmod")
                .unlockedBy("has_void_metal_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.VOID_METAL_BLOCK.get()).build()
                ))
                .save(consumer);
    }
}
