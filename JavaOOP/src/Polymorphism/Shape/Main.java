package Polymorphism.Shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double height = Double.valueOf(scanner.nextLine());
        Double width = Double.valueOf(scanner.nextLine());
        Shape shape = new Rectangle(height,width);
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());
    }
}
