package exercisesForExam.goldDigger.zoo.entities.areas;

import exercisesForExam.goldDigger.zoo.entities.animals.Animal;
import exercisesForExam.goldDigger.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;


    public BaseArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() == capacity) {
            throw new IllegalStateException("Not enough capacity.");
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s (%s):", getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        stringBuilder.append("Animals: ");
        if (this.animals.isEmpty()) {
            stringBuilder.append("none");
        }else {
            stringBuilder.append(this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")));
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Foods: ").append(foods.size()).append(System.lineSeparator());
        stringBuilder.append("Calories: ").append(sumCalories());

        return stringBuilder.toString().trim();
    }
    @Override
    public int getCapacity() {
        return capacity;
    }
}
