package exercisesForExam.goldDigger.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.50, price);
    }

    @Override
    public void eat() {
        super.setKg(super.getKg() + 7.50);
    }
}
