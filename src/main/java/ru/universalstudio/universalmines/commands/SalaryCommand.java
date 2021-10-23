package ru.universalstudio.universalmines.commands;

import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Money;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.MinePlayer;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class SalaryCommand extends Sub {

  public boolean execute(Player player, String[] array) {
    if (Money.getSalary(player) <= 0.0D) {
      Utils.sendMessage(player, Utils.getMessage("salary.zero"));
      return true;
    } else {
      Utils.sendMessage(player, Utils.getMessage("salary.complete").replace("%salary%", Money.getSalaryFormat(player)));
      Money.addMoney(player, Money.getSalary(player));
      Money.setSalary(player, 0.0D);
      MinePlayer.resetOres(player);
      return true;
    }
  }

  public String command() {
    return "salary";
  }

  public String permission() {
    return "umine.command.salary";
  }

  public String description() {
    return Utils.getMessage("salary.usage");
  }

  public String[] aliases() {
    return null;
  }

}
