package InterfacesAndAbstraction.CarShop;

public class Seat implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format(
                "%s is %s color and have %s horse power" +
                        "%nThis is %s produced in Spain and have %d tires", model, color, horsePower,model,Car.TIRES);

    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }
}
