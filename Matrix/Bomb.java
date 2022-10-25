package Matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> listOfCommands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j].charAt(0);
            }
        }
        int myRow = 0;
        int myCol = 0;
        int countBombs = 0;
        int myBombs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 's') {
                    myRow = i;
                    myCol = j;
                }
                if (matrix[i][j] == 'B') {
                    countBombs++;
                }
            }
        }
        for (int i = 0; i < listOfCommands.size(); i++) {
            String command = listOfCommands.get(i);

            switch (command) {
                case "up":
                    if (myRow - 1 >= 0) {
                        matrix[myRow][myCol] = '+';
                        myRow--;
                    }
                    break;
                case "down":
                    if (myRow + 1 < matrix.length) {
                        matrix[myRow][myCol] = '+';
                        myRow++;
                    }
                    break;
                case "left":
                    if (myCol - 1 >= 0) {
                        matrix[myRow][myCol] = '+';
                        myCol--;
                    }
                    break;
                case "right":
                    if (myCol + 1 < matrix.length) {
                        matrix[myRow][myCol] = '+';
                        myCol++;
                    }
                    break;
            }
            if (matrix[myRow][myCol] == 'e') {
                int bombsLeft = countBombs - myBombs;
                System.out.println("END! " + bombsLeft + " bombs left on the field");
                return;
            } else if (matrix[myRow][myCol] == 'B') {
                matrix[myRow][myCol]='+';
                System.out.println("You found a bomb!");
                myBombs++;
            }

            if (myBombs == countBombs) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }
        int bombsLeft = countBombs - myBombs;
        System.out.println(bombsLeft + " bombs left on the field. Sapper position: (" + myRow + "," + myCol + ")");
    }
}
