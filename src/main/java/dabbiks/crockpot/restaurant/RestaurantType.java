package dabbiks.crockpot.restaurant;

public enum RestaurantType {
    ICE_CREAM(1),
    HOT_DOG(2),
    PIZZA(4);

    private final int maxPlayers;

    RestaurantType(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}
