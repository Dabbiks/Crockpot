package dabbiks.crockpot.restaurant.data;

import com.google.gson.annotations.Expose;
import dabbiks.crockpot.restaurant.Restaurant;

import java.util.UUID;

public class RestaurantData {

    @Expose private int id;
    @Expose private UUID owner;
    @Expose private Restaurant restaurant;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
