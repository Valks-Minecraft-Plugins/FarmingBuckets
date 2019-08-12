package me.valk.farmingbuckets.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.valk.farmingbuckets.gui.GUI;
import me.valk.farmingbuckets.utils.TextModule;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class CmdFarmingBuckets implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("farmingbuckets")) {
			if (sender instanceof ConsoleCommandSender) {
				sender.sendMessage(TextModule.color("&cOnly in game players can execute this command!"));
				return true;
			}
			
			if (!sender.hasPermission("farmingbuckets.use")) {
				sender.sendMessage(TextModule.color("&cYou need the 'farmingbuckets.use' permission to use this command!"));
				return true;
			}
			
			Player p = (Player) sender;
			p.openInventory(GUI.farmingBucketsGUI());
			return true;
		}
		return true;
	}
}
