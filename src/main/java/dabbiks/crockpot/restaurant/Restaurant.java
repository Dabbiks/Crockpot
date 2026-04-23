package dabbiks.crockpot.restaurant;

import dabbiks.crockpot.restaurant.furniture.FurnitureLoader;
import dabbiks.crockpot.restaurant.furniture.PlacedFurniture;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final RestaurantType restaurantType;
    private final List<PlacedFurniture> furniture;

    public Restaurant (RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
        this.furniture = new ArrayList<>();
    }

    public boolean generateMap() {
        return true;
    }

    public boolean generateFurniture() {
        return true;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }
}
