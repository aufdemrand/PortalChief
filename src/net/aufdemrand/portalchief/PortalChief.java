package net.aufdemrand.portalchief;

import java.util.logging.Level;
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