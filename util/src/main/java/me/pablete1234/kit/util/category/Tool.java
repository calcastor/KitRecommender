package me.pablete1234.kit.util.category;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import tc.oc.pgm.util.bukkit.Enchantments;

public enum Tool implements EnchantmentCategory {
    PICKAXE,
    AXE,
    SPADE,
    HOE,
    SHEARS(ImmutableSet.of(Material.SHEARS));

    private static final Enchantment[] ENCHANTS = {Enchantments.EFFICIENCY, Enchantments.SILK_TOUCH, Enchantments.UNBREAKING};
    private final ImmutableSet<Material> materials;

    Tool(ImmutableSet<Material> materials) {
        this.materials = materials;
    }

    Tool() {
        this.materials = Category.findMaterials("_" + name());
    }

    @Override
    public ImmutableSet<Material> getAll() {
        return materials;
    }

    @Override
    public Enchantment[] getEnchantments() {
        return ENCHANTS;
    }
}
