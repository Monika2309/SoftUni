package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,children);
        int n = Integer.parseInt(scanner.nextLine());
        int cycle =1;
        while (queue.size()>1){
            for (int i = 1; i <n ; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)){
                System.out.println("Prime "+queue.peek());
            }else {
                System.out.println("Removed "+queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is "+queue.poll());
    }

    static boolean isPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber <= 1) {
            isItPrime = false;

        }else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;

                    break;
                }
            }

        }
        return isItPrime;
    }
}
