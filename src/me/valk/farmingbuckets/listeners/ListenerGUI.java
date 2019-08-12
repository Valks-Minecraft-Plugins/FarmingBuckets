package me.valk.farmingbuckets.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.valk.farmingbuckets.utils.TextModule;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class ListenerGUI implements Listener {
	@EventHandler
	private void invClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView view = e.getView();
		if (view.getTitle().equalsIgnoreCase("Farming Buckets")) {
			switch (e.getSlot()) {
			case 0:
				p.sendMessage(TextModule.color("&7Input the height for the cactus!"));
				ListenerChat.inputCactusHeight.add(p.getUniqueId());
				view.close();
				break;
			case 1:
				p.sendMessage(TextModule.color("&7Input the width and height for the sugarcane!"));
				ListenerChat.inputSugarCane.add(p.getUniqueId());
				view.close();
				break;
			default:
				break;
			}
		}
	}
}
