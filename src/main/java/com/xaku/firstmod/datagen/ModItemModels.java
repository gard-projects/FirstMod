package com.xaku.firstmod.datagen;


import com.xaku.firstmod.FirstMod;
import com.xaku.firstmod.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;


/*
 * This class is used to generate the item models for the mod.
 * It is called by the data generator (see DataGeneration).
 */


public class ModItemModels extends ItemModelProvider {
    public ModItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Items - parent of generated type
        basicItem(Registration.VOID_METAL.get());
        basicItem(Registration.VOID_FRUIT.get());

       // ArmorItems - parent of generated type
        basicItem(Registration.VOID_HELMET.get());
        basicItem(Registration.VOID_CHESTPLATE.get());
        basicItem(Registration.VOID_LEGGINGS.get());
        basicItem(Registration.VOID_BOOTS.get());

        // ItemTools - parent of handheld type
        handheldItem(Registration.VOID_SWORD.get());
        handheldItem(Registration.VOID_PICKAXE.get());
        handheldItem(Registration.VOID_AXE.get());
        handheldItem(Registration.VOID_SHOVEL.get());
        handheldItem(Registration.VOID_HOE.get());

        // Creating an item model for a block, by using existing block's block model
        withExistingParent("void_metal_block",modLoc("block/void_metal_block"));
        withExistingParent("mourn_planks", modLoc("block/mourn_planks"));
        withExistingParent("mourn_leaves", modLoc("block/mourn_leaves"));
        withExistingParent("mourn_dirt", modLoc("block/mourn_dirt"));
        withExistingParent("mourn_log", modLoc("block/mourn_log"));
        withExistingParent("mourn_wood", modLoc("block/mourn_wood"));
        withExistingParent("stripped_mourn_wood", modLoc("block/stripped_mourn_wood"));
        withExistingParent("stripped_mourn_log", modLoc("block/stripped_mourn_log"));

        withExistingParent("mourn_stairs", modLoc("block/mourn_stairs"));
        withExistingParent("mourn_slab", modLoc("block/mourn_slab"));
        withExistingParent("mourn_fence_gate", modLoc("block/mourn_fence_gate"));
        withExistingParent("mourn_trapdoor", modLoc("block/mourn_trapdoor_bottom"));
        withExistingParent("mourn_pressure_plate", modLoc("block/mourn_pressure_plate"));
        withExistingParent("mourn_button", modLoc("block/mourn_button_inventory"));
        withExistingParent("mourn_ladder", modLoc("block/mourn_ladder"));
        withExistingParent("mourn_trapdoor", modLoc("block/mourn_trapdoor_bottom"));
        withExistingParent("mourn_fence", modLoc("block/mourn_fence_inventory"));
        withExistingParent("mourn_hanging_sign", modLoc("block/mourn_hanging_sign"));

        // Blocks of generated type, but with a specific texture for layer0
//        itemModelBlock(Registration.MOURN_SIGN.get());
//        itemModelBlock(Registration.MOURN_HANGING_SIGN.get());
//        itemModelBlock(Registration.MOURN_DOOR.get());
        basicItem(modLoc("block/mourn_sign"));
        basicItem(modLoc("block/mourn_hanging_sign"));
        basicItem(modLoc("block/mourn_door"));
    }



    // ModelBuilder for handheld items (Tools, Weapons, etc.)
    public <T extends TieredItem> ItemModelBuilder handheldItem(T item) {
        // Get the resource location for the item
        ResourceLocation resource = ForgeRegistries.ITEMS.getKey(item);
        // Error handling
        if(resource == null) throw new NullPointerException("Item " + item + " cannot be found in project.");
        // Create and return the model item builder
        return getBuilder(resource.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(resource.getNamespace(), "item/" + resource.getPath()));
    }

    public ItemModelBuilder itemModelBlock(Block item) {
        ResourceLocation resource = ForgeRegistries.ITEMS.getKey(item.asItem());
        if(resource == null) throw new NullPointerException("Block item " + item + " cannot be found in project.");
        return getBuilder(resource.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", resource.getPath());
    }
}
