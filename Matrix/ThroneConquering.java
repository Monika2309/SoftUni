package Matrix;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i <n ; i++) {
            matrix[i]= scanner.nextLine().toCharArray();
        }
        int rowP=-1;
        int colP=-1;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]=='P'){
                    rowP=i;
                    colP=j;
                }

            }
        }
        while (energy>0){
            String[] input = scanner.nextLine().split(" ");
            String command= input[0];
            int enemyRow= Integer.parseInt(input[1]);
            int enemyCol = Integer.parseInt(input[2]);

            matrix[enemyRow][enemyCol]='S';
            matrix[rowP][colP]='-';
            switch (command){
                case "up":
                    if (rowP-1>=0){
                        rowP--;
                    }
                    break;
                case "down":
                    if (rowP+1<matrix.length){
                        rowP++;
                    }
                    break;
                case "right":
                    if (colP+1< matrix.length){
                        colP++;
                    }
                    break;
                case "left":
                    if (colP-1>=0){
                        colP--;
                    }
                    break;
            }
            energy=energy-1;

                if (energy<=0  ){
                    matrix[rowP][colP]='X';
                    System.out.println("Paris died at "+rowP+";"+colP+".");
                    break;
                }
                if (matrix[rowP][colP]=='H'){
                    matrix[rowP][colP]='-';
                    System.out.println("Paris has successfully abducted Helen! Energy left: "+energy);
                    break;
                }
                if (matrix[rowP][colP]=='S'){
                    energy=energy-2;
                    if (energy<=0){
                        matrix[rowP][colP]='X';
                        System.out.println("Paris died at "+rowP+";"+colP+".");
                        break;
                    }else {
                        matrix[rowP][colP]='-';
                    }
                }
        }

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static boolean isInBound(char[][] matrix, int row, int col){
        if (row>=0 && row <= matrix.length-1 && col>=0 && col<= matrix.length-1){
            return true;
        }
        return false;
    }
}
