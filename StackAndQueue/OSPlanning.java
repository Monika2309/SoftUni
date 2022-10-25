package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(threads::offer);
        int num = Integer.parseInt(scanner.nextLine());
        while (!tasks.isEmpty() && !threads.isEmpty()){
            int currentTask = tasks.peek();
            int currentThread = threads.peek();
            if (currentTask==num){
                break;
            }else {
                if (currentThread>=currentTask){
                    tasks.pop();
                    threads.poll();
                }else {
                    threads.poll();
                }
            }
        }
        System.out.println("Thread with value "+threads.peek()+" killed task "+num);
        for (Integer n:threads) {
            System.out.print(n+" ");
        }
    }
}
