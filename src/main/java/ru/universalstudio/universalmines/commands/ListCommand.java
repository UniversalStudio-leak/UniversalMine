package ru.universalstudio.universalmines.commands;

import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.MineInfo;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class ListCommand extends Sub {
  
  public boolean execute(Player player, String[] args) {
    if (Mines.getMines().isEmpty()) {
      Utils.sendMessage(player, Utils.getMessage("list.empty"));
      return true;
    }
    Utils.sendMessage(player, Utils.getMessage("list.title"));
    int n = 0; // Counter mines
    for (MineInfo mineInfo : Mines.getMines()) {
      n++;
      Utils.sendMessage(player, Utils.getMessage("list.format")
              .replace("%step%", "" + n)
              .replace("%name%", mineInfo.getName())
              .replace("%stats%", Utils.getMessage("list.stats")
              .replace("%min%",
                              (int)mineInfo.getMin().getX() + ", " +
                                      (int)mineInfo.getMin().getY() + ", " +
                                      (int)mineInfo.getMin().getZ())
              .replace("%max%",
                      (int)mineInfo.getMax().getX() + ", " +
                              (int)mineInfo.getMax().getY() + ", " +
                              (int)mineInfo.getMax().getZ())
              .replace("%world%", mineInfo.getWorld().getName())
      ));
    } 
    return true;
  }
  
  public String command() {
    return "list";
  }

  public String permission() {
    return "umine.command.list";
  }
  
  public String description() {
    return Utils.getMessage("list.usage");
  }
  
  public String[] aliases() {
    return null;
  }

}
