package ru.universalstudio.universalmines.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Money;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class SetSalaryCommand extends Sub {

  public boolean execute(Player player, String[] array) {
    if (array.length < 3) {
      return false;
    } else {
      Player player2 = Bukkit.getPlayer(array[1]);
      if (player2 == null) {
        Utils.sendMessage(player, Utils.getMessage("setsalary.player-notfound"));
        return true;
      } else {
        try {
          Money.setSalary(player2, Double.parseDouble(array[2]));
          Utils.sendMessage(player, Utils.getMessage("setsalary.complete").replace("%player%", player2.getName()).replace("%salary%", Money.getSalaryFormat(player2)));
          return true;
        } catch (Exception var5) {
          Utils.sendMessage(player, Utils.getMessage("setsalary.double-exception"));
          return true;
        }
      }
    }
  }

  public String command() {
    return "setsalary";
  }

  public String permission() {
    return "umine.command.setsalary";
  }

  public String description() {
    return Utils.getMessage("setsalary.usage");
  }

  public String[] aliases() {
    return null;
  }

}
