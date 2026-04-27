package dabbiks.crockpot.managers.world;

import org.bukkit.Bukkit;

public class WorldGridManager {

    private final int gridSize = 5;
    private final boolean[][] grid = new boolean[gridSize][gridSize];

    public GridLocation claimLocation() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (!grid[row][col]) {
                    grid[row][col] = true;
                    return new GridLocation(row, col);
                }
            }
        }
        Bukkit.getLogger().severe("[RESTAURANT] Failed to find empty grid location");
        return null;
    }

    public void releaseLocation(GridLocation location) {
        if (location == null) return;
        int row = location.row();
        int col = location.col();
        if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
            grid[row][col] = false;
        }
    }
}