package me.lol768.bc;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() 
    {
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "RubberBand");
        getServer().getPluginManager().registerEvents(this, this);
    }

    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{
    	if (cmd.getName().equalsIgnoreCase("bcsendall") && sender.hasPermission("bc.sendall") && args.length == 1)
    	{
    		for (Player p : Bukkit.getOnlinePlayers())
    		{
    			String s = args[0];
    			p.sendPluginMessage(this, "RubberBand", s.getBytes());
    		}
    	}
    	
    	if (cmd.getName().equalsIgnoreCase("bcsend") && sender.hasPermission("bc.send") && args.length == 2)
    	{
    		Player p = Bukkit.getPlayer(args[0]);
    		if (p!= null)
    		{
    			String sa = args[1];
    			p.sendPluginMessage(this, "RubberBand", sa.getBytes());
    		}
    		else
    		{
    			sender.sendMessage(ChatColor.RED + "Invalid player...");
    		}
    		
    	}
		return true;
    	
	}
    //event.getPlayer().sendPluginMessage(this, "RubberBand", sign.getLine(1).getBytes());
}


