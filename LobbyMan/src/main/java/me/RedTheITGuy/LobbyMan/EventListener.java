package me.RedTheITGuy.LobbyMan;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class EventListener implements Listener {
	// Fired when a player joins the game
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent joinEvent) {
		// Gets the config file
		FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("LobbyMan").getConfig();
		// Gets info from the config file
		String title = config.getString("title");
		
		// Converts the colour codes to colours
		if (title != null) title = ChatColor.translateAlternateColorCodes('&', title);
		
		// Gets the player from the event
		Player player = joinEvent.getPlayer();
		
		// Creates a new scoreboard
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		// Creates an objective for the player
		Objective obj = board.registerNewObjective(player.getName(), "dummy", title);
		// Sets the objective to display in the sidebar
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		// Adds a entery to the scoreboard
		Score test = obj.getScore("test " + ChatColor.RED + "Test");
		test.setScore(1);
		
		// Displays the board for the player
		player.setScoreboard(board);
	}
}
