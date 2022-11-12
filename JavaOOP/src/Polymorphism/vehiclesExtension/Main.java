package vehiclesExtension;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        String[] truckInfo = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        String[] busInfo = scanner.nextLine().split(" ");
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        Map<String,Vehicle> map = new LinkedHashMap<>();
        map.put("Car",car);
        map.put("Truck",truck);
        map.put("Bus", bus);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[1];
            double kmOrFuel = Double.parseDouble(input[2]);
            if (kmOrFuel <= 0) {
                System.out.println("Fuel must be a positive number");
                continue;
            }
            switch (input[0]){
                case "Drive":
                    System.out.println(map.get(type).driveWithAC(kmOrFuel));
                    break;
                case "Refuel":
                    if (map.get(type).canFitFuel(kmOrFuel)){
                        map.get(type).refuel(kmOrFuel);
                    }else {
                        System.out.println("Cannot fit fuel in tank");
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(map.get(type).drive(kmOrFuel));
                    break;
            }
        }
        map.values().forEach(System.out::println);
    }
}
