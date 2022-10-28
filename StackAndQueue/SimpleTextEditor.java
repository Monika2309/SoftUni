package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        StringBuilder stringBuilder= new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack  = new ArrayDeque<>();
        stack.push("");
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int action = Integer.parseInt(input[0]);

            switch (action){
                case 1:
                    String text = input[1];
                    stringBuilder.append(text);
                    stack.push(stringBuilder.toString());
                    break;
                case 2:
                    int count = Integer.parseInt(input[1]);
                    int begin = stringBuilder.length()-count;
                    stringBuilder.delete(begin,stringBuilder.length());
                    stack.push(stringBuilder.toString());
                    break;
                case 3:
                    int index = Integer.parseInt(input[1]);
                    System.out.println(stringBuilder.charAt(index-1));
                    break;
                case 4:
                    String lastCommand = stack.pop();
                    if (lastCommand.equals(stringBuilder.toString())){
                        lastCommand=stack.pop();
                    }
                    stringBuilder=new StringBuilder(lastCommand);
                    break;
            }
        }
    }

    public static class RecursiveFibonacci {
        public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            ArrayDeque<Long> stack = new ArrayDeque<>();
            if (n<2){
                System.out.println(1);
                return;
            }
            stack.push(0L);
            stack.push(1L);
            for (int i = 1; i <=n; i++) {
                long first =stack.pop();
                long second =stack.pop();
                stack.push(first);
                stack.push(first+second);
            }
                System.out.println(stack.pop());
        }
    }
}
