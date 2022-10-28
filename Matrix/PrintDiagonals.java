package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        int row = n-1;
        int col = 0;
        while (row>=0 && row<n && col>=0 && col<n){
            System.out.print(matrix[row][col]+" ");
            row--;
            col++;
        }

    }
}
