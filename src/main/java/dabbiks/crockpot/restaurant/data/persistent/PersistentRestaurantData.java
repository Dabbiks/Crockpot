package dabbiks.crockpot.restaurant.data.persistent;

import com.google.gson.annotations.Expose;
import dabbiks.crockpot.restaurant.Restaurant;

import java.util.UUID;

public class PersistentRestaurantData {

    @Expose private int gameId;
    @Expose private UUID owner;
    @Expose private Restaurant restaurant;

}
