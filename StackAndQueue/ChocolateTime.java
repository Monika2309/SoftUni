package StackAndQueue;

import java.util.*;

public class ChocolateTime {
    private static final double MILK_CHOCOLATE=30.0;
    private static final double DARK_CHOCOLATE=50.0;
    private static final double BAKING_CHOCOLATE=100.0;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input= scanner.nextLine();
        String input2= scanner.nextLine();
        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+")).mapToDouble(Double::parseDouble).forEach(milk::offer);
        Arrays.stream(input2.split("\\s+")).mapToDouble(Double::parseDouble).forEach(cacaoPowder::push);
        Map<String,Integer> map = new TreeMap<>();
        map.put("Milk Chocolate",0);
        map.put("Dark Chocolate",0);
        map.put("Baking Chocolate",0);
        while (!milk.isEmpty()&&!cacaoPowder.isEmpty()){
           double currentMilk= milk.poll();
           double currentCacao = cacaoPowder.pop();
           double percentage = (currentCacao/(currentMilk+currentCacao))*100;
            if (percentage == MILK_CHOCOLATE) {
                map.put("Milk Chocolate", map.get("Milk Chocolate")+1);
            }else if (percentage==DARK_CHOCOLATE){
                map.put("Dark Chocolate", map.get("Dark Chocolate")+1);
            }else if (percentage==BAKING_CHOCOLATE){
                map.put("Baking Chocolate", map.get("Baking Chocolate")+1);
            }else {
                currentMilk+=10;
                milk.offer(currentMilk);
            }
        }
        if (map.get("Milk Chocolate")>0 && map.get("Dark Chocolate")>0 && map.get("Baking Chocolate")>0){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            String type = entry.getKey();
            int count = entry.getValue();
            if (count>0){
                System.out.println("# "+type+" --> "+count);
            }
        }
    }
}
