package com.shweit.expendablebackpacks.recipes;

import com.shweit.expendablebackpacks.items.BackpackItem;
import com.shweit.expendablebackpacks.items.BackpackTier;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

/**
 * Registers all backpack crafting recipes.
 */
public class BackpackRecipes {

    private final Plugin plugin;

    /**
     * Constructor for BackpackRecipes.
     *
     * @param plugin the plugin instance.
     */
    @SuppressWarnings("EI_EXPOSE_REP2")
    public BackpackRecipes(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Register all recipes.
     * Upgrade recipes use ExactChoice with dummy backpacks to show correct icons.
     */
    public void registerAll() {
        registerDirtBackpack();
        registerLeatherBackpack();
        registerCopperUpgrade();
        registerIronUpgrade();
        registerGoldUpgrade();
        registerDiamondUpgrade();
        registerEnderpack();
        registerEnderpackClone();
        registerNetheriteUpgrade();
    }

    /**
     * Leather Backpack recipe (base crafting).
     * L S L
     * L C L
     * L L L
     */
    private void registerLeatherBackpack() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.LEATHER);
        NamespacedKey key = new NamespacedKey(plugin, "leather_backpack");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("LSL", "LCL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('C', Material.CHEST);

        Bukkit.addRecipe(recipe);
    }

    /**
     * Dirt Backpack recipe (downgrade from Leather).
     * D D D
     * D B D
     * D D D
     */
    private void registerDirtBackpack() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.DIRT);
        NamespacedKey key = new NamespacedKey(plugin, "dirt_backpack");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("DDD", "DBD", "DDD");
        recipe.setIngredient('D', Material.DIRT);
        // Use ExactChoice with Leather Backpack to show correct icon in recipe book
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.LEATHER)));

        Bukkit.addRecipe(recipe);
    }

    /**
     * Enderpack recipe.
     * E P E
     * P C P
     * E I E
     */
    private void registerEnderpack() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.ENDERPACK);
        NamespacedKey key = new NamespacedKey(plugin, "enderpack");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("EPE", "PCP", "EIE");
        recipe.setIngredient('E', Material.ENDER_EYE);
        recipe.setIngredient('P', Material.ENDER_PEARL);
        recipe.setIngredient('C', Material.CHEST);
        recipe.setIngredient('I', Material.IRON_BLOCK);

        Bukkit.addRecipe(recipe);
    }

    /**
     * Enderpack cloning recipe (shapeless).
     * 1 Enderpack + Ender Pearls = Multiple Enderpacks with same ID
     * Note: Listener handles dynamic amounts based on pearl count.
     */
    private void registerEnderpackClone() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.ENDERPACK);
        result.setAmount(2); // Show 2 in recipe book (actual amount is dynamic)
        NamespacedKey key = new NamespacedKey(plugin, "enderpack_clone");

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);
        // Use ExactChoice to show correct Enderpack icon in recipe book
        recipe.addIngredient(new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.ENDERPACK)));
        recipe.addIngredient(Material.ENDER_PEARL);

        Bukkit.addRecipe(recipe);
    }

    /**
     * Copper Backpack upgrade.
     * C C C
     * C B C
     * C C C
     */
    private void registerCopperUpgrade() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.COPPER);
        NamespacedKey key = new NamespacedKey(plugin, "copper_upgrade");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("CCC", "CBC", "CCC");
        recipe.setIngredient('C', Material.COPPER_INGOT);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.LEATHER)));

        Bukkit.addRecipe(recipe);
    }

    /**
     * Iron Backpack upgrade.
     */
    private void registerIronUpgrade() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.IRON);
        NamespacedKey key = new NamespacedKey(plugin, "iron_upgrade");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("III", "IBI", "III");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.COPPER)));

        Bukkit.addRecipe(recipe);
    }

    /**
     * Gold Backpack upgrade.
     */
    private void registerGoldUpgrade() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.GOLD);
        NamespacedKey key = new NamespacedKey(plugin, "gold_upgrade");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("GGG", "GBG", "GGG");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.IRON)));

        Bukkit.addRecipe(recipe);
    }

    /**
     * Diamond Backpack upgrade.
     */
    private void registerDiamondUpgrade() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.DIAMOND);
        NamespacedKey key = new NamespacedKey(plugin, "diamond_upgrade");

        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("DDD", "DBD", "DDD");
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(
            BackpackItem.createBackpack(BackpackTier.GOLD)));

        Bukkit.addRecipe(recipe);
    }

    /**
     * Netherite Backpack upgrade via Smithing Table.
     * Diamond Backpack + Netherite Upgrade Template + Netherite Ingot.
     */
    private void registerNetheriteUpgrade() {
        ItemStack result = BackpackItem.createBackpack(BackpackTier.NETHERITE);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_upgrade");

        org.bukkit.inventory.SmithingTransformRecipe recipe =
            new org.bukkit.inventory.SmithingTransformRecipe(
                key,
                result,
                new RecipeChoice.MaterialChoice(
                    Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                new RecipeChoice.ExactChoice(
                    BackpackItem.createBackpack(BackpackTier.DIAMOND)),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)
            );

        Bukkit.addRecipe(recipe);
    }
}
