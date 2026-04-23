package dabbiks.crockpot.restaurant.furniture;

import com.google.gson.Gson;
import dabbiks.crockpot.Crockpot;

import java.io.File;
import java.io.FileReader;

public class FurnitureLoader {

    private final FurnitureManager manager;
    private final Crockpot plugin;
    public FurnitureLoader(Crockpot plugin, FurnitureManager manager) {
        this.manager = manager;
        this.plugin = plugin;
    }

    public void loadFurniture() {
        File folder = new File(plugin.getDataFolder(), "/furniture");
        if (!folder.exists()) folder.mkdirs();
        scanAndLoad(folder, new Gson());
    }

    private void scanAndLoad(File folder, Gson gson) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanAndLoad(file, gson);
                continue;
            }

            if (!file.getName().endsWith(".json")) continue;

            try (FileReader reader = new FileReader(file)) {
                FurnitureDefinition definition = gson.fromJson(reader, FurnitureDefinition.class);

                File schematic = new File(plugin.getDataFolder() + "/furniture", definition.getSchematic() + ".schem");
                if (!schematic.exists()) {
                    System.err.println("[FURNITURE] Error while loading schematic '" + file.getAbsolutePath() + "'");
                }

                if (definition.getId() != null) {
                    manager.registerFurniture(definition);
                }
            } catch (Exception e) {
                System.err.println("[FURNITURE] Error while reading file '" + file.getAbsolutePath() + "'");
                e.printStackTrace();
            }
        }
    }
}
