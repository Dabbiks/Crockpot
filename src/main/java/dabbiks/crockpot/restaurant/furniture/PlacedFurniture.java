package dabbiks.crockpot.restaurant.furniture;

import dabbiks.crockpot.restaurant.RestaurantType;
import dabbiks.crockpot.restaurant.furniture.types.FurnitureType;

public class PlacedFurniture<T extends FurnitureType> {

    private final FurnitureDefinition definition;
    private final RestaurantType restaurantType;
    private final T furnitureType;
    private int rotation;

    public PlacedFurniture(FurnitureDefinition definition, RestaurantType restaurantType, T furnitureType, int rotation) {
        this.definition = definition;
        this.restaurantType = restaurantType;
        this.furnitureType = furnitureType;
        this.rotation = rotation;
    }

    public FurnitureDefinition getDefinition() { return definition; }
    public RestaurantType getRestaurantType() { return restaurantType; }
    public T getFurnitureType() { return furnitureType; }

    public int getRotation() { return rotation; }
    public void setRotation(int rotation) { this.rotation = rotation; }
}
