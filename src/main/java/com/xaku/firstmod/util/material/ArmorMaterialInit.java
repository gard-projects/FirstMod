package com.xaku.firstmod.util.material;

import com.xaku.firstmod.Registration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    // Create new armor materials
    public static final ModArmorMaterial VOID = new ModArmorMaterial(
            new int[]{ 1000, 2000, 1600, 800 },
            new int[]{ 6, 16, 12, 6},
            30,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            () -> Ingredient.of(Registration.VOID_METAL::get),
            "void_metal",
            10,
            2
    );
}
