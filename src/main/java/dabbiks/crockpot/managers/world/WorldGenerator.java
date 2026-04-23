package dabbiks.crockpot.managers.world;

import dabbiks.crockpot.constants.WorldData;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRules;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.SpawnCategory;
import org.bukkit.generator.ChunkGenerator;

public class WorldGenerator {

    public void generateWorlds() {
        createOptimizedVoidWorld(WorldData.LOBBY_WORLD);
        createOptimizedVoidWorld(WorldData.GRID_WORLD);
    }

    private void createOptimizedVoidWorld(String name) {
        if (Bukkit.getWorld(name) != null) {
            return;
        }

        WorldCreator creator = new WorldCreator(name);
        creator.generator(new ChunkGenerator() {});
        creator.generateStructures(false);

        World world = creator.createWorld();

        if (world != null) {
            world.setDifficulty(Difficulty.PEACEFUL);
            world.setAutoSave(false);
            world.setClearWeatherDuration(Integer.MAX_VALUE);

            for (SpawnCategory category : SpawnCategory.values()) {
                world.setSpawnLimit(category, 0);
            }

            world.setGameRule(GameRules.PVP, false);
            world.setGameRule(GameRules.ADVANCE_TIME, false);
            world.setGameRule(GameRules.ADVANCE_WEATHER, false);
            world.setGameRule(GameRules.SPAWN_MOBS, false);
            world.setGameRule(GameRules.MOB_GRIEFING, false);
            world.setGameRule(GameRules.SHOW_ADVANCEMENT_MESSAGES, false);
            world.setGameRule(GameRules.BLOCK_DROPS, false);
            world.setGameRule(GameRules.ENTITY_DROPS, false);
            world.setGameRule(GameRules.MOB_DROPS, false);
            world.setGameRule(GameRules.COMMAND_BLOCK_OUTPUT, false);
            world.setGameRule(GameRules.PLAYER_MOVEMENT_CHECK, false);
            world.setGameRule(GameRules.ELYTRA_MOVEMENT_CHECK, false);
            world.setGameRule(GameRules.RANDOM_TICK_SPEED, 0);
        }
    }
}