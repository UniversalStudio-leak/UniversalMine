package ru.universalstudio.universalmines.mines;

import com.sk89q.worldedit.bukkit.selections.Selection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import ru.universalstudio.universalmines.Config;
import ru.universalstudio.universalmines.Utils;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Mines {
  public static FileConfiguration getConfig() {
    return (config != null) ? config : (config = Config.getFile("mines.yml"));
  }
  private static FileConfiguration config;
  public static void saveConfig() {
    Config.save(getConfig(), "mines.yml");
  }
  
  public static void removeMine(String s) {
    getConfig().set(s, null);
    saveConfig();
  }
  
  public static void saveMine(String s, Selection selection) {
    getConfig().set(s + ".min.x", selection.getMinimumPoint().getX());
    getConfig().set(s + ".min.y", selection.getMinimumPoint().getY());
    getConfig().set(s + ".min.z", selection.getMinimumPoint().getZ());
    getConfig().set(s + ".max.x", selection.getMaximumPoint().getX());
    getConfig().set(s + ".max.y", selection.getMaximumPoint().getY());
    getConfig().set(s + ".max.z", selection.getMaximumPoint().getZ());
    getConfig().set(s + ".world", selection.getWorld().getName());
    saveConfig();
  }
  
  public static void loadBlocks() {
    for (String s : Utils.getConfig().getConfigurationSection("ores").getKeys(false)) {
      Material material = Material.getMaterial(s.toUpperCase());
      MineBlock mineBlock = new MineBlock(
              material,
              Double.parseDouble(Utils.getConfig().getString("ores." + s + ".money")),
              Utils.getConfig().getInt("ores." + s + ".update"),
              ((Utils.getConfig().getString("ores." + s + ".prefix") != null) ? Utils.getConfig().getString("ores." + s + ".prefix") : material.name())
      );
      blocks.add(mineBlock);
    } 
  }
  
  public static MineBlock getBlock(Material material) {
    for (MineBlock mineBlock : blocks) {
      if (mineBlock.getBlock() == material) {
        return mineBlock;
      }
    } 
    return null;
  }
  
  public static MineInfo getMine(String name) {
    if (getConfig().getString(name) == null) {
      return null;
    }
    World world = Bukkit.getWorld(getConfig().getString(name + ".world"));
    MineInfo mineInfo = new MineInfo(name,
            new Location(world, getConfig().getDouble(name + ".max.x"), getConfig().getDouble(name + ".max.y"), getConfig().getDouble(name + ".max.z")),
            new Location(world, getConfig().getDouble(name + ".min.x"), getConfig().getDouble(name + ".min.y"), getConfig().getDouble(name + ".min.z")),
            world
    );
    return mineInfo;
  }
  
  public static boolean getMine(Location location) { // This public not good decompiled
    Iterator<String> iterator = getConfig().getConfigurationSection("").getKeys(false).iterator();
    while (iterator.hasNext()) {
      MineInfo mine = getMine(iterator.next());
      double x = location.getX();
      double y = location.getY();
      double z = location.getZ();
      if (Math.min(mine.getMin().getX(), mine.getMax().getX()) <= x && Math.min(mine.getMin().getY(), mine.getMax().getY()) <= y && Math.min(mine.getMin().getZ(), mine.getMax().getZ()) <= z && Math.max(mine.getMin().getX(), mine.getMax().getX()) >= x && Math.max(mine.getMin().getY(), mine.getMax().getY()) >= y && Math.max(mine.getMin().getZ(), mine.getMax().getZ()) >= z) {
        return true;
      }
    } 
    return false;
  }
  
  public static List<MineInfo> getMines() { // This public not good decompiled
    ArrayList<MineInfo> list = new ArrayList<>();
    Iterator<String> iterator = getConfig().getConfigurationSection("").getKeys(false).iterator();
    while (iterator.hasNext()) {
      list.add(getMine(iterator.next()));
    }
    return list;
  }

  private static List<MineBlock> blocks = new ArrayList<>();
}
