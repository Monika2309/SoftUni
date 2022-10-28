package stacksAndQueues;

import java.util.*;


public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,children);
        int n = Integer.parseInt(scanner.nextLine());
        while (queue.size()>1){
            for (int i = 1; i <n ; i++) {
                queue.offer(queue.poll());

            }
            System.out.println("Removed "+queue.poll());
        }
        System.out.println("Last is "+queue.poll());
    }
}
