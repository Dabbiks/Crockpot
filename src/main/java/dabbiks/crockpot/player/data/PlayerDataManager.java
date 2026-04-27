package dabbiks.crockpot.player.data;

import dabbiks.crockpot.Crockpot;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerDataManager {

    private static final Map<UUID, PlayerData> dataMap = new ConcurrentHashMap<>();
    private final Crockpot plugin;

    public PlayerDataManager(Crockpot plugin) {
        this.plugin = plugin;
    }

    @Nullable
    public static PlayerData getData(UUID uuid) {
        return dataMap.get(uuid);
    }

    public CompletableFuture<PlayerData> loadDataAsync(UUID uuid, String playerName) {
        return CompletableFuture.supplyAsync(() -> {
            PlayerData persistentData = plugin.getPlayerDataJson().loadPlayerData(uuid);

            if (persistentData == null) {
                persistentData = new PlayerData();
            }

            persistentData.setUUID(uuid);
            persistentData.setName(playerName != null ? playerName : "Unknown");

            dataMap.put(uuid, persistentData);
            return persistentData;
        });
    }

    public static void delData(UUID uuid) {
        dataMap.remove(uuid);
    }

    public void saveDataAsync(UUID uuid) {
        PlayerData persistentData = getData(uuid);
        if (persistentData != null) {
            CompletableFuture.runAsync(() -> plugin.getPlayerDataJson().savePlayerData(persistentData));
        }
    }
}