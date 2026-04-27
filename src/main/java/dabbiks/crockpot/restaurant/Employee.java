package dabbiks.crockpot.restaurant;

import com.google.gson.annotations.Expose;

import java.util.UUID;

public class Employee {

    @Expose private final UUID uuid;

    public Employee(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
