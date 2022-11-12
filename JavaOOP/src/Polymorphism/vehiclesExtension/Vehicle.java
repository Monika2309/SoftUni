package vehiclesExtension;

public interface Vehicle {
    String driveWithAC(double km);
    String drive(double km);
    void refuel(double fuel);
    boolean canFitFuel(double fuel);

}
