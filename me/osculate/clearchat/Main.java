package me.osculate.clearchat;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements CommandExecutor {
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");
		logger.info("[" + pdfFile.getName() + "]" + " has been enabled (V." + pdfFile.getVersion() + ")");
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");
		logger.info("[" + pdfFile.getName() + "]" + " has been disabled (V." + pdfFile.getVersion() + ")");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(commandLabel.equalsIgnoreCase("clearchat") || commandLabel.equalsIgnoreCase("cc")) {
			Player p = (Player)sender;
			if(!p.hasPermission("cc.clear")) {
				p.sendMessage(ChatColor.RED + "I'm Sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is an error.");
			} else {
				for(int i=0;i<200;i++) {
					Bukkit.broadcastMessage("");
				}
				p.sendMessage(ChatColor.GREEN + p.getName() + " has cleared the chat.");
			}
		}
		return true;
	}
	
}
