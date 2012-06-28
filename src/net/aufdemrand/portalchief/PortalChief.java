package net.aufdemrand.portalchief;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalChief extends JavaPlugin {


	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		return false;

	}

	@Override
	public void onDisable() {
		
		getLogger().log(Level.INFO, " v" + getDescription().getVersion() + " disabled.");
		
	}

	@Override
	public void onEnable() {

		this.getConfig().options().copyDefaults(true);
		saveConfig();  

		
		getServer().getPluginManager().registerEvents(new PortalListener(this), this);


	}

}