package sesudah;

public class Motorcycle implements VehicleInterface {
    @Override
    public void drive() {
        System.out.println("Driving motorcycle");
    }

    @Override
    public void stop() {
        System.out.println("Stopping motorcycle");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling motorcycle");
    }
}
