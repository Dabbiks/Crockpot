package dabbiks.crockpot.restaurant.session;

import dabbiks.crockpot.Crockpot;
import dabbiks.crockpot.managers.world.WorldGridManager;
import dabbiks.crockpot.restaurant.Restaurant;
import dabbiks.crockpot.restaurant.data.RestaurantData;
import org.bukkit.plugin.Plugin;

public class RestaurantSession {

    private final RestaurantData restaurantData;
    private RestaurantState restaurantState;
    private final Crockpot plugin;
    private int[] gridPosition;

    public RestaurantSession(RestaurantData restaurantData, Crockpot plugin) {
        this.restaurantData = restaurantData;
        this.plugin = plugin;
        setRestaurantState(RestaurantState.SETUP);
    }

    private boolean setup() {
        Restaurant restaurant = restaurantData.getRestaurant();
        gridPosition = plugin.getWorldGridManager().claimLocation();
        if (gridPosition.length < 2) {
            System.err.println("[RESTAURANT] Error while selecting empty grid space for " + restaurantData.getOwner() + ", " + restaurant.getRestaurantType());
            return false;
        }
        if (!restaurant.generateMap()) {
            System.err.println("[RESTAURANT] Error while generating map for " + restaurantData.getOwner() + ", " + restaurant.getRestaurantType());
            return false;
        }
        if (!restaurant.generateFurniture()) {
            System.err.println("[RESTAURANT] Error while generating furniture for "  + restaurantData.getOwner() + ", " + restaurant.getRestaurantType());
            return false;
        }
        setRestaurantState(RestaurantState.WAIT);
        return true;
    }

    private boolean stop() {
        plugin.getWorldGridManager().releaseLocation(gridPosition[0], gridPosition[1]);
        return true;
    }

    public void setRestaurantState(RestaurantState restaurantState) { this.restaurantState = restaurantState; }
    public RestaurantState getRestaurantState() { return restaurantState; }
}
