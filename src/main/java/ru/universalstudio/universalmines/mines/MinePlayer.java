package ru.universalstudio.universalmines.mines;

import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Config;
import ru.universalstudio.universalmines.Money;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class MinePlayer extends PlaceholderHook {

  private static FileConfiguration config;
  
  public String onRequest(OfflinePlayer p, String s) {
    if (p != null && p.isOnline()) {
      return onPlaceholderRequest(p.getPlayer(), s);
    }
    return null;
  }
  
  public String onPlaceholderRequest(Player player, String s) {
    if (s.equals("salary")) {
      return Money.getSalaryFormat(player);
    }
    return String.valueOf(get(player, s));
  }
  
  public static FileConfiguration getConfig() {
    return (config != null) ? config : (config = Config.getFile("players.yml"));
  }
  
  public static void saveConfig() {
    Config.save(getConfig(), "players.yml");
  }
  
  public static void resetOres(Player player) {
    getConfig().set(player.getName(), null);
    saveConfig();
  }
  
  public static int get(Player player, String s) {
    if (getConfig().getString(player.getName()) == null) {
      getConfig().set(player.getName() + "." + s, 0);
      saveConfig();
    } 
    return getConfig().getInt(player.getName() + "." + s);
  }
  
  public static void set(Player player, String s, int n) {
    getConfig().set(player.getName() + "." + s, n);
    saveConfig();
  }
  
  public static void add(Player player, String s, int n) {
    getConfig().set(player.getName() + "." + s, get(player, s) + n);
    saveConfig();
  }
}
