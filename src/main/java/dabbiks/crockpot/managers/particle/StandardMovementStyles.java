package dabbiks.crockpot.managers.particle;

import org.bukkit.entity.TextDisplay;
import org.bukkit.util.Transformation;
import org.joml.Vector3f;

public enum StandardMovementStyles implements MovementStyle {

    STATIONARY {
        @Override
        public MovementHandler createHandler() {
            return (display, tick, speed) -> {};
        }
    },

    UP {
        @Override
        public MovementHandler createHandler() {
            return (display, tick, speed) -> {
                Transformation t = display.getTransformation();
                t.getTranslation().add(0, speed, 0);
                display.setTransformation(t);
            };
        }
    },

    DOWN {
        @Override
        public MovementHandler createHandler() {
            return (display, tick, speed) -> {
                Transformation t = display.getTransformation();
                t.getTranslation().add(0, -speed, 0);
                display.setTransformation(t);
            };
        }
    },

    RANDOM {
        @Override
        public MovementHandler createHandler() {
            return new MovementHandler() {
                private final Vector3f direction = new Vector3f(
                        (float) Math.random() - 0.5f,
                        (float) Math.random() - 0.5f,
                        (float) Math.random() - 0.5f
                ).normalize();

                @Override
                public void update(TextDisplay display, int tick, float speed) {
                    Transformation t = display.getTransformation();
                    t.getTranslation().add(direction.x * speed, direction.y * speed, direction.z * speed);
                    display.setTransformation(t);
                }
            };
        }
    },

    CLOUD_SWAY {
        @Override
        public MovementHandler createHandler() {
            return new MovementHandler() {
                private final float offset = (float) (Math.random() * Math.PI * 2);

                @Override
                public void update(TextDisplay display, int tick, float speed) {
                    Transformation t = display.getTransformation();
                    float sway = (float) Math.sin(tick * 0.15f + offset) * speed * 2f;
                    t.getTranslation().set(sway, t.getTranslation().y, t.getTranslation().z);
                    display.setTransformation(t);
                }
            };
        }
    }
}