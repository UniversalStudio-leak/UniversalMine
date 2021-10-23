package ru.universalstudio.universalmines.commands;

import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.MineManager;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class RemoveCommand extends Sub {

  public boolean execute(Player player, String[] args) {
    if (args.length < 2) {
      return true; // Author not coded this moment
    } else {
      String s = args[1];
      if (Mines.getMine(s) == null) {
        Utils.sendMessage(player, Utils.getMessage("remove.not-found"));
        return true;
      } else {
        MineManager.reset();
        Mines.removeMine(s);
        Utils.sendMessage(player, Utils.getMessage("remove.complete"));
        return true;
      }
    }
  }

  public String command() {
    return "remove";
  }

  public String permission() {
    return "umine.command.remove";
  }

  public String description() {
    return Utils.getMessage("remove.usage");
  }

  public String[] aliases() {
    return null;
  }

}
