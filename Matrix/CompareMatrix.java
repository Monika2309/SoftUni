package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = dimension[0];
        int col = dimension[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i <row ; i++) {
            matrix[i]=Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] dimension2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row2 = dimension2[0];
        int col2 = dimension2[1];
        int[][] matrix2 = new  int[row2][col2];
        for (int i = 0; i <row2 ; i++) {
            matrix2[i]=Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        if (Arrays.deepEquals(matrix,matrix2)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }

    }
}
