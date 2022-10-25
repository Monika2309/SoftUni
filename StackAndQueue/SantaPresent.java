package StackAndQueue;

import java.util.*;

public class SantaPresent {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> first = new ArrayDeque<>();
        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(first::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(second::offer);
        Map<String,Integer> map= new TreeMap<>();
        map.put("Doll",0);
        map.put("Wooden train", 0);
        map.put("Teddy bear", 0);
        map.put("Bicycle", 0);
        while (!first.isEmpty() && !second.isEmpty()){
            int firstNum = first.peek();
            int secondNum = second.peek();
            int multiply = firstNum*secondNum;
            if (secondNum==0 && firstNum==0){
                first.pop();
                second.poll();
                continue;
            }
            if (firstNum==0){
                first.pop();
                continue;
            }
            if (secondNum==0){
                second.poll();
                continue;
            }
            if (multiply<0){
                int sum = firstNum+secondNum;
                first.pop();
                second.poll();
                first.push(sum);
                continue;
            }

            switch (multiply) {
                case 150:
                    map.put("Doll", map.get("Doll") + 1);
                    first.pop();
                    second.poll();
                    break;
                case 250:
                    map.put("Wooden train", map.get("Wooden train") + 1);
                    first.pop();
                    second.poll();
                    break;
                case 300:
                    map.put("Teddy bear", map.get("Teddy bear") + 1);
                    first.pop();
                    second.poll();
                    break;
                case 400:
                    map.put("Bicycle", map.get("Bicycle") + 1);
                    first.pop();
                    second.poll();
                    break;
                default:
                    first.pop();
                    second.poll();
                    first.push(firstNum + 15);
                    break;
            }
        }
        if (map.get("Doll")>0 && map.get("Wooden train")>0 || map.get("Teddy bear")>0 && map.get("Bicycle")>0){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }
        if (!first.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Materials left: ");
            for (int num:first) {
                sb.append(num).append(", ");
            }
            sb.delete(sb.length()-2,sb.length()-1);
            System.out.println(sb);
        }
        if (!second.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Magic left: ");
            for (int num:second) {
                sb.append(num).append(", ");
            }
            sb.delete(sb.length()-2,sb.length()-1);
            System.out.println(sb);
        }
        if (!map.isEmpty()){
            for (Map.Entry<String,Integer>entry: map.entrySet()) {
                if (entry.getValue()>0) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

    }
}
