package me.valk.farmingbuckets;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.valk.farmingbuckets.commands.CmdFarmingBuckets;
import me.valk.farmingbuckets.listeners.ListenerChat;
import me.valk.farmingbuckets.listeners.ListenerGUI;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class FarmingBuckets extends JavaPlugin {
	@Override
	public void onEnable() {
		registerCommands();
		registerListeners(getServer().getPluginManager());
	}
	
	private void registerCommands() {
		getCommand("farmingbuckets").setExecutor(new CmdFarmingBuckets());
	}
	
	private void registerListeners(PluginManager pm) {
		pm.registerEvents(new ListenerChat(), this);
		pm.registerEvents(new ListenerGUI(), this);
	}
}
