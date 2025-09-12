package part3.core;

public class CruiseShip extends Ship{
    private int num_passengers;
    
    public CruiseShip(int num_passengers, String ship_name, String year_built) {
        super(ship_name, year_built);
        this.num_passengers = num_passengers;
    }

    public void set_num_passengers(int num_passengers) {this.num_passengers = num_passengers;}
    
    public int get_num_passengers() {return this.num_passengers;}

    @Override
    public String toString() {
        return String.format("Ship name: %s, number of passengers: %d", get_ship_name(), num_passengers);
    }

}
