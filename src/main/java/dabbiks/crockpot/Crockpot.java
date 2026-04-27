package dabbiks.crockpot;

import dabbiks.crockpot.managers.world.WorldGenerator;
import dabbiks.crockpot.managers.world.WorldGridManager;
import dabbiks.crockpot.player.data.PlayerDataJson;
import dabbiks.crockpot.player.data.PlayerDataManager;
import dabbiks.crockpot.restaurant.furniture.FurnitureLoader;
import dabbiks.crockpot.restaurant.furniture.FurnitureManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crockpot extends JavaPlugin {

    private final Crockpot plugin = this;
    private FurnitureManager furnitureManager;
    private FurnitureLoader furnitureLoader;
    private WorldGridManager worldGridManager;
    private PlayerDataJson playerDataJson;
    private PlayerDataManager playerDataManager;

    @Override
    public void onEnable() {
        furnitureManager = new FurnitureManager();
        worldGridManager = new WorldGridManager();
        playerDataJson = new PlayerDataJson(plugin);
        playerDataManager = new PlayerDataManager(plugin);

        new FurnitureLoader(plugin, furnitureManager);
        new WorldGenerator().generateWorlds();
    }

    @Override
    public void onDisable() {}

    public WorldGridManager getWorldGridManager() { return worldGridManager; }
    public PlayerDataJson getPlayerDataJson() { return playerDataJson; }
    public PlayerDataManager getPlayerDataManager() { return playerDataManager; }
}
