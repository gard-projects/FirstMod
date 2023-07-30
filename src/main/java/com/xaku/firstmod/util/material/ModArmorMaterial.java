package com.xaku.firstmod.util.material;

import com.xaku.firstmod.FirstMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

// Class for creating new armor material
public class ModArmorMaterial implements ArmorMaterial {

    private final int[] durabilityForType;
    private final int[] defenseForType;
    private int enchantmentValue;
    private SoundEvent equipSound;
    private Supplier<Ingredient> repairIngredient;
    private String name;
    private float toughness;
    private float knockbackResistance;

    public ModArmorMaterial(int[] durabilityForType, int[] defenseForType, int enchantmentValue, SoundEvent sound, Supplier<Ingredient> repair, String name, float toughness, float knockbackResistance) {
        this.durabilityForType = durabilityForType;
        this.defenseForType = defenseForType;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = sound;
        this.repairIngredient = repair;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return this.durabilityForType[type.ordinal()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.defenseForType[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return FirstMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
