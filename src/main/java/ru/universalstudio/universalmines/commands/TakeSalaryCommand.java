package ru.universalstudio.universalmines.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Money;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class TakeSalaryCommand extends Sub {

  public boolean execute(Player player, String[] args) {
    if (args.length < 3) {
      return true; // Author no coded this moment
    } else {
      Player target = Bukkit.getPlayer(args[1]);
      if (target == null) {
        Utils.sendMessage(player, Utils.getMessage("takesalary.player-notfound"));
        return true;
      } else {
        try {
          Money.takeSalary(target, Double.parseDouble(args[2]));
          Utils.sendMessage(player, Utils.getMessage("takesalary.complete")
                  .replace("%player%", target.getName())
                  .replace("%salary%", Money.getSalaryFormat(target))
          );
          return true;
        } catch (Exception noDouble) {
          Utils.sendMessage(player, Utils.getMessage("takesalary.double-exception"));
          return true;
        }
      }
    }
  }

  public String command() {
    return "takesalary";
  }

  public String permission() {
    return "umine.command.takesalary";
  }

  public String description() {
    return Utils.getMessage("takesalary.usage");
  }

  public String[] aliases() {
    return null;
  }

}
