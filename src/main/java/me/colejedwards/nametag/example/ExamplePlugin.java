package me.colejedwards.nametag.example;

import me.colejedwards.nametag.Nametag;
import me.colejedwards.nametag.NametagException;
import me.colejedwards.nametag.PlayerNametag;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin implements Listener {

    private Nametag nametagLib;

    @Override
    public void onEnable() {
        nametagLib = new Nametag(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        try {
            nametagLib.getNametagHandler().setNametag(e.getPlayer(), new PlayerNametag(ChatColor.RED.toString(), "", ""));
        } catch (NametagException ex) {
            ex.printStackTrace();
        }
    }

}
