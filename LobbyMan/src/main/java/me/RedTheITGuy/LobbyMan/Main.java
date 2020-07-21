package me.RedTheITGuy.LobbyMan;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		// Creates the config if it doesn't exist
		this.saveDefaultConfig();
		// Registers the event listener
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
}
