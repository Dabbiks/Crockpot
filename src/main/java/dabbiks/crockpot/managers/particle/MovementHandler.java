package dabbiks.crockpot.managers.particle;

import org.bukkit.entity.TextDisplay;

public interface MovementHandler {
    void update(TextDisplay display, int tick, float speed);
}