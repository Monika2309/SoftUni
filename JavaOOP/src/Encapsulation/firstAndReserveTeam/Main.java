package Encapsulation.firstAndReserveTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Team team = new Team("Black Eagles");
        for (int i = 0; i <n ; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person person= new Person(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
            team.addPlayer(person);
        }
        System.out.println("First team have "+team.getFirstTeam().size()+" players");
        System.out.println("Reserve team have "+team.getReserveTeam().size()+" players");
    }
}
