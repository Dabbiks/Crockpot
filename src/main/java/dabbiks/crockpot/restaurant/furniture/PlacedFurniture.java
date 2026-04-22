package dabbiks.crockpot.restaurant.furniture;

import dabbiks.crockpot.restaurant.RestaurantType;

public class PlacedFurniture {

    private final FurnitureDefinition definition;
    private final RestaurantType restaurantType;
    private int rotation;

    public PlacedFurniture(FurnitureDefinition definition, RestaurantType restaurantType, int rotation) {
        this.definition = definition;
        this.restaurantType = restaurantType;
        this.rotation = rotation;
    }

}
