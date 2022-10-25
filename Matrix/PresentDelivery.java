package Matrix;

import java.util.*;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int presents = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int countPresents=presents;
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] =scanner.nextLine().replace(" ","").toCharArray();
        }
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int row = 0;
        int col=0;
        int countNiceKids=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='S'){
                    row=i;
                    col=j;
                }
                if (matrix[i][j]=='V'){
                    countNiceKids++;
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Christmas morning")){
            matrix[row][col]='-';
            int oldRow = row;
            int oldCol = col;
            switch (input){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
            }
            if (matrix[row][col]=='V'){
                countPresents--;
            }else if (matrix[row][col]=='C'){
                if (matrix[row+1][col]=='V' || matrix[row+1][col]=='X' ){
                    matrix[row+1][col]='-';
                    countPresents--;
                    if (!map.containsKey(row+1)){
                        map.put(row+1,new ArrayList<>());
                    }
                    map.get(row+1).add(col);
                }
                if (matrix[row-1][col]=='V' || matrix[row-1][col]=='X' ){
                    matrix[row-1][col]='-';
                    countPresents--;
                    if (!map.containsKey(row-1)){
                        map.put(row-1,new ArrayList<>());
                    }
                    map.get(row-1).add(col);
                }
                if (matrix[row][col+1]=='V' || matrix[row][col+1]=='X' ){
                    matrix[row][col+1]='-';
                    countPresents--;
                    if (!map.containsKey(row)){
                        map.put(row,new ArrayList<>());
                    }
                    map.get(row).add(col+1);
                }
                if (matrix[row][col-1]=='V' || matrix[row][col-1]=='X' ){
                    matrix[row][col-1]='-';
                    countPresents--;
                    if (!map.containsKey(row)){
                        map.put(row,new ArrayList<>());
                    }
                    map.get(row).add(col-1);
                }
            }
            matrix[row][col]='S';
            if (countPresents<=0){
                System.out.println("Santa ran out of presents!");
                break;
            }
            input=scanner.nextLine();
        }
        int countLeft = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]=='V'){
                    countLeft++;
                }
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        if (countLeft>0){
            System.out.println("No presents for "+countLeft+" nice kid/s.");
        }else {
            int result = presents-countPresents;
            System.out.println("Good job, Santa! "+result+" happy nice kid/s.");
        }
    }
}
