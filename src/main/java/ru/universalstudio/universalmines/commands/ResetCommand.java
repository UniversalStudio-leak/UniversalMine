package ru.universalstudio.universalmines.commands;

import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.MineManager;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class ResetCommand extends Sub {

  public boolean execute(Player player, String[] array) {
    MineManager.reset();
    Utils.sendMessage(player, Utils.getMessage("reset.complete"));
    return true;
  }

  public String command() {
    return "reset";
  }

  public String permission() {
    return "umine.command.reset";
  }

  public String description() {
    return Utils.getMessage("reset.usage");
  }

  public String[] aliases() {
    return null;
  }

}
