package Polymorphism.Animals;

public class Dog extends Animal{
    private String name;
    private String favouriteFood;

    public Dog(String name, String favouriteFood) {
        super(name,favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
         sb.append(super.explainSelf())
                 .append(System.lineSeparator())
                .append("DJAAF");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
