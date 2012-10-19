package net.aufdemrand.portalchief;

import java.util.logging.Level;
<<<<<<< HEAD

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
=======
>>>>>>> Update to 1.0, allow only specific worlds.
import org.bukkit.plugin.java.JavaPlugin;

public class PortalChief extends JavaPlugin {

	@Override
	public void onDisable() {
		getLogger().log(Level.INFO, " v" + getDescription().getVersion() + " disabled.");
	}

	@Override
	public void onEnable() {
		saveDefaultConfig();
		reloadConfig();
		getServer().getPluginManager().registerEvents(new PortalListener(this), this);
	}

}