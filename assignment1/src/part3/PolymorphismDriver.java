package part3;

import part3.core.CargoShip;
import part3.core.CruiseShip;
import part3.core.Ship;

public class PolymorphismDriver {
    static Ship[] ship_arr = new Ship[3];
    public static void main(String[] args) {
        PolymorphismDriver.ship_arr[0] = new Ship("Ethan's Ship", "2001");
        PolymorphismDriver.ship_arr[1] = new CruiseShip(10, "Titantic", "1912");
        PolymorphismDriver.ship_arr[2] = new CargoShip(50000, "Titantic V2", "1913");

        for (Ship ship: PolymorphismDriver.ship_arr) {
            System.out.println(ship);
        }
    }
}
