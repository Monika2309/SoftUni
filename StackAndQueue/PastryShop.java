package StackAndQueue;

import java.util.*;

public class PastryShop {
    private static final int BISCUIT = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int PIE = 100;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(ingredients::push);
        Map<String,Integer> map= new LinkedHashMap<>();
        map.put("Biscuit", 0);
        map.put("Cake", 0);
        map.put("Pie", 0);
        map.put("Pastry", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int currentLiquid= liquids.poll();
            int currentIngredient = ingredients.pop();
            int sum = currentIngredient+currentLiquid;
            switch (sum){
                case BISCUIT :
                    map.put("Biscuit",map.get("Biscuit")+1);
                    break;
                case CAKE:
                    map.put("Cake",map.get("Cake")+1);
                    break;
                case PASTRY:
                    map.put("Pastry",map.get("Pastry")+1);
                    break;
                case PIE:
                    map.put("Pie",map.get("Pie")+1);
                    break;
                default:
                    ingredients.push(currentIngredient+3);
                    break;
            }
        }
        if (map.get("Pastry")>0 && map.get("Pie")>0 && map.get("Cake")>0 && map.get("Biscuit")>0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (!liquids.isEmpty()){
            StringBuilder stringBuilder= new StringBuilder().append("Liquids left: ");
            for (Integer e:liquids) {
                stringBuilder.append(e).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }else {
            System.out.println("Liquids left: none");
        }
        if (!ingredients.isEmpty()){
            StringBuilder stringBuilder= new StringBuilder().append("Ingredients left: ");
            for (Integer e:ingredients) {
                stringBuilder.append(e).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }else {
            System.out.println("Ingredients left: none");
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
