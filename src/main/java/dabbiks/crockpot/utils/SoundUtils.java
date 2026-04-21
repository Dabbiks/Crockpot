package dabbiks.crockpot.utils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class SoundUtils {

    private SoundUtils() {}

    public static void playSoundToPlayer(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public static void playSoundToPlayers(Iterable<? extends Player> players, Sound sound, float volume, float pitch) {
        for (Player player : players) {
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
    }

    public static void playSoundAtPlayer(Player player, Sound sound, float volume, float pitch) {
        player.getWorld().playSound(player.getLocation(), sound, volume, pitch);
    }

    public static void playSoundAtPlayers(Iterable<? extends Player> players, Sound sound, float volume, float pitch) {
        for (Player player : players) {
            player.getWorld().playSound(player.getLocation(), sound, volume, pitch);
        }
    }

    public static void playSoundAtLocation(Location location, Sound sound, float volume, float pitch) {
        if (location.getWorld() != null) {
            location.getWorld().playSound(location, sound, volume, pitch);
        }
    }
}