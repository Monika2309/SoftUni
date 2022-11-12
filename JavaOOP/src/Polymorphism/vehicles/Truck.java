package vehicles;

import java.text.DecimalFormat;

public class Truck implements Vehicle {
    private double fuelQuantity;
    private double liters;

    public Truck(double fuelQuantity, double liters) {
        this.fuelQuantity = fuelQuantity;
        setLiters(liters);
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    @Override
    public String driveWithAC(double km) {
        DecimalFormat df = new DecimalFormat("##.##");

        if (fuelQuantity < (liters + 1.6) * km) {
            return "Truck needs refueling";
        } else {
            fuelQuantity = fuelQuantity - (liters + 1.6) * km;
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(km));
        }
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", fuelQuantity);
    }

    @Override
    public String drive(double km) {
        if (fuelQuantity < liters * km) {
            return "Truck needs refueling";
        } else {
            fuelQuantity = fuelQuantity - liters * km;
            return "Truck travelled " + km + " km";
        }
    }

    @Override
    public void refuel(double fuel) {
        fuelQuantity = fuelQuantity + fuel * 0.95;
    }
}
