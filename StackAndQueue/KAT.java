package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] firstInput= Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput= Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> licensesQueue=new ArrayDeque<>();
        ArrayDeque<Integer> carsStack=new ArrayDeque<>();
        int countOfRegisteredCars = 0;
        int days = 0;
        for (int i = 0; i < firstInput.length ; i++) {
            licensesQueue.offer(firstInput[i]);
        }
        for (int i = 0; i < secondInput.length ; i++) {
            carsStack.push(secondInput[i]);
        }
        while (!carsStack.isEmpty() && !licensesQueue.isEmpty()){
            days++;
            int licenses = licensesQueue.poll();
            int cars = carsStack.pop();
            if (licenses==0||cars==0){
                continue;
            }
            if (cars*2<licenses){
                licenses=licenses-cars*2;
                licensesQueue.offer(licenses);
                countOfRegisteredCars+=cars;
            } else if (cars*2>licenses) {
                cars=cars-licenses/2;
                carsStack.offer(cars);
                countOfRegisteredCars+=licenses/2;
            }else {
                countOfRegisteredCars+=cars;
            }

        }
        System.out.println(countOfRegisteredCars+" cars were registered for "+days+" days!");
        if (!licensesQueue.isEmpty()){
            int sum=0;
            while (!licensesQueue.isEmpty()){
                sum+=licensesQueue.poll();
            }
            System.out.println(sum+" license plates remain!");
        }else if (!carsStack.isEmpty()){
            int sum=0;
            while (!carsStack.isEmpty()){
                sum+=carsStack.pop();
            }
            System.out.println(sum+" cars remain without license plates!");
        } else{
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
