package ru.universalstudio.universalmines.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Money;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class AddSalaryCommand extends Sub {

  public boolean execute(Player player, String[] args) {
    if (args.length < 3) {
      return true; // Author not coded this moment
    } else {
      Player target = Bukkit.getPlayer(args[1]);
      if (target == null) {
        Utils.sendMessage(player, Utils.getMessage("addsalary.player-notfound"));
        return true;
      } else {
        try {
          Money.addSalary(target, Double.parseDouble(args[2]));
          Utils.sendMessage(player, Utils.getMessage("addsalary.complete")
                  .replace("%player%", target.getName())
                  .replace("%salary%", Money.getSalaryFormat(target))
          );
          return true;
        } catch (Exception noDouble) {
          Utils.sendMessage(player, Utils.getMessage("addsalary.double-exception"));
          return true;
        }
      }
    }
  }

  public String command() {
    return "addsalary";
  }

  public String permission() {
    return "umine.command.addsalary";
  }

  public String description() {
    return Utils.getMessage("addsalary.usage");
  }

  public String[] aliases() {
    return null;
  }
}
