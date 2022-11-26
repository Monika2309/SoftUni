package exercisesForExam.goldDigger.zoo.core;

import exercisesForExam.goldDigger.zoo.entities.animals.Animal;
import exercisesForExam.goldDigger.zoo.entities.animals.AquaticAnimal;
import exercisesForExam.goldDigger.zoo.entities.animals.TerrestrialAnimal;
import exercisesForExam.goldDigger.zoo.entities.areas.Area;
import exercisesForExam.goldDigger.zoo.entities.areas.LandArea;
import exercisesForExam.goldDigger.zoo.entities.areas.WaterArea;
import exercisesForExam.goldDigger.zoo.entities.foods.Food;
import exercisesForExam.goldDigger.zoo.entities.foods.Meat;
import exercisesForExam.goldDigger.zoo.entities.foods.Vegetable;
import exercisesForExam.goldDigger.zoo.repositories.FoodRepository;
import exercisesForExam.goldDigger.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area = null;
        if (areaType.equals("WaterArea")){
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        }else {
            throw new NullPointerException("Invalid area type.");
        }
        areas.add(area);

        return "Successfully added " + areaType + ".";
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")){
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        }else {
            throw new IllegalArgumentException("Invalid food type.");
        }
        foodRepository.add(food);
        return "Successfully added " + foodType + ".";
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException("There isn't a food of type " + foodType + ".");
        }
        Area area = getAreaByName(areaName);
        area.addFood(food);

        return "Successfully added " + foodType + " to " + areaName + ".";
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal = null;
        if (animalType.equals("AquaticAnimal")){
            animal = new AquaticAnimal(animalName, kind, price);
        }else if (animalType.equals("TerrestrialAnimal")){
            animal = new TerrestrialAnimal(animalName, kind, price);
        }else {
            throw new IllegalArgumentException("Invalid animal type.");
        }
        Area area = getAreaByName(areaName);
        if (area.getCapacity() == area.getAnimals().size()){
            return "Not enough capacity.";
        }
        if ("AquaticAnimal".equals(animalType) && area.getClass().getSimpleName().equals("WaterArea") ){
            area.addAnimal(animal);
        } else if ("TerrestrialAnimal".equals(animalType) && area.getClass().getSimpleName().equals("LandArea")) {
            area.addAnimal(animal);
        }else {
            return "The external living environment is not suitable.";
        }
        return "Successfully added " + animalType + " to " + areaName + ".";
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = getAreaByName(areaName);
        area.feed();
        return "Animals fed: " + area.getAnimals().size();
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = getAreaByName(areaName);
        double value = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format("The kilograms of Area %s is %.2f.", areaName, value );
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : areas) {
            stringBuilder.append(area.getInfo()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
    private Area getAreaByName(String areaName) {
        return areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);
    }
}
