package me.kamen.customarmor.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.kamen.customarmor.Main;

public class PlayerListener implements Listener{
	
private Main plugin;
	
	public PlayerListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().setResourcePack("https://www.dropbox.com/s/oq5d2zhpltip56o/VanillaTweaks_r311532.zip?dl=1");
	}

}
