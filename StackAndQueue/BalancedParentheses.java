package stacksAndQueues;

import java.util.ArrayDeque;

import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String brackets =  scanner.nextLine();
        ArrayDeque<Character> open  = new ArrayDeque<>();
        boolean isBalanced= true;
        for (int i = 0; i <brackets.length() ; i++) {
            char c = brackets.charAt(i);
            if (c=='[' || c=='(' || c=='{'){
                open.push(c);
            }
            if (open.isEmpty()){
                isBalanced=false;
                break;
            }
            if (c==']' || c==')' || c=='}' ) {
                char ch = open.pop();
                if (ch!='[' && c==']' || ch!='(' && c==')' || ch!='{' && c=='}'){
                    isBalanced=false;
                    break;
                }
            }
        }
            if (isBalanced && brackets.length()%2==0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
    }
}
