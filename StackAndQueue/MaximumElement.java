package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            int action = Integer.parseInt(command[0]);

           switch (action){
               case 1:
                   int x = Integer.parseInt(command[1]);
                   stack.push(x);
                   break;
               case 2:
                   stack.pop();
                   break;
               case 3:
                   System.out.println(Collections.max(stack));
                   break;
           }
        }
    }
}
