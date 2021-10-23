package ru.universalstudio.universalmines.mines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import ru.universalstudio.universalmines.Main;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class MineManager {

  public static void addBlock(Location loc, MineBlock mineBlock) {
    if (getBlock(loc) == null || getBlock(loc).isCancelled()) {
      blocks.put(loc, new MineBlockUpdate(mineBlock, loc));
    }
    (blocks.get(loc)).runTaskTimer(Main.getInstance(), 0L, 20L);
  }
  
  public static MineBlockUpdate getBlock(Location location) {
    return blocks.get(location);
  }
  
  public static void reset() {
    blocks.values().forEach(MineManager::resetBlocks);
  }
  
  public static List<MineBlockUpdate> getBlocks() {
    return new ArrayList<>(blocks.values());
  }
  
  private static void resetBlocks(MineBlockUpdate mineBlockUpdate) {
    mineBlockUpdate.reset();
  }

  private static HashMap<Location, MineBlockUpdate> blocks = new HashMap<>();
}
