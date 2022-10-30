package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPosition(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];
        fillGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readPosition(command);
            int[] evilPosition = readPosition(scanner.nextLine());
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            moveEvil(galaxy, evilRow, evilCol);
            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

            sum = moveJedi(galaxy, sum, jediRow, jediCol);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
    private static long moveJedi(int[][] galaxy, long sum, int ivoRow, int ivoCol) {
        while (ivoRow >= 0 && ivoCol < galaxy[1].length) {
            if (ivoRow < galaxy.length && ivoCol >= 0 && ivoCol < galaxy[0].length) {
                sum += galaxy[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
        return sum;
    }
    private static void moveEvil(int[][] galaxy, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if ( evilRow < galaxy.length && evilCol < galaxy[0].length) {
                galaxy[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
    private static int[] readPosition(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    private static void fillGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                galaxy[i][j] = value++;
            }
        }
    }
}
