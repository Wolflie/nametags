package me.colejedwards.nametag;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Nametag {

    @Getter private static Nametag instance;

    private final Plugin plugin;
    private Map<UUID, Scoreboard> scoreboard = new HashMap<>();

    private NametagHandler nametagHandler;

    public Nametag(Plugin plugin) {
        instance = this;

        this.plugin = plugin;
        this.nametagHandler = new NametagHandler();

        Bukkit.getServer().getPluginManager().registerEvents(new NametagListener(), plugin);
    }

}
