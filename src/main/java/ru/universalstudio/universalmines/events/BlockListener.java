package ru.universalstudio.universalmines.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import ru.universalstudio.universalmines.Money;
import ru.universalstudio.universalmines.Utils;
import ru.universalstudio.universalmines.mines.MineBlock;
import ru.universalstudio.universalmines.mines.MineManager;
import ru.universalstudio.universalmines.mines.MinePlayer;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class BlockListener implements Listener {

  @EventHandler
  public void onBreak(BlockBreakEvent e) {
    if (Mines.getMine(e.getBlock().getLocation())) {
      Player p = e.getPlayer();
      if (MineManager.getBlock(e.getBlock().getLocation()) != null && e.getBlock().getType() == Material.getMaterial(Utils.getConfig().getString("setblock").toUpperCase())) {
        e.setCancelled(true);
      } else if (Mines.getBlock(e.getBlock().getType()) == null) {
        if (!e.getPlayer().hasPermission("umine.breakblocks") && Utils.getConfig().getBoolean("block-break.enable")) {
          Utils.sendMessage(p, Utils.getConfig().getString("block-break.message"));
          e.setCancelled(true);
        }

      } else {
        if (Utils.getConfig().getBoolean("resoures.straight")) {
          e.getBlock().getDrops().clear();
        }

        e.setDropItems(Utils.getConfig().getBoolean("resoures.drop"));
        if (!Utils.getConfig().getBoolean("exp")) {
          e.setExpToDrop(0);
        }

        MineBlock block = Mines.getBlock(e.getBlock().getType());
        Utils.sendMessage(p, Utils.getMessage("block.complete")
                .replace("%salary%", block.getMoneyFormat())
                .replace("%block%", block.getPrefix())
        );
        Money.addSalary(p, block.getMoney());
        MineManager.addBlock(e.getBlock().getLocation(), block);
        MinePlayer.add(p, block.getBlock().name().toLowerCase(), 1);
      }
    }
  }

  @EventHandler
  public void onPlace(BlockPlaceEvent e) {
    if (!e.getPlayer().hasPermission("umine.placeblocks") &&
            Utils.getConfig().getBoolean("block-place.enable") &&
            Mines.getMine(e.getBlock().getLocation())) {
      Utils.sendMessage(e.getPlayer(), Utils.getConfig().getString("block-place.message"));
      e.setCancelled(true);
    }
  }

}
