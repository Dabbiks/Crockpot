package dabbiks.crockpot.restaurant.session;

import dabbiks.crockpot.Crockpot;
import dabbiks.crockpot.managers.world.GridLocation;
import dabbiks.crockpot.restaurant.Restaurant;
import dabbiks.crockpot.restaurant.data.RestaurantData;
import dabbiks.crockpot.restaurant.tasks.TaskManager;

public class RestaurantSession {

    private final RestaurantData restaurantData;
    private final Crockpot plugin;
    private final TaskManager taskManager;

    private RestaurantState restaurantState;
    private GridLocation gridPosition;

    public RestaurantSession(RestaurantData restaurantData, Crockpot plugin) {
        this.restaurantData = restaurantData;
        this.plugin = plugin;
        this.taskManager = new TaskManager(plugin);
        setRestaurantState(RestaurantState.SETUP);
    }

    private boolean setup() {
        Restaurant restaurant = restaurantData.getRestaurant();
        gridPosition = plugin.getWorldGridManager().claimLocation();

        if (gridPosition == null) {
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
        if (gridPosition != null) {
            plugin.getWorldGridManager().releaseLocation(gridPosition);
        }
        return true;
    }

    public void setRestaurantState(RestaurantState restaurantState) {
        this.restaurantState = restaurantState;
    }

    public RestaurantState getRestaurantState() {
        return restaurantState;
    }
}