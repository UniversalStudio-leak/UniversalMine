package ru.universalstudio.universalmines.commands;

import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Main;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class CreateCommand extends Sub {

  public boolean execute(Player player, String[] args) {
    if (args.length < 2) {
      return false;
    }
    Selection selection = Main.getWorldEdit().getSelection(player);
    if (selection == null) {
      Utils.sendMessage(player, Utils.getMessage("create.no_selection"));
      return true;
    } 
    if (Mines.getMine(args[1]) != null) {
      Utils.sendMessage(player, Utils.getMessage("create.already"));
      return true;
    } 
    Mines.saveMine(args[1], selection);
    Utils.sendMessage(player, Utils.getMessage("create.complete"));
    return true;
  }

  public String command() {
    return "create";
  }

  public String permission() {
    return "umine.command.create";
  }

  public String description() {
    return Utils.getMessage("create.usage");
  }
  
  public String[] aliases() {
    return new String[] { "c" };
  }
}
