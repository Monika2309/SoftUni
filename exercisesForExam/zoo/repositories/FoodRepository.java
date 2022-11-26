package exercisesForExam.goldDigger.zoo.repositories;

import exercisesForExam.goldDigger.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
