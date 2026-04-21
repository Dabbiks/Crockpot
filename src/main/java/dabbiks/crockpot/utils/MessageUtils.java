package dabbiks.crockpot.utils;

import org.bukkit.entity.Player;

public final class MessageUtils {

    private MessageUtils() {}

    public static void sendMessageToPlayer(Player player, String message) {
        player.sendMessage(message);
    }

    public static void sendMessageToPlayers(Iterable<? extends Player> players, String message) {
        for (Player player : players) {
            player.sendMessage(message);
        }
    }
}
