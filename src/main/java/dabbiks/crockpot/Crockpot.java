package dabbiks.crockpot;

import dabbiks.crockpot.restaurant.furniture.FurnitureLoader;
import dabbiks.crockpot.restaurant.furniture.FurnitureManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crockpot extends JavaPlugin {

    private final Crockpot plugin = this;
    private FurnitureManager furnitureManager;
    private FurnitureLoader furnitureLoader;

    @Override
    public void onEnable() {
        furnitureManager = new FurnitureManager();
        new FurnitureLoader(plugin, furnitureManager);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
