package InterfacesAndAbstraction.CarShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model,color,horsePower,countryProduced);
        this.price=price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(super.toString());
        sb.append(System.lineSeparator()).append(String.format("%s sells for %f",getModel(),getPrice()));
        return sb.toString();
    }
    @Override
    public Double getPrice() {
        return price;
    }
}
