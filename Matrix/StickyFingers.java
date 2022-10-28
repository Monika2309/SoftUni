package MultidimensionalArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> commands= Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }
        int currentRow=0;
        int currentCol = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='D'){
                    currentRow=i;
                    currentCol=j;
                }
            }
        }
        int wallet =0;
        boolean caught = false;
        for (int i = 0; i < commands.size() ; i++) {
            switch (commands.get(i)){
                case "up":
                    if (currentRow-1>=0){
                        matrix[currentRow][currentCol]='+';
                        currentRow--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (currentRow+1< matrix.length){
                        matrix[currentRow][currentCol]='+';
                        currentRow++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (currentCol+1<matrix[currentRow].length){
                        matrix[currentRow][currentCol]='+';
                        currentCol++;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (currentCol-1>=0){
                        matrix[currentRow][currentCol]='+';
                        currentCol--;
                    }else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            if (matrix[currentRow][currentCol]=='P'){
                matrix[currentRow][currentCol]='#';
                caught=true;
                break;
            } else if (matrix[currentRow][currentCol]=='$') {
                int sum =currentCol*currentRow;
                wallet+=sum;
                System.out.println("You successfully stole "+sum+"$.");
            }
            matrix[currentRow][currentCol]='D';
        }
        if (caught){
            System.out.println("You got caught with "+wallet+"$, and you are going to jail.");
        }else {
            System.out.println("Your last theft has finished successfully with " + wallet + "$ in your pocket.");
        }
        for (char[] r:matrix) {
            for (char c:r) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
