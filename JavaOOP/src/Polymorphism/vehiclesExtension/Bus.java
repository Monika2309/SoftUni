package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl{
    public Bus(double fuelQuantity, double liters, double tankCapacity) {
        super(fuelQuantity, liters, tankCapacity);
    }

    @Override
    public String driveWithAC(double km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (super.getFuelQuantity()< (super.getLiters() + 1.4) * km) {
            return "Bus needs refueling";
        }else {
            super.setFuelQuantity(super.getFuelQuantity() - (super.getLiters() + 1.4) * km);
            return String.format("Bus travelled %s km", df.format(km));
        }
    }

    @Override
    public void refuel(double fuel) {
        setFuelQuantity(super.getFuelQuantity() + fuel);
    }
}
