package dabbiks.crockpot.restaurant.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dabbiks.crockpot.Crockpot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class RestaurantDataLoader {

    private final Gson gson;
    private final File dataFolder;

    public RestaurantDataLoader(Crockpot plugin) {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        dataFolder = new File(plugin.getDataFolder() + "/saves");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
    }

    public RestaurantData loadRestaurantData(UUID uuid, int id) {

        File file = new File(dataFolder + "/" + uuid);
        if (!file.exists()) file.mkdirs();

        file = new File(dataFolder, id + ".json");
        if (!file.exists()) return null;

        try (FileReader reader = new FileReader(file)) {
            RestaurantData restaurantData = gson.fromJson(reader, RestaurantData.class);
            restaurantData.setOwner(uuid);
            return restaurantData;

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void saveRestaurantData(RestaurantData restaurantData) {
        File file = new File(dataFolder, restaurantData.getOwner().toString() + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(restaurantData, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
