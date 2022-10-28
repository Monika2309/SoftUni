package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine();
        Pattern pattern=Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();
        String input2 = scanner.nextLine();
        int maxLength = 0;
        while (!input2.equals("END")){
            list.add(input2);
            if (input2.length()>maxLength){
                maxLength=input2.length();
            }
            input2=scanner.nextLine();
        }
        char[][] matrix = new char[list.size()][maxLength];
        for (int i = 0; i <list.size() ; i++) {
            String str = list.get(i);
            int count=0;
            if (list.get(i).length()<maxLength){
                count=maxLength-str.length();
            }
            for (int j = 0; j <str.length() ; j++) {
                char c = str.charAt(j);
                matrix[i][j]=c;

            }
            for (int j = 0; j < count; j++) {
                matrix[i][str.length()+j]=' ';
            }
        }
        int match=0;
        if (matcher.find()) {
           match = Integer.parseInt(matcher.group())%360;
        }
        switch (match){
            case 90:
                for (int col = 0; col <maxLength; col++) {
                    for (int row = matrix.length-1; row >=0 ; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length-1; row >=0 ; row--) {
                    for (int col = maxLength-1; col >=0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
            case 270:
                for (int col = maxLength-1; col >=0; col--) {
                    for (int row = 0; row < matrix.length ; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 0:
                for (int i = 0; i <matrix.length ; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
