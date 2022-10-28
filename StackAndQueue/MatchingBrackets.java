package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack  = new ArrayDeque<>();
        StringBuilder stringBuilder= new StringBuilder(input);
        for (int i = 0; i <input.length() ; i++) {
            char c = input.charAt(i);
            if (c=='('){
                stack.push(i);
            }else if (c==')'){
                int begin = stack.pop();
                System.out.println(stringBuilder.substring(begin,i+1));
            }
        }
    }
}
