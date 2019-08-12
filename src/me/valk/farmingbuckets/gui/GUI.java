package me.valk.farmingbuckets.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import me.valk.farmingbuckets.utils.ItemModule;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class GUI {
	public static Inventory farmingBucketsGUI() {
		Inventory inv = Bukkit.createInventory(null, 9, "Farming Buckets");
		inv.setItem(0, ItemModule.item("&fCactus", "&7Create a cactus.", Material.CACTUS));
		inv.setItem(1, ItemModule.item("&fSugar Cane", "&7Create a sugar cane.", Material.SUGAR_CANE));
		return inv;
	}
}
