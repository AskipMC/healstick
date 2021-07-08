package fr.matt.customstick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RighClickStick implements Listener {
	
	Map<String, Long> cd = new HashMap<String,Long>();

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		
		if(e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) {
			
			
			Player player = e.getPlayer();
			ItemStack current = player.getInventory().getItemInHand();
			
			if(!current.hasItemMeta()) return;
			if(!current.getItemMeta().hasDisplayName()) return;
			if(current.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Heal Stick")) {
				
				ItemMeta meta = current.getItemMeta();
				List<String> lore = meta.getLore();
				String stockline = lore.get(1);
				
				String[] split = stockline.split(": ");
				String stockString = split[1];
				int stock = Integer.parseInt(stockString);
				
				if(cd.containsKey(player.getName())) {
					if(cd.get(player.getName())>System.currentTimeMillis()/1000) {
						long timeleft = (cd.get(player.getName())-System.currentTimeMillis()/1000);
						player.sendMessage(ChatColor.RED + "Tu es en cooldown pendant encore " + timeleft + " secondes!");
						return;
					}
				}
				cd.put(player.getName(), System.currentTimeMillis()/1000+ 90);
				
				
				if(!(stock-->0)) {
					player.sendMessage(ChatColor.RED + "Le Stick n'a plus d'utilisations !");
					return;
				}
				
				meta.setLore(Arrays.asList(" ",ChatColor.BLUE + "Stock : " + stock ," "));
				current.setItemMeta(meta);
				player.updateInventory();
				
				player.setHealth(20);
				
			}
			
		}
		
		
		
		
	}
}
