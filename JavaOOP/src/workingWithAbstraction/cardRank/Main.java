package workingWithAbstraction.cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String string =scanner.nextLine();
        System.out.println(string+":");
        for (Rank r:Rank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",r.ordinal(),r.name());
        }
    }
}
