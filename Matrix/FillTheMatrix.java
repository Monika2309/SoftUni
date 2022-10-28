package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];
        int number = 1;
        switch (type){
            case "A":
                for (int col = 0; col <n ; col++) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col]=number;
                        number++;
                    }
                }
                break;
            case "B":
                for (int col = 0; col <n ; col++) {
                    if (col%2==0) {
                        for (int row = 0; row < n; row++) {
                            matrix[row][col]=number;
                            number++;
                        }
                    }else {
                        for (int r = n-1; r >=0 ; r--) {
                            matrix[r][col]=number;
                            number++;
                        }
                    }
                }
                break;

        }
        for (int[] r :matrix) {
            for (int num:r) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
