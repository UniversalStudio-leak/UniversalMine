package ru.universalstudio.universalmines;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Utils {

  private static FileConfiguration config;
  
  public static FileConfiguration getConfig() {
    return (config != null) ? config : (config = Config.getFile("config.yml"));
  }
  
  public static String color(String s) {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
  
  public static String getMessage(String s) {
    return getConfig().getString("messages." + s);
  }
  
  public static void sendMessage(Player player, String s) {
    if (s != null)
      for (String string : s.split(";")) {
        if (string.startsWith("actionbar:")) {
          ActionBar.sendActionBar(player, string.split("actionbar:")[1]);
        } else if (string.startsWith("title:")) {
          Title.sendTitle(player, string.split("title:")[1]);
        } else if (!string.isEmpty()) {
          player.sendMessage(color(getMessage("prefix") + string));
        } 
      }  
  }
}
