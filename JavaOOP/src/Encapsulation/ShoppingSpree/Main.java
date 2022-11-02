package Encapsulation.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> mapPeople = new LinkedHashMap<>();
        Map<String, Product> mapProducts = new LinkedHashMap<>();
        String[] input1 = scanner.nextLine().split(";");
        for (String str : input1) {
            String[] informationOfPeople = str.split("=");
            try {
                Person person = new Person(informationOfPeople[0], Double.parseDouble(informationOfPeople[1]));
                mapPeople.put(person.getName(), person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
            String[] input2 = scanner.nextLine().split(";");
            for (String str1 : input2) {
                String[] informationOfProducts = str1.split("=");
                try {
                    Product product = new Product(informationOfProducts[0], Double.parseDouble(informationOfProducts[1]));
                    mapProducts.put(product.getName(), product);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            String input = scanner.nextLine();
            while (!input.equals("END")) {
                String nameOfPerson = input.split(" ")[0];
                String nameOfProduct = input.split(" ")[1];
                Person buyer = mapPeople.get(nameOfPerson);
                Product product = mapProducts.get(nameOfProduct);
                try {
                    buyer.buyProduct(product);
                    System.out.println(nameOfPerson+" bought "+nameOfProduct);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                input = scanner.nextLine();
            }
            mapPeople.values().forEach(System.out::println);
        }
}
