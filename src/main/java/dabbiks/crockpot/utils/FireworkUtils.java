package dabbiks.crockpot.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public final class FireworkUtils {

    private FireworkUtils() {}

    public static void spawn(Location loc, FireworkEffect.Type type, Color color, Color fade, boolean flicker, boolean trail, int power) {
        if (loc.getWorld() == null) return;
        loc.getWorld().spawn(loc, Firework.class, fw -> {
            FireworkMeta meta = fw.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder()
                    .with(type)
                    .withColor(color)
                    .withFade(fade)
                    .flicker(flicker)
                    .trail(trail)
                    .build());
            meta.setPower(power);
            fw.setFireworkMeta(meta);
        });
    }

    public static void spawnQuick(Location loc, Color color) {
        spawn(loc, FireworkEffect.Type.BALL, color, Color.WHITE, false, false, 1);
    }

    public static void spawnStar(Location loc, Color color, Color fade) {
        spawn(loc, FireworkEffect.Type.STAR, color, fade, true, true, 1);
    }

    public static void spawnCreeper(Location loc, Color color) {
        spawn(loc, FireworkEffect.Type.CREEPER, color, Color.BLACK, false, true, 1);
    }

    public static void spawnBurst(Location loc, Color color) {
        spawn(loc, FireworkEffect.Type.BURST, color, Color.GRAY, true, false, 1);
    }

    public static void spawnFlicker(Location loc, Color color, Color fade) {
        spawn(loc, FireworkEffect.Type.BALL, color, fade, true, false, 1);
    }

    public static void spawnTrail(Location loc, Color color) {
        spawn(loc, FireworkEffect.Type.BALL_LARGE, color, color, false, true, 2);
    }

    public static void instantExplode(Location loc, Color color, FireworkEffect.Type type) {
        if (loc.getWorld() == null) return;
        loc.getWorld().spawn(loc, Firework.class, fw -> {
            FireworkMeta meta = fw.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder()
                    .with(type)
                    .withColor(color)
                    .flicker(true)
                    .build());
            fw.setFireworkMeta(meta);
            fw.detonate();
        });
    }

    public static void instantExplodeQuick(Location loc, Color color) {
        instantExplode(loc, color, FireworkEffect.Type.BALL_LARGE);
    }
}