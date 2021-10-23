package ru.universalstudio.universalmines.commands;

import org.bukkit.entity.Player;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public abstract class Sub extends Utils {

  abstract boolean execute(Player player, String[] args);

  abstract String command();
  abstract String permission();
  abstract String description();
  abstract String[] aliases();

}
