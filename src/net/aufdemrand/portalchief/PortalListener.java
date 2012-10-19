package net.aufdemrand.portalchief;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalListener implements Listener {

	PortalChief plugin;
	
	public PortalListener(PortalChief instance) { 
		plugin = instance;
		}

	@EventHandler
	public void PortalListen(PlayerPortalEvent event) {

		if (!event.getPlayer().hasPermission("portal.chief")) return;
		if (plugin.getConfig().getStringList("allowed_worlds").contains(event.getPlayer().getWorld().getName())
				|| plugin.getConfig().getString("allowed_worlds").contains("*")) {

			// Cancel event, so player doesn't end up in the nether.
			event.setCancelled(true);
			
			String theWorld = plugin.getConfig().getString("world");
			Boolean useCurrentWorld = plugin.getConfig().getBoolean("use_current_world");
			Player thePlayer = event.getPlayer();
			String theMessage = plugin.getConfig().getString("message");
			Boolean useTheMessage = plugin.getConfig().getBoolean("use_message");

			Location TPLocation;

			// Get world spawn location
			if (useCurrentWorld == true) 
				TPLocation = thePlayer.getWorld().getSpawnLocation(); 
			else 
				TPLocation = plugin.getServer().getWorld(theWorld).getSpawnLocation(); 

			// Teleport!
			thePlayer.teleport(TPLocation);

			// Spit message
			if (useTheMessage) 
				thePlayer.sendMessage(theMessage);
		}
	}

}