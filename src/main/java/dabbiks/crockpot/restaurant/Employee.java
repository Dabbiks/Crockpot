package dabbiks.crockpot.restaurant;

import java.util.UUID;

public class Employee {

    private final UUID uuid;

    public Employee(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
