package vehicles;

import java.text.DecimalFormat;

public class Car implements Vehicle {
    private double fuelQuantity;
    private double liters;

    public Car(double fuelQuantity, double liters) {
        this.fuelQuantity = fuelQuantity;
        setLiters(liters);
    }

    @Override
    public String driveWithAC(double km) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (fuelQuantity < (liters + 0.9) * km) {
            return "Car needs refueling";
        }else {
            fuelQuantity=fuelQuantity - (liters + 0.9) * km;
            return String.format("%s travelled %s km",getClass().getSimpleName(),df.format(km));
        }
    }

    @Override
    public String drive(double km) {
        if (fuelQuantity < liters * km) {
            return "Car needs refueling";
        }else {
            fuelQuantity=fuelQuantity-liters * km;
            return "Car travelled " + km + " km";
        }
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f",fuelQuantity);
    }

    @Override
    public void refuel(double fuel) {
        fuelQuantity=fuelQuantity+fuel;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }
}
