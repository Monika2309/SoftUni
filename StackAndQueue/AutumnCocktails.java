package StackAndQueue;

import java.util.*;

public class AutumnCocktails {
    private static final int PEAR_SOUR= 150;
    private static final int THE_HARVEST= 250;
    private static final int APPLE_HINNY= 300;
    private static final int HIGH_FASHION=400;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> ingredients= new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(ingredients::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(freshness::push);
        Map<String,Integer> map = new TreeMap<>();
        map.put("Pear Sour",0);
        map.put("The Harvest",0);
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);
        while (!ingredients.isEmpty() && !freshness.isEmpty()){
            int currentIngredient = ingredients.poll();
            if (currentIngredient==0){
                continue;
            }
            int currentFreshness = freshness.pop();
            int multiply = currentFreshness*currentIngredient;
            switch (multiply){
                case PEAR_SOUR :
                    map.put("Pear Sour",map.get("Pear Sour")+1);
                    break;
                case THE_HARVEST:
                    map.put("The Harvest",map.get("The Harvest")+1);
                    break;
                case APPLE_HINNY:
                    map.put("Apple Hinny",map.get("Apple Hinny")+1);
                    break;
                case HIGH_FASHION:
                    map.put("High Fashion",map.get("High Fashion")+1);
                    break;
                default:
                    ingredients.offer(currentIngredient+5);
                    break;
            }
        }
        if (map.get("Pear Sour")>0 && map.get("Apple Hinny")>0 && map.get("High Fashion")>0 && map.get("The Harvest")>0){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sum = 0;
            while (!ingredients.isEmpty()){
                sum+=ingredients.poll();
            }
            System.out.println("Ingredients left: "+sum);
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            String name = entry.getKey();
            int amount = entry.getValue();
            if (amount>0){
                System.out.println("# "+name+" --> "+amount);
            }
        }
    }
}
