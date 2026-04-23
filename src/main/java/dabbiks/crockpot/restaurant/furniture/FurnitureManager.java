package dabbiks.crockpot.restaurant.furniture;

import java.util.HashMap;
import java.util.Map;

public class FurnitureManager {

    private final Map<String, FurnitureDefinition> iceCreamFurniture = new HashMap<>();
    private final Map<String, FurnitureDefinition> hotDogFurniture = new HashMap<>();
    private final Map<String, FurnitureDefinition> pizzaFurniture = new HashMap<>();

    public void registerFurniture(FurnitureDefinition definition) {
        String id = definition.getId();

        switch (definition.getRestaurantType()) {
            case ICE_CREAM -> iceCreamFurniture.put(id, definition);
            case HOT_DOG -> hotDogFurniture.put(id, definition);
            case PIZZA -> pizzaFurniture.put(id, definition);
        }
    }

    public Map<String, FurnitureDefinition> getIceCreamFurniture() {
        return iceCreamFurniture;
    }

    public Map<String, FurnitureDefinition> getHotDogFurniture() {
        return hotDogFurniture;
    }

    public Map<String, FurnitureDefinition> getPizzaFurniture() {
        return pizzaFurniture;
    }
}
