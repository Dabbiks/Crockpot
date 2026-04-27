package dabbiks.crockpot.player.data;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerDataManager {

    private static final Map<UUID, PersistentData> dataMap = new ConcurrentHashMap<>();

    @Nullable
    public static PersistentData getData(UUID uuid) {
        return dataMap.get(uuid);
    }

    /**
     * Wczytuje dane asynchronicznie. Wywołuj w AsyncPlayerPreLoginEvent lub wywołując .thenAccept na zwracanym Future.
     */
    public static CompletableFuture<PersistentData> loadDataAsync(UUID uuid, String playerName) {
        return CompletableFuture.supplyAsync(() -> {
            PersistentData persistentData = Main.persistentDataJson.loadPlayerData(uuid);

            if (persistentData == null) {
                persistentData = new PersistentData();
            }

            // Zawsze upewnij się, że UUID i nazwa są aktualne
            persistentData.setUUID(uuid);
            persistentData.setName(playerName != null ? playerName : "Unknown");

            dataMap.put(uuid, persistentData);
            return persistentData;
        });
    }

    public static void delData(UUID uuid) {
        dataMap.remove(uuid);
    }

    /**
     * Zapisuje dane w osobnym wątku, nie obciążając serwera.
     */
    public static void saveDataAsync(UUID uuid) {
        PersistentData persistentData = getData(uuid);
        if (persistentData != null) {
            CompletableFuture.runAsync(() -> Main.persistentDataJson.savePlayerData(persistentData));
        }
    }
}