package ru.universalstudio.universalmines;

import org.bukkit.Bukkit;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Logger {

  public static void info(String s) {
    Bukkit.getConsoleSender().sendMessage(Utils.color("&b[" + Main.getInstance().getName() + "/INFO] " + s));
  }
  
  public static void warn(String s) {
    Bukkit.getConsoleSender().sendMessage(Utils.color("&e[" + Main.getInstance().getName() + "/WARN] " + s));
  }
  
  public static void error(String s) {
    Bukkit.getConsoleSender().sendMessage(Utils.color("&c[" + Main.getInstance().getName() + "/ERROR] " + s));
  }
}
