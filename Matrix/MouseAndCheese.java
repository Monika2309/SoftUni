package Matrix;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i]= scanner.nextLine().toCharArray();
        }
        int rowM = 0;
        int colM = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='M'){
                    rowM=i;
                    colM=j;
                }
            }
        }
        int amountEatenCheese= 0;
        String command = scanner.nextLine();
        while (!command.equals("end")){
            matrix[rowM][colM]='-';
            switch (command){
                case "up":
                    rowM--;
                    break;
                case "down":
                    rowM++;
                    break;
                case "right":
                    colM++;
                    break;
                case "left":
                    colM--;
                    break;
            }
            if (isInBounds(matrix,rowM,colM)){
                if (matrix[rowM][colM]=='c'){
                   amountEatenCheese++;
                   matrix[rowM][colM]='M';
                } else if (matrix[rowM][colM]=='B') {
                    continue;
                }else {
                    matrix[rowM][colM]='M';
                }
            }else {
                System.out.println("Where is the mouse?");
                break;
            }
            command=scanner.nextLine();
        }
        if (amountEatenCheese>=5){
            System.out.println("Great job, the mouse is fed "+amountEatenCheese+" cheeses!");
        }else {
            int needed= 5-amountEatenCheese;
            System.out.println("The mouse couldn't eat the cheeses, she needed "+needed+" cheeses more.");
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }
    }
    private static boolean isInBounds(char[][] matrix, int row, int col){
        if (row>=0 && row <= matrix.length-1 && col>=0 && col<= matrix.length-1){
            return true;
        }
        return false;
    }
}
