package StackAndQueue;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffects::offer);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasings::push);
        Map<String,Integer> map= new TreeMap<>();
        map.put("Cherry Bombs",0);
        map.put("Datura Bombs",0);
        map.put("Smoke Decoy Bombs",0);
        while (!bombCasings.isEmpty() && !bombEffects.isEmpty()){
            int currentEffect = bombEffects.peek();
            int currentCasing = bombCasings.peek();
            int sum = currentCasing+currentEffect;
            switch (sum){
                case 60:
                    map.put("Cherry Bombs", map.get("Cherry Bombs")+1);
                    bombCasings.pop();
                    bombEffects.poll();
                    break;
                case 40:
                    map.put("Datura Bombs",map.get("Datura Bombs")+1);
                    bombCasings.pop();
                    bombEffects.poll();
                    break;
                case 120:
                    map.put("Smoke Decoy Bombs",map.get("Smoke Decoy Bombs")+1);
                    bombCasings.pop();
                    bombEffects.poll();
                    break;
                default:
                    bombCasings.push(bombCasings.pop()-5);
                    break;
            }
            if (map.get("Cherry Bombs")>=3 && map.get("Smoke Decoy Bombs")>=3 && map.get("Datura Bombs")>=3){
                break;
            }
        }
        if (map.get("Cherry Bombs")>=3 && map.get("Smoke Decoy Bombs")>=3 && map.get("Datura Bombs")>=3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            StringBuilder stringBuilder= new StringBuilder().append("Bomb Effects: ");
            for (Integer i:bombEffects) {
                stringBuilder.append(i).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }
        if (bombCasings.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            StringBuilder stringBuilder= new StringBuilder().append("Bomb Casings: ");
            for (Integer i:bombCasings) {
                stringBuilder.append(i).append(", ");
            }
            stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }

        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
