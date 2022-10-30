package workingWithAbstraction.cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(string+":");
        for (Suit s:Suit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",s.ordinal(),s.name());
        }
    }
}
