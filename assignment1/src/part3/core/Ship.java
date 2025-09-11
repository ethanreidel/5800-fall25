package src.part3.core;

public class Ship {
    private String ship_name;
    private String year_built;
    
    public Ship(String ship_name, String year_built) {
        this.ship_name = ship_name;
        this.year_built = year_built;
    }
    public void set_ship_name(String ship_name) {this.ship_name = ship_name;}
    public void set_year_built(String year_built) {this.year_built = year_built;}

    public String get_ship_name() {return this.ship_name;}
    public String get_year_built() {return this.year_built;}

    @Override
    public String toString() {
        return String.format("Ship name: %s, Year built: %s", ship_name, year_built);
    }
}
