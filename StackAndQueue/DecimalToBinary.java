package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack= new ArrayDeque<>();

        while (num>0){
            int n = num%2;
            stack.push(n);
            num = num/2;
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }else {
            for (Integer integer : stack) {
                System.out.print(stack.pop());
            }
        }
    }
}
