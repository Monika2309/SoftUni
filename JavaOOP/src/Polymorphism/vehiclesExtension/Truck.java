package vehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {
    public Truck(double fuelQuantity, double liters, double tankCapacity) {
        super(fuelQuantity, liters, tankCapacity);
    }

    @Override
    public String driveWithAC(double km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (super.getFuelQuantity() < (super.getLiters() + 1.6) * km) {
            return "Truck needs refueling";
        } else {
            setFuelQuantity( super.getFuelQuantity() - (super.getLiters() + 1.6) * km);
            return String.format("Truck travelled %s km", df.format(km));
        }
    }
    @Override
    public void refuel(double fuel) {
        setFuelQuantity(super.getFuelQuantity() + fuel * 0.95);
    }
}
