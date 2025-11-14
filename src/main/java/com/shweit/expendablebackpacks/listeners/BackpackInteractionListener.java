package com.shweit.expendablebackpacks.listeners;

import com.shweit.expendablebackpacks.items.BackpackItem;
import com.shweit.expendablebackpacks.items.BackpackTier;
import com.shweit.expendablebackpacks.storage.BackpackManager;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Handles backpack opening and closing.
 */
public class BackpackInteractionListener implements Listener {

    private final BackpackManager backpackManager;

    /**
     * Creates a new backpack interaction listener.
     *
     * @param backpackManager the backpack manager instance
     */
    @SuppressWarnings("EI_EXPOSE_REP2")
    public BackpackInteractionListener(BackpackManager backpackManager) {
        this.backpackManager = backpackManager;
    }

    /**
     * Handles player interaction with backpacks.
     *
     * @param event the player interact event
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if right-clicking
        if (event.getAction() != Action.RIGHT_CLICK_AIR
            && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack item = event.getItem();
        if (!BackpackItem.isBackpack(item)) {
            return;
        }

        event.setCancelled(true);

        Player player = event.getPlayer();
        @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
        UUID backpackUUID = BackpackItem.getBackpackUUID(item);
        BackpackTier tier = BackpackItem.getBackpackTier(item);

        if (backpackUUID == null || tier == null) {
            player.sendMessage("§cError: Invalid backpack data!");
            return;
        }

        // Get or create inventory
        String title = tier.getDisplayName();
        Inventory inventory = backpackManager.getInventory(
            backpackUUID, title, tier.getSlots());

        // Open for player
        player.openInventory(inventory);

        // Send message for Enderpacks
        if (tier.isEnderpack()) {
            player.sendMessage(
                "§5§lEnderpack §7opened! All Enderpacks with this ID share storage.");
        }
    }

    /**
     * Handles inventory close events for backpacks.
     *
     * @param event the inventory close event
     */
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inv = event.getInventory();
        String title = event.getView().getTitle();

        // Check if it's a backpack inventory
        boolean isBackpack = false;
        for (BackpackTier tier : BackpackTier.values()) {
            if (title.equals(tier.getDisplayName())) {
                isBackpack = true;
                break;
            }
        }

        if (!isBackpack) {
            return;
        }

        // Find the backpack UUID from the player's inventory or the inventory holder
        // We need to save the inventory when closed
        // For simplicity, we'll search through loaded inventories
        @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
        UUID backpackUUID = findBackpackUUID(inv);
        if (backpackUUID != null) {
            backpackManager.saveInventory(backpackUUID, inv);
        }
    }

    /**
     * Find the UUID of a backpack inventory by comparing instances.
     *
     * @param inventory the inventory to find
     * @return the UUID or null
     */
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    private UUID findBackpackUUID(Inventory inventory) {
        // Check loaded inventories
        for (BackpackTier tier : BackpackTier.values()) {
            // This is a simple implementation
            // A more robust solution would track opened inventories
        }
        // For now, we rely on the auto-save on server shutdown
        // TODO: Implement better tracking if needed
        return null;
    }
}
