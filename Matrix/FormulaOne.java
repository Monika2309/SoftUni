package Matrix;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i <n ; i++) {
            matrix[i]=scanner.nextLine().toCharArray();
        }
        int rowP = 0;
        int colP=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='P'){
                    rowP=i;
                    colP=j;
                }
            }
        }
        String command= scanner.nextLine();
            boolean finish=false;
        while (countOfCommands>0){

            int newRow = rowP;
            int newCol = colP;
            switch (command){
                case "up":
                    rowP--;
                    if (rowP<0){
                        rowP=n-1;
                    }

                    break;
                case "down":
                    rowP++;
                    if (rowP>= matrix.length){
                        rowP=0;
                    }
                    break;
                case "right":
                    colP++;
                    if (colP>= matrix.length){
                        colP=0;
                    }
                    break;
                case "left":
                    colP--;
                    if (colP<0){
                        colP= matrix.length-1;
                    }
                    break;
            }
            if (matrix[rowP][colP]=='B'){
                matrix[newRow][newCol]='.';
                continue;
            }else if (matrix[rowP][colP]=='T'){
                rowP=newRow;
                colP=newCol;

            }else if (matrix[rowP][colP]=='F'){
                matrix[newRow][newCol]='.';
                finish=true;
                System.out.println("Well done, the player won first place!");
                matrix[rowP][colP]='P';
                break;
            }else {
                if (matrix[newRow][newCol]!='B') {
                    matrix[newRow][newCol] = '.';
                }
                matrix[rowP][colP]='P';
            }

            countOfCommands--;
            if (countOfCommands>0) {
                command = scanner.nextLine();
            }else {
                break;
            }
        }
        if (!finish){
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
