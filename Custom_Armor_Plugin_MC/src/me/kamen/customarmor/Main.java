package me.kamen.customarmor;

import org.bukkit.plugin.java.JavaPlugin;

import me.kamen.customarmor.ArmorEvent.ArmorListener;
import me.kamen.customarmor.ArmorEvent.DispenserArmorListener;
import me.kamen.customarmor.Items.ItemManager;
import me.kamen.customarmor.Listeners.ArmorListenervent;
import me.kamen.customarmor.Listeners.PlayerListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		new ItemManager(this);
		
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		try{
			//Better way to check for this? Only in 1.13.1+?
			Class.forName("org.bukkit.event.block.BlockDispenseArmorEvent");
			getServer().getPluginManager().registerEvents(new DispenserArmorListener(), this);
		}catch(Exception ignored){}
		
		new PlayerListener(this);
		new ArmorListenervent(this);
	}
	
	@Override
	public void onDisable() {
		
	}

}
