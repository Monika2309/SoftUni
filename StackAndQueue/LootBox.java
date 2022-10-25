package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> first = new ArrayDeque<>();
        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(second::push);
         int value = 0;
        while (!first.isEmpty() && !second.isEmpty()){
            int firstNumber = first.peek();
            int lastNumber = second.peek();
            int sum = firstNumber+lastNumber;
            if (sum%2==0){
                value+=sum;
                first.poll();
                second.pop();
            }else {
                first.offer(second.pop());
            }
        }
        if (second.isEmpty()){
            System.out.println("Second lootbox is empty");
        }else {
            System.out.println("First lootbox is empty");
        }
        if (value>=100){
            System.out.println("Your loot was epic! Value: "+value);
        }else {
            System.out.println("Your loot was poor... Value: "+value);
        }
    }
}
