package dabbiks.crockpot.player.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dabbiks.crockpot.Crockpot;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataJson {

    private final Gson gson;
    private final File dataFolder;

    public PlayerDataJson(Plugin plugin) {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        dataFolder = new File(plugin.getDataFolder(), "player-data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
    }

    public PlayerData loadPlayerData(UUID playerId) {
        File file = new File(dataFolder, playerId.toString() + ".json");
        if (!file.exists()) return null;

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, PlayerData.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void savePlayerData(PlayerData persistentData) {
        File file = new File(dataFolder, persistentData.getUUID().toString() + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(persistentData, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
