package ru.universalstudio.universalmines;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Checks {
  public static void check(Player player) {
    if (player.hasPermission("umine.checks")) {
      return;
    }
    if ((player.getAllowFlight() || player.isFlying()) && Utils.getConfig().getBoolean("checks.fly.enable")) {
      Utils.sendMessage(player, Utils.getConfig().getString("checks.fly.message"));
      player.setAllowFlight(false);
      player.setFlying(false);
    } 
    if (Utils.getConfig().getBoolean("checks.gamemode.enable"))
      for (String s : Utils.getConfig().getStringList("checks.gamemode.modes")) {
        if (player.getGameMode() == GameMode.valueOf(s.toUpperCase())) {
          player.setGameMode(GameMode.valueOf(Utils.getConfig().getString("checks.gamemode.setmode").toUpperCase()));
          Utils.sendMessage(player, Utils.getConfig().getString("checks.gamemode.message"));
        } 
      }  
  }

}
