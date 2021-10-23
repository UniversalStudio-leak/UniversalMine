package ru.universalstudio.universalmines;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.universalstudio.universalmines.commands.CommandManager;
import ru.universalstudio.universalmines.events.BlockListener;
import ru.universalstudio.universalmines.events.MoveListener;
import ru.universalstudio.universalmines.mines.MineManager;
import ru.universalstudio.universalmines.mines.MinePlayer;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Main extends JavaPlugin {

  private static Main instance;

  public static Main getInstance() {
    return instance;
  }

  public void onEnable() {
    instance = this;
    Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[UniversalCode] Plugin recompiled by NaulbiMIX | Sponsored by FlatiCommunity (https://t.me/flaticommunity) | Specially publication for https://teletype.in/@naulbimix/rumine");
    Mines.loadBlocks();
    this.getCommand("umine").setExecutor(new CommandManager());
    this.getServer().getPluginManager().registerEvents(new BlockListener(), this);
    this.getServer().getPluginManager().registerEvents(new MoveListener(), this);
    PlaceholderAPI.registerPlaceholderHook("universalmines", new MinePlayer());
    new Money();
    Logger.info("Плагин успешно включён.");
  }

  public void onDisable() {
    MineManager.reset();
  }

  public static WorldEditPlugin getWorldEdit() {
    Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldEdit");
    return plugin != null && plugin instanceof WorldEditPlugin ? (WorldEditPlugin)plugin : null;
  }
}
