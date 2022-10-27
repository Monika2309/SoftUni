package hotelReservation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(strings[0]);
        int days = Integer.parseInt(strings[1]);
        Season season = Season.valueOf(strings[2].toUpperCase());
        DiscountType discount = DiscountType.valueOf(strings[3].toUpperCase());
        PriceCalculator priceCalculator=new PriceCalculator(pricePerDay,days,season,discount);
        System.out.printf("%.2f",priceCalculator.calculatePrice());
    }
}
