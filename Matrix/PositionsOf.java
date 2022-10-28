package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dimension[0];
        int col = dimension[1];

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i]=Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int wantedNumber= Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j <col ; j++) {
                if (matrix[i][j]==wantedNumber){
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        if (count==0){
            System.out.println("not found");
        }
    }
}
