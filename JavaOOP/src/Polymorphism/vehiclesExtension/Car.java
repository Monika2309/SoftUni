package vehiclesExtension;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double liters, double tankCapacity) {
        super(fuelQuantity, liters, tankCapacity);
    }

    @Override
    public String driveWithAC(double km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (super.getFuelQuantity() < (super.getLiters() + 0.9) * km) {
            return "Car needs refueling";
        } else {
            setFuelQuantity( super.getFuelQuantity() - (super.getLiters() + 0.9) * km);
            return String.format("Car travelled %s km", df.format(km));
        }
    }
    @Override
    public void refuel(double fuel) {
        setFuelQuantity(super.getFuelQuantity() + fuel);
    }

}
