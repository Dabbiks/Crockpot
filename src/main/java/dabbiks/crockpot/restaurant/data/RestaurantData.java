package dabbiks.crockpot.restaurant.data;

import com.google.gson.annotations.Expose;
import dabbiks.crockpot.restaurant.Restaurant;
import dabbiks.crockpot.restaurant.Employee;

import java.util.List;
import java.util.UUID;

public class RestaurantData {

    @Expose private int id;
    @Expose private UUID owner;
    @Expose private List<Employee> employees;
    @Expose private Restaurant restaurant;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(UUID uuid) {
        if (restaurant.getRestaurantType().getMaxPlayers() <= employees.size()) {
            System.err.println("[MANAGEMENT] " + owner + " reached employee limit. Failed to hire new employee!");
            return false;
        }
        if (uuid.equals(owner)) {
            System.err.println("[MANAGEMENT]" + owner + " tried to hire himself.");
            return false;
        }
        Employee employee = new Employee(uuid);
        employees.add(employee);
        return true;
    }
}
