package dabbiks.crockpot.restaurant.tasks;

public abstract class Task {

    protected Task() {
    }

    protected long getPeriod() {
        return 1;
    }

    protected void tick() {
    }

}
