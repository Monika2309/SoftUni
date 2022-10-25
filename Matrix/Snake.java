package Matrix;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i <n ; i++) {
            matrix[i]=scanner.nextLine().toCharArray();
        }
        int rowS= 0;
        int colS=0;
        int firstRow = 0;
        int firstCol =0;
        int secondRow = 0;
        int secondCol = 0;
        boolean found = false;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='S'){
                    rowS=i;
                    colS=j;
                }
                if (matrix[i][j]=='B' && !found){
                    firstRow=i;
                    firstCol=j;
                    found=true;
                }else if (matrix[i][j]=='B' && found){
                    secondRow=i;
                    secondCol=j;
                }
            }
        }
        int food = 0;
        while (food<10){
            String command = scanner.nextLine();
            matrix[rowS][colS]='.';
            switch (command){
                case "up":
                    rowS--;
                    break;
                case "down":
                    rowS++;
                    break;
                case "right":
                    colS++;
                    break;
                case "left":
                    colS--;
                    break;
            }
            if(isInBounds(matrix,rowS,colS)){
                if (matrix[rowS][colS]=='*'){
                    food++;
                    matrix[rowS][colS]='S';
                } else if (rowS==firstRow && colS==firstCol) {
                    matrix[rowS][colS]='.';
                    rowS=secondRow;
                    colS=secondCol;
                    matrix[rowS][colS]='S';
                } else if (rowS==secondRow && colS==secondCol) {
                    matrix[rowS][colS]='.';
                    rowS=firstRow;
                    colS=firstCol;
                    matrix[rowS][colS]='S';
                }else {
                    matrix[rowS][colS]='S';
                }
            }else {
                System.out.println("Game over!");
                break;
            }

        }
        if (food>=10){
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: "+food);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
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
