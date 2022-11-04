package workingWithAbstraction.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(numbers[0],numbers[1]);
        Point topRight = new Point(numbers[2],numbers[3]);
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point newPoint = new Point(x,y);
            System.out.println(rectangle.contains(newPoint));
        }
    }
}
