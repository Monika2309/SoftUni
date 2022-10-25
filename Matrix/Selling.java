package Matrix;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n ; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        int myRow = 0;
        int myCol =0;
        int firstRow=0;
        int firstCol =0;
        boolean foundFirst =false;
        int secondRow =0;
        int secondCol =0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='S'){
                    myRow=i;
                    myCol=j;
                }
                if (matrix[i][j]=='O' && !foundFirst){
                    firstRow=i;
                    firstCol=j;
                    foundFirst=true;
                }else if (matrix[i][j]=='O' && foundFirst){
                    secondRow=i;
                    secondCol=j;
                }
            }
        }
        int money = 0;
        while (money<50){
            String command = scanner.nextLine();
            matrix[myRow][myCol]='-';
            switch (command){
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "right":
                    myCol++;
                    break;
            }
            if (isInBounds(matrix,myRow,myCol)){
                if (myRow==firstRow&&myCol==firstCol && matrix[myRow][myCol]=='O'){
                    matrix[myRow][myCol]='-';
                    myRow=secondRow;
                    myCol=secondCol;
                }else if (myRow==secondRow && myCol==secondCol && matrix[myRow][myCol]=='O'){
                    matrix[myRow][myCol]='-';
                    myRow=firstRow;
                    myCol=firstCol;
                } else if (Character.isDigit(matrix[myRow][myCol])) {
                    money+=Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                }
                matrix[myRow][myCol]='S';
            }else {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
        }
        if (money>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "+money);
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static boolean isInBounds(char[][] matrix, int row, int col){
        if (row>=0 && row< matrix.length && col>=0 && col<matrix.length){
            return true;
        }
        return false;
    }
}
