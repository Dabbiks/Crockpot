package dabbiks.crockpot.player.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataJson {

    private final Gson gson;
    private final File dataFolder;

    public PlayerDataJson() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        dataFolder = new File(plugin.getDataFolder(), "player-data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
    }

    public PersistentData loadPlayerData(UUID playerId) {
        File file = new File(dataFolder, playerId.toString() + ".json");
        if (!file.exists()) return null;

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, PersistentData.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void savePlayerData(PersistentData persistentData) {
        File file = new File(dataFolder, persistentData.getUUID().toString() + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(persistentData, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
