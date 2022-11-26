package exercisesForExam.goldDigger.zoo.entities.areas;

import exercisesForExam.goldDigger.zoo.entities.animals.Animal;
import exercisesForExam.goldDigger.zoo.entities.foods.Food;

import java.util.Collection;

public interface Area {
    String getName();

    Collection<Animal> getAnimals();

    int getCapacity();

    Collection<Food> getFoods();

    int sumCalories();

    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

    void addFood(Food food);

    void feed();

    String getInfo();

}
