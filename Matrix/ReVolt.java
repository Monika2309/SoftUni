package Matrix;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        int row = -1;
        int col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'f') {
                    row = i;
                    col = j;
                }
            }
        }
        boolean found = false;
        String command = scanner.nextLine();
        while (countCommands> 0){
            int oldRow = row;
            int oldCol = col;
            if (matrix[row][col] !='B'){
                matrix[row][col] = '-';
            }
            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        row = matrix.length - 1;
                    } else {
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 > matrix.length - 1) {
                        row = 0;
                    } else {
                        row++;
                    }
                    break;
                case "left":
                    if (col - 1 < 0) {
                        col = matrix.length - 1;
                    } else {
                        col--;
                    }
                    break;
                case "right":
                    if (col + 1 > matrix.length - 1) {
                        col = 0;
                    } else {
                        col++;
                    }
                    break;
            }
            if (matrix[row][col] == 'B') {
                continue;
            } else if (matrix[row][col]=='T') {
                row=oldRow;
                col = oldCol;
                matrix[row][col]='f';
            } else if (matrix[row][col] == 'F') {
                matrix[row][col] = 'f';
                found = true;
                break;
            } else {
                matrix[row][col] = 'f';
            }
            countCommands--;
            if (countCommands>0) {
                command = scanner.nextLine();
            }
        }
        if (!found) {
            System.out.println("Player lost!");
        } else {
            System.out.println("Player won!");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
