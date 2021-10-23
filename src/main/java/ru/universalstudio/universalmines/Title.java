package ru.universalstudio.universalmines;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @Author source code: NaulbiMIX
 * @Author plugin code: UniversalStudio
 */

public class Title {
  public static void sendTitle(Player player, String s) {
    sendTitle(player, s, 15, 60, 15);
  }

  public static void sendTitle(Player player, String s, int n, int n2, int n3) {
    s = ChatColor.translateAlternateColorCodes('&', s);
    String[] args = s.split("%nl%");

    try {
      String title = args[0];
      sendPacket(player, (Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
              .getConstructor((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                      .getDeclaredClasses()[0], getNMS("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE)
              .newInstance((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                      .getDeclaredClasses()[0].getField("TIMES").get(null), (Objects.requireNonNull(getNMS("IChatBaseComponent")))
                      .getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}"), n, n2, n3));
      sendPacket(player, (Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
              .getConstructor((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                      .getDeclaredClasses()[0], getNMS("IChatBaseComponent"))
              .newInstance((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                      .getDeclaredClasses()[0].getField("TITLE").get(null), (Objects.requireNonNull(getNMS("IChatBaseComponent")))
                      .getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}")));
      if (args.length == 2) {
        String subtitle = args[1];
        sendPacket(player, (Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                .getConstructor((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                        .getDeclaredClasses()[0], getNMS("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE)
                .newInstance((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                        .getDeclaredClasses()[0].getField("TIMES").get(null), (Objects.requireNonNull(getNMS("IChatBaseComponent")))
                        .getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + subtitle + "\"}"), n, n2, n3));
        sendPacket(player, (Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                .getConstructor((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                        .getDeclaredClasses()[0], getNMS("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE)
                .newInstance((Objects.requireNonNull(getNMS("PacketPlayOutTitle")))
                        .getDeclaredClasses()[0].getField("SUBTITLE").get(null), (Objects.requireNonNull(getNMS("IChatBaseComponent")))
                        .getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + subtitle + "\"}"), n, n2, n3));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void sendPacket(Player player, Object o) {
    try {
      Object invoke = player.getClass().getMethod("getHandle").invoke(player);
      Object value = invoke.getClass().getField("playerConnection").get(invoke);
      value.getClass().getMethod("sendPacket", getNMS("Packet")).invoke(value, o);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private static Class<?> getNMS(String NMS) {
    String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
      return Class.forName("net.minecraft.server." + version + "." + NMS);
    }
    catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }

}
