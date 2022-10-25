package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(males::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(females::offer);
        int countMatching = 0;
        while (!males.isEmpty() && !females.isEmpty()){
            int male = males.peek();
            int female = females.peek();
            if (male<=0 ){
                males.pop();
                continue;
            }
            if (female<=0 ){
                females.poll();
               continue;
            }

            if (male%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if (female%25==0){
                females.pop();
                females.pop();
                continue;
            }

            if (female==male){
                countMatching++;
                females.poll();
                males.pop();
            }else {
                int num = males.pop();
                females.pop();
                num-=2;
                if (num>=0) {
                    males.push(num);
                }
            }
        }
        System.out.println("Matches: "+countMatching);
        if (males.isEmpty()){
            System.out.println("Males left: none");
        }else {
            StringBuilder stringBuilder= new StringBuilder().append("Males left: ");
            for (Integer male:males) {
                stringBuilder.append(male).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }
        if (females.isEmpty()){
            System.out.println("Females left: none");
        }else {
            StringBuilder stringBuilder= new StringBuilder().append("Females left: ");
            for (Integer female:females) {
                stringBuilder.append(female).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }
    }
}
