package dabbiks.crockpot.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;

import java.time.Duration;

public final class TitleUtils {

    private TitleUtils() {}

    public static void sendTitleToPlayer(Player player, Component top, Component bottom, int lasts) {
        player.showTitle(createTitle(top, bottom, lasts));
    }

    public static void sendTitleToPlayers(Iterable<? extends Player> players, Component top, Component bottom, int lasts) {
        Title title = createTitle(top, bottom, lasts);
        for (Player player : players) {
            player.showTitle(title);
        }
    }

    private static Title createTitle(Component top, Component bottom, int lasts) {
        Title.Times times = Title.Times.times(
                Duration.ZERO,
                Duration.ofMillis(lasts * 50L),
                Duration.ofMillis(150L)
        );

        return Title.title(
                top != null ? top : Component.empty(),
                bottom != null ? bottom : Component.empty(),
                times
        );
    }
}