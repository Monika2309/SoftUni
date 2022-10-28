package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindrome {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] dimensions  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        char begin ='a';
        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col < cols; col++) {
                char middle = (char)(begin+col);
                matrix[row][col]= String.valueOf(begin)+middle+begin;
            }
            begin++;
        }
        for (String[] row:matrix) {
            for (String str:row) {
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
