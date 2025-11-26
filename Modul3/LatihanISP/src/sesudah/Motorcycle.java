package sesudah;

public class Motorcycle implements VehicleInterface {
    @Override
    public void drive() {
        System.out.println("driving");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public void refuel() {
        System.out.println("refueling");
    }
}
