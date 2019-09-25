package dynamic_prog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Abbreviation {



    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        int pa = 0;
        int pb = 0;
        int memo[][] = new int[a.length()+1][b.length()+1];


        return recur(a, b, pa, pb, memo) ? "YES" : "NO";

    }

    static boolean recur(String a, String b, int pa, int pb, int[][] memo){

        if(memo[pa][pb] != 0){
            System.out.println("memo");
            return memo[pa][pb] == 1 ? true : false;
        }

        while(pa < a.length() && pb < b.length()){
            char ca = a.charAt(pa);
            char cb = b.charAt(pb);

            if(Character.toUpperCase(ca) == Character.toUpperCase(cb)){
                if(Character.isLowerCase(ca)){
                    boolean res = recur(a, b, pa+1, pb+1, memo) || recur(a, b, pa+1, pb, memo);
                    memo[pa][pb] = res ? 1 : -1;
                    return res;
                }
                else if(Character.isLowerCase(cb)){
                    memo[pa][pb] =  -1;
                    return false;

                }
                else{
                    pa++;
                    pb++;
                }
            }
            else if(Character.isLowerCase(ca)){
                pa++;
            }
            else{
                memo[pa][pb] =  -1;
                return false;
            }
        }

        while(pa < a.length()){
            if(Character.isLowerCase(a.charAt(pa))){
                pa++;
            }
            else{
                memo[pa][pb] =  -1;
                return false;
            }
        }

        while(pb < b.length()){
            memo[pa][pb] =  -1;
            return false;
            // if(Character.isLowerCase(b.charAt(pb))){
            //     return "NO";
            // }
            // else{
            //     return "NO";
            // }
        }

        memo[pa][pb] =  1;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
