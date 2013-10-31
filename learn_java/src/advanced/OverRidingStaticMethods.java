package advanced;

/**
 *
 * http://blog.sanaulla.info/2008/02/29/overriding-vs-hiding/
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 8/10/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class OverRidingStaticMethods {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle carVehicle = new Car();
        vehicle.drive();
        vehicle.clean();
        carVehicle.drive();
        carVehicle.clean();
    }
}


class Vehicle {
    public void drive() {
        System.out.println("Driving vehicle ...");
    }

    public static void clean() {
        System.out.println("Cleaning vehicle...");
    }

}

class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving car...");
    }

    public static void clean() {
        System.out.println("Cleaning car...");
    }
}
