package vehiclesExtension;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double liters;
    private double tankCapacity;

    protected VehicleImpl(double fuelQuantity, double liters, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.liters = liters;
        this.tankCapacity = tankCapacity;
    }
    @Override
    public String drive(double km) {
        if (fuelQuantity < liters * km) {
            return getClass().getSimpleName() + " needs refueling";
        } else {
            fuelQuantity = fuelQuantity - liters * km;
            return getClass().getSimpleName() + " travelled " + km + " km";
        }
    }
    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName() , fuelQuantity);
    }
    @Override
    public boolean canFitFuel(double fuel){
        if (tankCapacity<=fuel+fuelQuantity){
            return false;
        }
        return true;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLiters() {
        return liters;
    }
    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

}
