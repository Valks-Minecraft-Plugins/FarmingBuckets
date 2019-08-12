package me.valk.farmingbuckets.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import me.valk.farmingbuckets.utils.TextModule;
import me.valk.farmingbuckets.utils.Utils;

/**
 * All Rights Reserved 2019 Divine Company Valkyrienyanko
 */
public class ListenerChat implements Listener {
	public static List<UUID> inputCactusHeight = new ArrayList<UUID>();
	public static List<UUID> inputSugarCane = new ArrayList<UUID>();

	@EventHandler
	private void chatEvent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		UUID playerUUID = p.getUniqueId();
		if (inputCactusHeight.contains(playerUUID)) {
			e.setCancelled(true);
			if (e.getMessage().equalsIgnoreCase("EXIT")) {
				inputCactusHeight.remove(playerUUID);
				p.sendMessage(TextModule.color("&cExited input mode."));
				return;
			}

			if (!Utils.isNumeric(e.getMessage())) {
				p.sendMessage(TextModule.color("&cYou need to input a valid number! Type EXIT to leave this mode!"));
				return;
			}
			
			if (Integer.parseInt(e.getMessage()) >= 30) {
				p.sendMessage(TextModule.color("&cYou cannot exceed a height of 30!! Type EXIT to leave this mode!"));
			}

			inputCactusHeight.remove(playerUUID);
			p.sendMessage(TextModule.color("&2Created a cactus with a height of " + e.getMessage() + "!"));
			createCactus(p.getLocation(), Integer.parseInt(e.getMessage()));
			return;
		}

		if (inputSugarCane.contains(playerUUID)) {
			e.setCancelled(true);
			if (e.getMessage().startsWith("EXIT")) {
				inputSugarCane.remove(playerUUID);
				p.sendMessage(TextModule.color("&cExited input mode."));
				return;
			}

			String[] numbers = e.getMessage().split(" ");
			
			if (numbers.length <= 1) {
				p.sendMessage(TextModule.color("&cYou need to input both values! For example 20 3"));
				return;
			}
			
			if (!Utils.isNumeric(numbers[0])) {
				p.sendMessage(TextModule.color("&cYou need to input valid numbers! Type EXIT to leave this mode!"));
				return;
			}
			
			if (!Utils.isNumeric(numbers[1])) {
				p.sendMessage(TextModule.color("&cYou need to input valid numbers! Type EXIT to leave this mode!"));
				return;
			}
			
			if (Integer.parseInt(numbers[0]) >= 30) {
				p.sendMessage(TextModule.color("&cYou cannot exceed a width of 30!! Type EXIT to leave this mode!"));
				return;
			}
			
			if (Integer.parseInt(numbers[1]) >= 30) {
				p.sendMessage(TextModule.color("&cYou cannot exceed a height of 30!! Type EXIT to leave this mode!"));
				return;
			}

			inputSugarCane.remove(playerUUID);
			p.sendMessage(TextModule.color("&2Created a sugarcane with a width of " + numbers[0] + " and a height of " + numbers[1] + "!"));
			
			createSugarCane(p.getLocation(), Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
			return;
		}
	}

	private void createCactus(Location origin, int height) {
		for (int i = 0; i < height; i++) {
			// Set the sand blocks 1 block in front of the player on the left and right
			// side.
			// LEFT
			Block sandLeft = origin.clone().add(1 + i, i * 2, 1).getBlock();
			sandLeft.setType(Material.STONE);

			Block cactusLeft = sandLeft.getLocation().clone().add(0, 1, 0).getBlock();
			cactusLeft.setType(Material.CACTUS);

			// RIGHT
			Block sandRight = origin.clone().add(-1 - i, i * 2, 1).getBlock();
			sandRight.setType(Material.STONE);

			Block cactusRight = sandRight.getLocation().clone().add(0, 1, 0).getBlock();
			cactusRight.setType(Material.CACTUS);
		}
	}

	private void createSugarCane(Location origin, int width, int height) {
		final int HEIGHT_SEPARATOR = 6;
		
		for (int y = 0; y < height; y++) {
			for (int w = 0; w < width; w++) {
				Block water = origin.clone().add(-1, 1 + (y * HEIGHT_SEPARATOR), 1 + w).getBlock();
				water.setType(Material.STATIONARY_WATER);
			}

			for (int s = 0; s < width; s++) {
				for (int x = 0; x < 2; x++) {
					// ORIGIN
					Block stone = origin.clone().add(-x * 2, (y * HEIGHT_SEPARATOR), 1 + s).getBlock();
					stone.setType(Material.STONE);
					
					Block sand = stone.getLocation().clone().add(0, 1, 0).getBlock();
					sand.setType(Material.SAND);

					Block sugarcane = sand.getLocation().clone().add(0, 1, 0).getBlock();
					sugarcane.setType(Material.SUGAR_CANE_BLOCK);
				}
			}
			
			for (int z = 0; z < 2; z++) {
				// ORIGIN
				Block stone = origin.clone().add(-1, (y * HEIGHT_SEPARATOR), z * (width + 1)).getBlock();
				stone.setType(Material.STONE);

				Block stone2 = stone.getLocation().clone().add(0, 1, 0).getBlock();
				stone2.setType(Material.STONE);
			}
		}
	}
}
