package de.jonarne.ftsanimalplague.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.jonarne.ftsanimalplague.commands.AnimalCommand;
import de.jonarne.ftsanimalplague.listeners.MobTameListener;

public class Main extends JavaPlugin {
	
	
	private static Main plugin;

	public void onEnable() {
		plugin  = this;
		
		getCommand("animal").setExecutor(new AnimalCommand());
		
		
		PluginManager pluginManger = Bukkit.getPluginManager();
		pluginManger.registerEvents(new MobTameListener(), this);
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}	
	
}
