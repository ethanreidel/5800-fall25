package part3.core;

public class CargoShip extends Ship{
    private int capacity;

    public CargoShip(int capacity, String ship_name, String year_built) {
        super(ship_name, year_built);
        this.capacity = capacity;
    }

    public void set_tonnage(int capacity) {this.capacity = capacity;}

    public int get_tonnage() {return this.capacity;}

    @Override
    public String toString() {
        return String.format("Ship name: %s, capacity: %d tons", get_ship_name(), capacity);
    }
}
