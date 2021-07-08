package fr.matt.customstick;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(args.length!=1) return false;
		
		Player player = Bukkit.getPlayer(args[0]);
		if(player==null) return false;
		
		ItemStack stick = new ItemStack(Material.STICK, 1);
		ItemMeta stickM = stick.getItemMeta();
		stickM.setDisplayName(ChatColor.GREEN + "Heal Stick");
		stickM.setLore(Arrays.asList(" ",ChatColor.BLUE + "Use : 3"," "));
		stick.setItemMeta(stickM);
		
		player.getInventory().addItem(stick);
		return false;
	}

}
