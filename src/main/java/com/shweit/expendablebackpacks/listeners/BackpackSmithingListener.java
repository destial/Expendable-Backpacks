package com.shweit.expendablebackpacks.listeners;

import com.shweit.expendablebackpacks.items.BackpackItem;
import com.shweit.expendablebackpacks.items.BackpackTier;
import com.shweit.expendablebackpacks.storage.BackpackManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;

/**
 * Handles Netherite backpack upgrades via Smithing Table.
 * Recipe: Diamond Backpack + Netherite Upgrade Template + Netherite Ingot.
 */
public class BackpackSmithingListener implements Listener {

    private final BackpackManager backpackManager;

    /**
     * Creates a new backpack smithing listener.
     *
     * @param backpackManager the backpack manager instance
     */
    @SuppressWarnings("EI_EXPOSE_REP2")
    public BackpackSmithingListener(BackpackManager backpackManager) {
        this.backpackManager = backpackManager;
    }

    /**
     * Handles the smithing preparation event for backpack upgrades.
     *
     * @param event the prepare smithing event
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onPrepareSmithing(PrepareSmithingEvent event) {
        SmithingInventory inv = event.getInventory();

        // Get items from smithing slots
        ItemStack template = inv.getItem(0);  // Template slot
        ItemStack base = inv.getItem(1);      // Base item slot

        // Check if we're upgrading a backpack
        if (!BackpackItem.isBackpack(base)) {
            return;
        }

        BackpackTier currentTier = BackpackItem.getBackpackTier(base);
        if (currentTier == null || currentTier != BackpackTier.DIAMOND) {
            return; // Only Diamond backpacks can be upgraded to Netherite
        }

        // Check for correct template and addition
        if (template == null
            || template.getType() != Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE) {
            return;
        }

        final ItemStack addition = inv.getItem(2);  // Addition slot
        if (addition == null || addition.getType() != Material.NETHERITE_INGOT) {
            return;
        }

        // Create Netherite upgrade (preserves UUID and inventory)
        ItemStack upgraded = BackpackItem.upgradeBackpack(base, BackpackTier.NETHERITE);
        event.setResult(upgraded);
    }
}
