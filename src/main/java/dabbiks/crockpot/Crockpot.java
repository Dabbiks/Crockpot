package dabbiks.crockpot;

import dabbiks.crockpot.managers.world.WorldGridManager;
import dabbiks.crockpot.restaurant.furniture.FurnitureLoader;
import dabbiks.crockpot.restaurant.furniture.FurnitureManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crockpot extends JavaPlugin {

    private final Crockpot plugin = this;
    private FurnitureManager furnitureManager;
    private FurnitureLoader furnitureLoader;
    private WorldGridManager worldGridManager;

    @Override
    public void onEnable() {
        furnitureManager = new FurnitureManager();
        worldGridManager = new WorldGridManager();
        new FurnitureLoader(plugin, furnitureManager);
    }

    @Override
    public void onDisable() {}

    public WorldGridManager getWorldGridManager() {
        return worldGridManager;
    }
}
