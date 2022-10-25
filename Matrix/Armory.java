package Matrix;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i <n ; i++) {
            matrix[i]= scanner.nextLine().toCharArray();
        }
        int myRow=0;
        int myCol=0;
        int firstRow=0;
        int firstCol=0;
        int count=0;
        int secondRow=0;
        int secondCol=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='A'){
                    myRow=i;
                    myCol=j;
                }
                if (matrix[i][j]=='M'&&count==0){
                    count++;
                    firstRow=i;
                    firstCol=j;
                }
                if (matrix[i][j]=='M'&&count==1){
                    secondRow=i;
                    secondCol=j;
                }

            }
        }
        boolean out =false;
        int swords=0;
        while (swords<65){
            String command = scanner.nextLine();

            matrix[myRow][myCol]='-';
            switch (command){
                case "up":
                    myRow=myRow-1;
                    break;
                case "down":
                    myRow=myRow+1;
                    break;
                case "right":
                    myCol=myCol+1;
                    break;
                case "left":
                    myCol=myCol-1;
                    break;
            }
            if (isInBounds(matrix,myRow,myCol)){
                if(myRow==firstRow&&myCol==firstCol){
                    matrix[myRow][myCol]='-';
                    myRow= secondRow;
                    myCol=secondCol;
                }else if (myRow==secondRow&&myCol==secondCol){
                    matrix[myRow][myCol]='-';
                    myRow=firstRow;
                    myCol=firstCol;
                }else if (Character.isDigit(matrix[myRow][myCol])){
                    swords+= Integer.parseInt(String.valueOf(matrix[myRow][myCol]));
                }

                matrix[myRow][myCol]='A';
            }else {
                out=true;
                break;
            }
        }
        if (out){
            System.out.println("I do not need more swords!");
        }
        if (swords>=65){
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid "+swords+" gold coins.");
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
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
