package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(tulips::push);
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(daffodils::offer);
        int amount =0;
        int left=0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()){
            int daffodil = daffodils.peek();
            int tulip = tulips.peek();
            int sum = daffodil+tulip;
            if(sum==15){
                amount++;
                daffodils.poll();
                tulips.pop();
            }else if (sum>15){
               int t= tulips.pop();
               tulips.push(t-2);
            }else {
                left+=sum;
                tulips.pop();
                daffodils.poll();
            }
        }
        amount+=left/15;
        if (amount>=5){
            System.out.println("You made it! You go to the competition with "+amount+" bouquets!");
        }else {
            int needed= 5-amount;
            System.out.println("You failed... You need more "+needed+" bouquets.");
        }
    }
}
