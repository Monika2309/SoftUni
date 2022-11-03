package PizzaCalories;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] informationOfPizza= scanner.nextLine().split(" ");
        String nameOfPizza = informationOfPizza[1];
        int numberOfToppings = Integer.parseInt(informationOfPizza[2]);
        String[] informationOfDough = scanner.nextLine().split(" ");
        String flourType = informationOfDough[1];
        String bakingTechnique = informationOfDough[2];
        double weight = Double.parseDouble(informationOfDough[3]);
        try {
            Pizza pizza = new Pizza(nameOfPizza, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);
            String command = scanner.nextLine();
            while (!command.equals("END")) {
                String[] informationOfTopping = command.split(" ");
                String toppingType = informationOfTopping[1];
                double weightOfTopping = Double.parseDouble(informationOfTopping[2]);
                    Topping topping = new Topping(toppingType, weightOfTopping);
                    pizza.addTopping(topping);

                command = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getOverallCalories());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
