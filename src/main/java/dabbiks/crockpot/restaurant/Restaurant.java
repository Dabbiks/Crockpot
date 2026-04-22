package dabbiks.crockpot.restaurant;

import dabbiks.crockpot.restaurant.furniture.Furniture;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final RestaurantType restaurantType;
    private final List<Furniture> furniture;

    public Restaurant (RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
        this.furniture = new ArrayList<>();
    }



}
