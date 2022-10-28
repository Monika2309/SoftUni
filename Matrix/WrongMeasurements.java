package MultidimensionalArrays;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix= new int[n][];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] wrong = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrongRow = wrong[0];
        int wrongCol = wrong[1];
        int wrongNumber = matrix[wrongRow][wrongCol];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum =0;
                int num = matrix[i][j];
                if (num == wrongNumber) {
                    if (i>0){
                        if (matrix[i-1][j]!=wrongNumber) {
                                sum += matrix[i - 1][j];
                        }
                    }
                    if (i<matrix.length-1){
                        if (matrix[i+1][j]!=wrongNumber) {
                                sum += matrix[i + 1][j];
                        }
                    }
                    if (j>0){
                        if (matrix[i][j-1]!=wrongNumber) {
                                sum += matrix[i][j - 1];
                        }
                    }
                    if (j<matrix[i].length-1){
                        if (matrix[i][j+1]!=wrongNumber) {
                                sum += matrix[i][j+ 1];
                        }
                    }
                    queue.addFirst(sum);
                }
            }

        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                int number= matrix[i][j];
                if (number == wrongNumber) {
                    number = queue.poll();
                }
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
