package ru.universalstudio.universalmines.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.universalstudio.universalmines.Checks;
import ru.universalstudio.universalmines.mines.Mines;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class MoveListener implements Listener {

  @EventHandler
  public void onMove(PlayerMoveEvent e) {
    if (Mines.getMine(e.getPlayer().getLocation())) {
      Checks.check(e.getPlayer());
    }
  }

}
