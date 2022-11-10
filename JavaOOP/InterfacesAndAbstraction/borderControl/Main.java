package InterfacesAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        List<Identifiable> list = new ArrayList<>();
        while (!"End".equals(input)){
            String[] tokens = input.split(" ");
            if (tokens.length==3){
                Identifiable citizen = new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                list.add(citizen);
            }else {
                Identifiable robot = new Robot(tokens[0],tokens[1]);
                list.add(robot);
            }
            input=scanner.nextLine();
        }
        String num = scanner.nextLine();
        list=list.stream().filter(identifiable -> identifiable.getId().endsWith(num)).collect(Collectors.toList());
        list.forEach(identifiable -> System.out.println(identifiable.getId()));
    }
}
