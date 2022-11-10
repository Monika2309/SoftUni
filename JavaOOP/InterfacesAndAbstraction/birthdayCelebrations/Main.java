package InterfacesAndAbstraction.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> list = new ArrayList<>();
        while (!"End".equals(input)){
            String[] tokens = input.split(" ");
            String type=tokens[0];
            String name = tokens[1];
            if (type.equals("Citizen")){
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];
                Citizen citizen = new Citizen(name,age,id,birthDate);
                list.add(citizen);
            }else if (type.equals("Pet")){
                String birthDatePet = tokens[2];
                Pet pet = new Pet(name,birthDatePet);
                list.add(pet);
            }
            input=scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean isFound = false;
        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                isFound=true;
            }
        }
        if (!isFound){
            System.out.println("<no output>");
        }
    }
}
