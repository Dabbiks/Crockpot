package dabbiks.crockpot.player.data;

import com.google.gson.annotations.Expose;
import java.util.*;

public class PlayerData {

    @Expose private UUID uuid;
    @Expose private String name;

    @Expose private final Map<PlayerStats, Integer> stats = new HashMap<>();

    // * GETTERS, SETTERS

    public UUID getUUID() { return uuid; }
    public void setUUID(UUID uuid) { this.uuid = uuid; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Map<PlayerStats, Integer> getStats() { return stats; }
    public void addStats(PlayerStats stats, int value) { this.stats.merge(stats, value, Integer::sum); }
    public void setStats(PlayerStats stats, int number) { this.stats.put(stats, number); }
    public void removeStats(PlayerStats stats, int number) { this.stats.merge(stats, -number, Integer::sum); }

}