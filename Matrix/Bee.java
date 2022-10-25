package Matrix;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        int rowB = 0;
        int colB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'B') {
                    rowB = i;
                    colB = j;
                }
            }
        }
        int flowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            matrix[rowB][colB] = '.';
            switch (command) {
                case "up":
                    rowB--;
                    break;
                case "down":
                    rowB++;
                    break;
                case "left":
                    colB--;
                    break;
                case "right":
                    colB++;
                    break;
            }
            if (isInBounds(matrix, rowB, colB)) {
                if (matrix[rowB][colB] == 'f') {
                    matrix[rowB][colB] = 'B';
                    flowers++;
                } else if (matrix[rowB][colB] == 'O') {
                    matrix[rowB][colB] = 'B';
                    continue;
                } else {
                    matrix[rowB][colB] = 'B';
                }
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }
        if (flowers >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + flowers + " flowers!");
        } else {
            int needed = 5 - flowers;
            System.out.println("The bee couldn't pollinate the flowers, she needed " + needed + " flowers more");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            return true;
        }
        return false;
    }
}
