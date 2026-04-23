package dabbiks.crockpot.restaurant.tasks;

import dabbiks.crockpot.Crockpot;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager extends BukkitRunnable {

    private final Crockpot plugin;
    private final List<Task> executors = new CopyOnWriteArrayList<>();

    public TaskManager(Crockpot plugin) {
        this.plugin = plugin;
        runTaskTimer(plugin, 0, 1);
    }

    public void addTask(Task task) {
        executors.add(task);
    }
    public void removeTask(Task task) {
        executors.remove(task);
    }

    @Override
    public void run() {
        for (Task task : executors) {
            if (Bukkit.getCurrentTick() % task.getPeriod() != 0) continue;
            task.tick();
        }
    }
}
