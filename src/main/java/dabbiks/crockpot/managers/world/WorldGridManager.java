package dabbiks.crockpot.managers.world;

import org.bukkit.Bukkit;

public class WorldGridManager {

    private final int gridSize = 5;
    private final boolean[][] grid = new boolean[gridSize][gridSize];

    public int[] claimLocation() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (!grid[row][col]) {
                    grid[row][col] = true;
                    return new int[]{row, col};
                }
            }
        }
        Bukkit.getLogger().severe("[RESTAURANT] Failed to find empty grid location");
        return new int[]{};
    }

    public void releaseLocation(int row, int col) {
        if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
            grid[row][col] = false;
        }
    }
}