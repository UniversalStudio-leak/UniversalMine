package ru.universalstudio.universalmines.mines;

import java.text.DecimalFormat;
import org.bukkit.Material;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class MineBlock {

  private Material block;
  private double money;
  private int update;
  private String prefix;
  
  public MineBlock(Material block, double money, int update, String prefix) {
    this.block = block;
    this.money = money;
    this.update = update;
    this.prefix = prefix;
  }
  
  public Material getBlock() {
    return this.block;
  }
  
  public double getMoney() {
    return this.money;
  }
  
  public int getUpdate() {
    return this.update;
  }
  
  public String getPrefix() {
    return this.prefix;
  }
  
  public String getMoneyFormat() {
    return (new DecimalFormat("#0.00")).format(getMoney());
  }
  
  public void setBlock(Material block) {
    this.block = block;
  }
  
  public void setMoney(double money) {
    this.money = money;
  }
  
  public void setUpdate(int update) {
    this.update = update;
  }
  
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
}
