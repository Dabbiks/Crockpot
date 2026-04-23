package dabbiks.crockpot.restaurant.session;

import dabbiks.crockpot.restaurant.Restaurant;
import dabbiks.crockpot.restaurant.data.RestaurantData;

public class RestaurantSession {

    private final RestaurantData restaurantData;
    private RestaurantState restaurantState;

    public RestaurantSession(RestaurantData restaurantData) {
        this.restaurantData = restaurantData;
        setRestaurantState(RestaurantState.SETUP);
    }

    private boolean setup() {
        Restaurant restaurant = restaurantData.getRestaurant();
        if (!restaurant.generateMap()) {
            System.err.println("[RESTAURANT] Error while generating map for " + restaurantData.getOwner() + ", " + restaurant.getRestaurantType());
            return false;
        }
        if (!restaurant.generateFurniture()) {
            System.err.println("[RESTAURANT] Error while generating furniture for "  + restaurantData.getOwner() + ", " + restaurant.getRestaurantType());
        }
        setRestaurantState(RestaurantState.WAIT);
        return true;
    }

    public void setRestaurantState(RestaurantState restaurantState) { this.restaurantState = restaurantState; }
    public RestaurantState getRestaurantState() { return restaurantState; }
}
