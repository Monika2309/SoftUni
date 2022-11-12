package Polymorphism.Animals;

public class Cat extends Animal{

    private String name;
    private String favouriteFood;

    public Cat(String name, String favouriteFood) {
        super(name,favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.explainSelf())
                .append(System.lineSeparator())
                .append("MEOW");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
