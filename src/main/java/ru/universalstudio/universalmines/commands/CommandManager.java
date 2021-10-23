package ru.universalstudio.universalmines.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class CommandManager implements CommandExecutor {

  private List<Sub> commands;

  public CommandManager() {
    (this.commands = new ArrayList<>()).add(new CreateCommand());
    this.commands.add(new RemoveCommand());
    this.commands.add(new ListCommand());
    this.commands.add(new SalaryCommand());
    this.commands.add(new SetSalaryCommand());
    this.commands.add(new TakeSalaryCommand());
    this.commands.add(new AddSalaryCommand());
    this.commands.add(new ResetCommand());
  }

  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (args.length == 0) {
        if (!this.getAllowCommands(player).isEmpty()) {
          Utils.sendMessage(player, Utils.getMessage("commandmanager.title_help"));

          Iterator iterator = this.getAllowCommands(player).iterator(); // This moment no stable decompiled
          while(iterator.hasNext()) {
            Utils.sendMessage(player, ((Sub)iterator.next()).description());
          }
        }
        return true;
      }

      Sub subCommand = this.getCommand(args[0]);
      if (subCommand != null) {
        if (subCommand.permission() != null && !player.hasPermission(subCommand.permission())) {
          Utils.sendMessage(player, Utils.getMessage("commandmanager.no_permission"));
          return true;
        }

        try {
          if (!subCommand.execute(player, args)) {
            Utils.sendMessage(player, subCommand.description());
          }
        } catch (Exception error) {
          error.printStackTrace();
          Utils.sendMessage(player, Utils.getMessage("commandmanager.error"));
        }
      } else {
        Utils.sendMessage(player, Utils.getMessage("commandmanager.command_not_found"));
      }
    }
    return true;
  }


  public List<Sub> getAllowCommands(Player player) {
    ArrayList<Sub> list = new ArrayList<>();
    for (Sub sub : this.commands) {
      if (sub.permission() != null) {
        if (!player.hasPermission(sub.permission())) {
          continue;
        }
        list.add(sub);
        continue;
      }
      list.add(sub);
    }
    return list;
  }

  public Sub getCommand(String s) {
    for (Sub sub : this.commands) {
      if (sub.command().equalsIgnoreCase(s)) {
        return sub;
      }
      if (sub.aliases() == null) {
        continue;
      }
      String[] args = sub.aliases();
      for (int length = args.length, i = 0; i < length; i++) {
        if (args[i].equalsIgnoreCase(s)) {
          return sub;
        }
      }
    }
    return null;
  }

}
