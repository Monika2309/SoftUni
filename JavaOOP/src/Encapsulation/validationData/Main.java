package Encapsulation.validationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] data= scanner.nextLine().split(" ");
            Person person=null;
            try {
              person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
              list.add(person);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        double bonus =Double.parseDouble(scanner.nextLine());
        for (Person p:list) {
            p.increaseSalary(bonus);
            System.out.println(p.toString());
        }
    }
}
