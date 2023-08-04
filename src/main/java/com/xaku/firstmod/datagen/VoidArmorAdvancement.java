package com.xaku.firstmod.datagen;

import com.xaku.firstmod.Registration;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class VoidArmorAdvancement implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> writer, ExistingFileHelper existingFileHelper) {

        // Test group criteria under one criterion parent
        String[] criterionArmor = {"has_void_helmet", "has_void_chestplate", "has_void_leggings", "has_void_boots"};

        Advancement armorSetAdvancement = Advancement.Builder.advancement()
                .display(Registration.VOID_CHESTPLATE.get(),
                        Component.translatable(getAdvancementTranslation("armor", "obtain_void_armor", "title")), // Title for advancement
                        Component.translatable(getAdvancementTranslation("armor", "obtain_void_armor", "description")), // Description for advancement
                        new ResourceLocation("firstmod", "textures/gui/advancements/backgrounds/void.png"), // Background image for advancement
                        FrameType.CHALLENGE, // Frame type for advancement
                        true, // Show toast when completed
                        true, // Announce to chat when completed
                        false // Hide advancement
                        )
                .addCriterion(criterionArmor[0], InventoryChangeTrigger.TriggerInstance
                        .hasItems(ItemPredicate.Builder.item().of(Registration.VOID_HELMET.get()).build()))
                .addCriterion(criterionArmor[1], InventoryChangeTrigger.TriggerInstance
                        .hasItems(ItemPredicate.Builder.item().of(Registration.VOID_CHESTPLATE.get()).build()))
                .addCriterion(criterionArmor[2], InventoryChangeTrigger.TriggerInstance
                        .hasItems(ItemPredicate.Builder.item().of(Registration.VOID_LEGGINGS.get()).build()))
                .addCriterion(criterionArmor[3], InventoryChangeTrigger.TriggerInstance
                        .hasItems(ItemPredicate.Builder.item().of(Registration.VOID_BOOTS.get()).build()))
                .rewards(new AdvancementRewards.Builder().addExperience(1000).addLootTable(getLootTable("obtain_void_armor")).build())
                .save(writer, createAdvancement("armor", "obtain_void_armor"), existingFileHelper);
    }

    public ResourceLocation getLootTable(String advancementName) {
        return new ResourceLocation("firstmod", "advancements/" + advancementName);
    }

    public ResourceLocation createAdvancement(String category, String name) {
        return new ResourceLocation("firstmod", category + "/" + name);
    }

    public String getAdvancementTranslation(String category, String advancementName, String advancementPart) {
        return "advancements.firstmod." + category + "." + advancementName + "." + advancementPart;
    }
}
