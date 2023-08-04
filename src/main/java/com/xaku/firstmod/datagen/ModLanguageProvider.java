package com.xaku.firstmod.datagen;

import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, FirstMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        addBlock(Registration.VOID_METAL_BLOCK, "Void Metal Block");
        addBlock(Registration.MOURN_WOOD, "Mourn Wood");
        addBlock(Registration.STRIPPED_MOURN_WOOD, "Stripped Mourn Wood");
        addBlock(Registration.MOURN_LOG, "Mourn Log");
        addBlock(Registration.STRIPPED_MOURN_LOG, "Stripped Mourn Log");
        addBlock(Registration.MOURN_PLANKS, "Mourn Planks");
        addBlock(Registration.MOURN_LEAVES, "Mourn Leaves");
        addBlock(Registration.MOURN_DIRT, "Mourn Dirt");

        // Items
        addItem(Registration.VOID_METAL, "Void Metal");
        addItem(Registration.VOID_FRUIT, "Void Fruit");
        addItem(Registration.VOID_HELMET, "Void Helmet");
        addItem(Registration.VOID_CHESTPLATE, "Void Chestplate");
        addItem(Registration.VOID_LEGGINGS, "Void Leggings");
        addItem(Registration.VOID_BOOTS, "Void Boots");
        addItem(Registration.VOID_PICKAXE, "Void Pickaxe");
        addItem(Registration.VOID_SWORD, "Void Sword");
        addItem(Registration.VOID_SHOVEL, "Void Shovel");
        addItem(Registration.VOID_AXE, "Void Axe");
        addItem(Registration.VOID_HOE, "Void Hoe");

        // Miscs
        add("itemGroup.mod_tab", "First Mod");

        // Advancements
        addAdvancement("armor", "obtain_void_armor", "Reaching the Abyss", "Obtain a full set of Void Armor.");

    }

    public void addAdvancement(String category, String advancementName, String title, String description) {
        add("advancements." + FirstMod.MODID + "." + category + "." + advancementName + ".title", title);
        add("advancements." + FirstMod.MODID + "." + category + "." + advancementName + ".description", description);
    }
}
