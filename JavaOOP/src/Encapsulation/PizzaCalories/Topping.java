package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }
    public double calculateCalories(){
        return 2*weight*getModifier();
    }
    private double getModifier(){
        switch (toppingType){
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }

    private void setToppingType(String toppingType) {
        switch (toppingType){
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight<1 || weight>50){
            throw new IllegalArgumentException(toppingType+" weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
