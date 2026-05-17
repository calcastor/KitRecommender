package me.pablete1234.kit.util.category;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import tc.oc.pgm.util.bukkit.Enchantments;

public enum Weapon implements EnchantmentCategory {
    SWORD(Category.findMaterials("_SWORD"),
            Enchantments.SHARPNESS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT),
    BOW(ImmutableSet.of(Material.BOW),
            Enchantments.POWER, Enchantments.PUNCH, Enchantments.FLAME, Enchantments.INFINITY);

    private final ImmutableSet<Material> materials;
    private final Enchantment[] enchants;

    Weapon(ImmutableSet<Material> materials, Enchantment... enchants) {
        this.materials = materials;
        this.enchants = enchants;
    }

    @Override
    public ImmutableSet<Material> getAll() {
        return materials;
    }

    @Override
    public Enchantment[] getEnchantments() {
        return enchants;
    }

}
