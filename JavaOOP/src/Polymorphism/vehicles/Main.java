package vehicles;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]),Double.parseDouble(carInfo[2]));
        String[] truckInfo = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]),Double.parseDouble(truckInfo[2]));

        Map<String,Vehicle> map = new LinkedHashMap<>();
        map.put("Car",car);
        map.put("Truck",truck);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[1];
            double kmOrFuel = Double.parseDouble(input[2]);
            switch (input[0]){
                case "Drive":
                    System.out.println(map.get(type).driveWithAC(kmOrFuel));
                    break;
                case "Refuel":
                    map.get(type).refuel(kmOrFuel);
                    break;
            }
        }
        map.values().forEach(System.out::println);
    }
}
