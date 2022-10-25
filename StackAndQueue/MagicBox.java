package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> first = new ArrayDeque<>();
        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(second::push);
        int value = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int firstItem = first.peek();
            int secondItem = second.peek();
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                value += sum;
                first.poll();
                second.pop();
            } else {
                int removed = second.pop();
                first.offer(removed);
            }
        }
        if (first.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (value >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + value);
        } else {
            System.out.println("Poor prey... Value: " + value);
        }
    }
}
