package workingWithAbstraction.trafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] trafficLights = scanner.nextLine().split(" ");
        List<TrafficLight> trafficLightList = Arrays.stream(trafficLights)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <num ; i++) {
            for (TrafficLight trafficLight:trafficLightList) {
                trafficLight.changeColor();
                System.out.print(trafficLight +" ");
            }
            System.out.println();
        }
    }
}
