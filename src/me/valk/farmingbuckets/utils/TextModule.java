package me.valk.farmingbuckets.utils;

import org.bukkit.ChatColor;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class TextModule {

	public static String color(String message) {
		String primaryColor = "&f";
		message = message.replaceAll("&q", primaryColor);
		String secondaryColor = "&7";
		message = message.replaceAll("&w", secondaryColor);
		return ChatColor.translateAlternateColorCodes('&', secondaryColor + message);
	}
}
