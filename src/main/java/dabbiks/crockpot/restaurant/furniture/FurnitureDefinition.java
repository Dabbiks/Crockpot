package dabbiks.crockpot.restaurant.furniture;

import dabbiks.crockpot.restaurant.RestaurantType;

public class FurnitureDefinition {

    private String id;
    private RestaurantType restaurantType;
    private String name;
    private String schematic;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public RestaurantType getRestaurantType() { return restaurantType; }
    public void setRestaurantType(RestaurantType restaurantType) { this.restaurantType = restaurantType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSchematic() { return schematic; }
    public void setSchematic(String schematic) { this.schematic = schematic; }
}
