package exercisesForExam.goldDigger.zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, 5.50, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 5.70);
    }
}
