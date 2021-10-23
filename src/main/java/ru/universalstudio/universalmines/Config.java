package ru.universalstudio.universalmines;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Config {

  public static FileConfiguration getFile(String s) {
    File file = new File(Main.getInstance().getDataFolder(), s);
    if (Main.getInstance().getResource(s) == null) {
      return save(YamlConfiguration.loadConfiguration(file), s);
    }
    if (!file.exists()) {
      Main.getInstance().saveResource(s, false);
    }
    return YamlConfiguration.loadConfiguration(file);
  }
  
  public static FileConfiguration save(FileConfiguration fileConfiguration, String s) {
    try {
      fileConfiguration.save(new File(Main.getInstance().getDataFolder(), s));
    }
    catch (IOException ex) {
      ex.printStackTrace();
    } 
    return fileConfiguration;
  }
}
