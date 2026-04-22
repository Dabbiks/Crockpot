package dabbiks.crockpot.managers.particle;

import org.bukkit.entity.TextDisplay;
import org.bukkit.util.Transformation;
import org.joml.Vector3f;

public final class ActiveTextParticle {

    private final TextDisplay display;
    private final MovementHandler handler;
    private final float speed;
    private final int duration;
    private int currentTick;

    public ActiveTextParticle(TextDisplay display, MovementHandler handler, float speed, int duration) {
        this.display = display;
        this.handler = handler;
        this.speed = speed;
        this.duration = duration;
        this.currentTick = 0;
    }

    public boolean tick() {
        if (!display.isValid()) return false;

        if (currentTick < duration) {
            display.setInterpolationDelay(0);
            display.setInterpolationDuration(1);
            handler.update(display, currentTick, speed);
        } else if (currentTick == duration) {
            display.setInterpolationDelay(0);
            display.setInterpolationDuration(5);
            Transformation t = display.getTransformation();
            display.setTransformation(new Transformation(
                    t.getTranslation(),
                    t.getLeftRotation(),
                    new Vector3f(0, 0, 0),
                    t.getRightRotation()
            ));
        } else if (currentTick >= duration + 5) {
            display.remove();
            return false;
        }

        currentTick++;
        return true;
    }
}
