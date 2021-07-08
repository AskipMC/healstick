package fr.matt.customstick;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le plugin CustomStick vient de s'allumer !");
		getCommand("customstick").setExecutor(new Commands());
		Bukkit.getPluginManager().registerEvents(new RighClickStick(), this);
		
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin CustomStick vient de s'éteindre !");
	}
	

}
