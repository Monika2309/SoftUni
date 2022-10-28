package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] =scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
        String input = scanner.nextLine();
        int row = 0;
        int col = 0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (matrix[i][j]=='Y'){
                    row=i;
                    col=j;
                }
            }
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!input.equals("Finish")){
            switch (input){
                case "up":
                    if (row-1>=0){
                        if (matrix[row-1][col]!='T'){
                            matrix[row][col]='-';
                            row--;
                            queue.offer(input);
                            if (matrix[row][col]=='X') {
                                input=scanner.nextLine();
                                continue;
                            }else {
                                matrix[row][col] = 'Y';
                            }
                        }
                    }
                    break;
                case "down":
                    if (row+1< matrix.length){
                        if (matrix[row+1][col]!='T'){
                            matrix[row][col]='-';
                            row++;
                            queue.offer(input);
                            if (matrix[row][col]=='X') {
                                input=scanner.nextLine();
                                continue;
                            }else {
                                matrix[row][col] = 'Y';
                            }
                        }
                    }
                    break;
                case "left":
                    if (col-1>=0){
                        if (matrix[row][col-1]!='T'){
                            matrix[row][col]='-';
                            col--;
                            queue.offer(input);
                            if (matrix[row][col]=='X') {
                                input=scanner.nextLine();
                                continue;
                            }else {
                                matrix[row][col] = 'Y';
                            }
                        }
                    }
                    break;
                case "right":
                    if (col+1< matrix[row].length){
                        if (matrix[row][col+1]!='T'){
                            matrix[row][col]='-';
                            col++;
                            queue.offer(input);
                            if (matrix[row][col]=='X') {
                                input=scanner.nextLine();
                                continue;
                            }else {
                                matrix[row][col] = 'Y';
                            }
                        }
                    }
                    break;
            }

            input=scanner.nextLine();
        }
        if (matrix[row][col]=='X'){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            while (!queue.isEmpty()){
                if (queue.size()==1){
                    System.out.println(queue.poll());
                }else {
                    System.out.print(queue.poll() + ", ");
                }
            }
        }else {
            System.out.println("The map is fake!");
        }
    }

}
