package StackAndQueue;

import java.util.*;

public class Blacksmith {
    private static final int GLADIUS = 70;
    private static final int SHAMSHIR = 80;
    private static final int KATANA = 90;
    private static final int SABRE = 110;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input1= scanner.nextLine();
        String input2= scanner.nextLine();
        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(input1.split("\\s+")).mapToInt(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(input2.split("\\s+")).mapToInt(Integer::parseInt).forEach(carbon::push);
        Map<String,Integer> map = new TreeMap<>();
        int count=0;
        while (!steel.isEmpty()&& !carbon.isEmpty()){
            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();
            int sum = currentCarbon+currentSteel;
            switch (sum){
                case GLADIUS :
                    map.putIfAbsent("Gladius",0);
                    map.put("Gladius",map.get("Gladius")+1);
                    count++;
                    break;
                case SHAMSHIR:
                    map.putIfAbsent("Shamshir",0);
                    map.put("Shamshir",map.get("Shamshir")+1);
                    count++;
                    break;
                case KATANA:
                    map.putIfAbsent("Katana",0);
                    map.put("Katana",map.get("Katana")+1);
                    count++;
                    break;
                case SABRE:
                    map.putIfAbsent("Sabre",0);
                    map.put("Sabre",map.get("Sabre")+1);
                    count++;
                    break;
                default:
                    carbon.push(currentCarbon+5);
                    break;
            }
        }
        if (count>0){
            System.out.println("You have forged "+count+" swords.");
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Steel left: ");
            while (!steel.isEmpty()){
                sb.append(steel.poll()).append(", ");
            }
            sb.replace(sb.length()-3,sb.length()-1,"");
            System.out.print(sb.toString());
        }
        if (carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Carbon left: ");
            while (!carbon.isEmpty()){
                sb.append(carbon.pop()).append(", ");
            }
            sb.replace(sb.length()-2,sb.length()-1,"");
            System.out.print(sb.toString());
        }
        System.out.println();
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
