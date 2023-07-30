package com.xaku.firstmod.util.tiers;


import com.xaku.firstmod.Registration;
import com.xaku.firstmod.util.TagInit;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTier  {
    public static final ForgeTier VOID_TIER = new ForgeTier(
            5,
            3000,
            16.0F,
            8.0F,
            30,
            TagInit.NEEDS_VOID_TOOL,
            () -> Ingredient.of(Registration.VOID_METAL::get)
    );
}
