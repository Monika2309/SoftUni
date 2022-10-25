package Matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int length = 1;
        int n = Integer.parseInt(scanner.nextLine());
        List<String> listOfCommands= Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        char[][] matrix = new char[n][n];
        for (int i = 0; i <n ; i++) {
            String[] arr= scanner.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j]=arr[j].charAt(0);
            }
        }
        int row = 0;
        int col=0;
        int countFood=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='s'){
                    row=i;
                    col=j;
                }
                if (matrix[i][j]=='f'){
                    countFood++;
                }
            }
        }
        boolean killed=false;
        for (int i = 0; i <listOfCommands.size() ; i++) {
            String command = listOfCommands.get(i);
            matrix[row][col]='*';
            switch (command){
                case "up":
                    row--;
                    if (row<0){
                        row= matrix.length-1;
                    }
                    break;
                case "down":
                    row++;
                    if (row> matrix.length-1){
                        row = 0;
                    }
                    break;
                case "right":
                    col++;
                    if (col> matrix.length-1){
                        col=0;
                    }
                    break;
                case "left":
                    col--;
                    if (col<0){
                        col= matrix.length-1;
                    }
                    break;
            }
            if (matrix[row][col]=='f'){
                length++;

            }else if (matrix[row][col]=='e'){
                System.out.println("You lose! Killed by an enemy!");
                killed=true;
                break;
            }
            if (countFood==length-1){
                System.out.println("You win! Final python length is "+length);
                break;
            }
        }
        if(!killed && countFood>length-1){
            int left = countFood-(length-1);
            System.out.println("You lose! There is still "+left+" food to be eaten.");
        }
    }
}
