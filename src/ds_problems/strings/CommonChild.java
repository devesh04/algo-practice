package ds_problems.strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        return recurOpto(s1, s2);
    }

    static int getValue(int [][] mat, int i, int j){
        if(i >= 0 &&  j >= 0){
            return mat[i][j];
        }
        return 0;
    }

    static int getPrevMax(int [][] mat, int i, int j){
//        int max = getValue(mat, i - 1, j - 1);
        int max = 0;
        max = Math.max(max, getValue(mat, i-1, j));
        max = Math.max(max, getValue(mat, i, j-1));
        return max;
    }

    static int recurOpto(String s1, String s2){
        int [][] mat = new int[s1.length()][s2.length()];

        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                char a = s1.charAt(j);
                char b = s2.charAt(i);

                if (a == b) {
                    mat[i][j] = 1 + getValue(mat, i-1, j-1);
                } else {
                    mat[i][j] = getPrevMax(mat, i, j);
                }
            }
        }

//        for(int z = 0; z < mat.length; z++){
//            for(int j = 0; j < mat[z].length; j++){
//                System.out.print( " " + mat[z][j]);
//            }
//            System.out.println();
//        }

        return mat[s1.length() -1][s2.length() -1];
    }

    static int recurNaive(String s1, String s2, int i, int j){

        if(i == -1 || j == -1){
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + recurNaive(s1, s2, i-1, j-1);
        }

        return Math.max(recurNaive(s1, s2, i-1, j), recurNaive(s1, s2, i, j-1)) ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
