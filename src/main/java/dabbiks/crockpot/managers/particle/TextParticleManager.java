package dabbiks.crockpot.managers.particle;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.TextDisplay;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public final class TextParticleManager {

    private final Set<ActiveTextParticle> particles = ConcurrentHashMap.newKeySet();

    public TextParticleManager(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimer(plugin, this::tickParticles, 0L, 1L);
    }

    public void spawn(Location location, Collection<String> characters, MovementStyle style, float speed, int durationTicks) {
        if (characters == null || characters.isEmpty() || location.getWorld() == null) return;

        String[] charArray = characters.toArray(new String[0]);
        String selected = charArray[ThreadLocalRandom.current().nextInt(charArray.length)];

        TextDisplay display = location.getWorld().spawn(location, TextDisplay.class, entity -> {
            entity.setText(selected);
            entity.setBillboard(Display.Billboard.CENTER);
            entity.setDefaultBackground(false);
            entity.setBackgroundColor(Color.fromARGB(0, 0, 0, 0));
        });

        particles.add(new ActiveTextParticle(display, style.createHandler(), speed, durationTicks));
    }

    private void tickParticles() {
        Iterator<ActiveTextParticle> iterator = particles.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().tick()) {
                iterator.remove();
            }
        }
    }
}