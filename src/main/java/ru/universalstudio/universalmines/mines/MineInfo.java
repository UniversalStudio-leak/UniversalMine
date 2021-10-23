package ru.universalstudio.universalmines.mines;

import org.bukkit.Location;
import org.bukkit.World;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class MineInfo {

  private String name;
  private Location min;
  private Location max;
  private World world;
  
  public MineInfo(String name, Location min, Location max, World world) {
    this.name = name;
    this.min = min;
    this.max = max;
    this.world = world;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Location getMin() {
    return this.min;
  }
  
  public Location getMax() {
    return this.max;
  }
  
  public World getWorld() {
    return this.world;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setMin(Location min) {
    this.min = min;
  }
  
  public void setMax(Location max) {
    this.max = max;
  }
  
  public void setWorld(World world) {
    this.world = world;
  }
}
