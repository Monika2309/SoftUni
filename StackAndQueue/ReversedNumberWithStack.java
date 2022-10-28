package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReversedNumberWithStack {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            stack.push(tokens[i]);
        }
        for (Integer integer : stack) {
            System.out.print(stack.pop()+" ");
        }
    }
}
