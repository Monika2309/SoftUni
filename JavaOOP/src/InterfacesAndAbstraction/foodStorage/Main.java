package InterfacesAndAbstraction.foodStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int sum =0;
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] info= scanner.nextLine().split(" ");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            if (info.length==3) {
                String group = info[2];
                Rebel rebel = new Rebel(name,age,group);
                list.add(rebel);
            }else if(info.length==4){
                String id = info[2];
                String birthDate = info[3];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                list.add(citizen);
            }
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)){
            String string= input;
            Person person=list.stream().filter(person1 -> person1.getName().equals(string)).findFirst().orElse(null);
            if (person !=null && person.getClass()==Rebel.class){
                sum+=5;
            }else if (person != null && person.getClass()==Citizen.class){
                sum+=10;
            }
            input=scanner.nextLine();
        }
        System.out.println(sum);
    }
}
