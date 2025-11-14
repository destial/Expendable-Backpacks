package com.shweit.expendablebackpacks;

import com.shweit.expendablebackpacks.commands.BackpackCommand;
import com.shweit.expendablebackpacks.items.BackpackItem;
import com.shweit.expendablebackpacks.listeners.BackpackCraftingListener;
import com.shweit.expendablebackpacks.listeners.BackpackInteractionListener;
import com.shweit.expendablebackpacks.listeners.BackpackProtectionListener;
import com.shweit.expendablebackpacks.listeners.BackpackSmithingListener;
import com.shweit.expendablebackpacks.recipes.BackpackRecipes;
import com.shweit.expendablebackpacks.storage.BackpackManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class for Expendable Backpacks.
 */
public class ExpendableBackpacks extends JavaPlugin {

    private BackpackManager backpackManager;
    private BackpackRecipes backpackRecipes;

    @Override
    public void onEnable() {
        getLogger().info("╔════════════════════════════════╗");
        getLogger().info("║  Expendable Backpacks v1.0.0   ║");
        getLogger().info("║   Starting initialization...   ║");
        getLogger().info("╚════════════════════════════════╝");

        // Initialize BackpackItem factory
        BackpackItem.initialize(this);
        getLogger().info("✓ Backpack item factory initialized");

        // Initialize BackpackManager (storage)
        backpackManager = new BackpackManager(this);
        backpackManager.loadAllBackpacks();
        getLogger().info("✓ Backpack storage loaded");

        // Register recipes
        backpackRecipes = new BackpackRecipes(this);
        backpackRecipes.registerAll();
        getLogger().info("✓ Crafting recipes registered");

        // Register listeners
        getServer().getPluginManager().registerEvents(
            new BackpackCraftingListener(backpackManager, this), this);
        getServer().getPluginManager().registerEvents(
            new BackpackSmithingListener(backpackManager), this);
        getServer().getPluginManager().registerEvents(
            new BackpackInteractionListener(backpackManager), this);
        getServer().getPluginManager().registerEvents(
            new BackpackProtectionListener(), this);
        getServer().getPluginManager().registerEvents(
            new com.shweit.expendablebackpacks.gui.BackpackGuideGUI(), this);
        getLogger().info("✓ Event listeners registered");

        // Register commands
        BackpackCommand backpackCommand = new BackpackCommand(backpackManager);
        getCommand("backpack").setExecutor(backpackCommand);
        getCommand("backpack").setTabCompleter(backpackCommand);
        getLogger().info("✓ Commands registered");

        getLogger().info("╔════════════════════════════════╗");
        getLogger().info("║ Expendable Backpacks enabled! ✓║");
        getLogger().info("║  8 Tiers • Stack Crafting      ║");
        getLogger().info("║  Enderpack Support • Commands  ║");
        getLogger().info("╚════════════════════════════════╝");
    }

    @Override
    public void onDisable() {
        getLogger().info("Saving all backpack inventories...");

        // Save all inventories
        if (backpackManager != null) {
            backpackManager.saveAllInventories();
        }

        getLogger().info("╔════════════════════════════════╗");
        getLogger().info("║ Expendable Backpacks disabled  ║");
        getLogger().info("║  All data saved successfully   ║");
        getLogger().info("╚════════════════════════════════╝");
    }

    /**
     * Get the BackpackManager instance.
     *
     * @return the backpack manager instance
     */
    @SuppressWarnings("EI_EXPOSE_REP")
    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}
