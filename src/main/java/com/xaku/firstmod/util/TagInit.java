package com.xaku.firstmod.util;

import com.xaku.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;


// Initialization of tags
public class TagInit {
    public static final TagKey<Block> NEEDS_VOID_TOOL =  tag("needs_void_tool");
    private static TagKey<Block> tag(String name) { return BlockTags.create(new ResourceLocation(FirstMod.MODID, name)); }
}
