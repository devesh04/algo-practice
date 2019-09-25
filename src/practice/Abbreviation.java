package practice;

import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        boolean recur = recurto(a, b, 0);
        if(recur){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    static boolean recurto(String a, String match, int i){
        if(i >= a.length()){
            return false;
        }

        if(a.equalsIgnoreCase(match)){
            return true;
        }

        while(!isSmallChar(a.charAt(i))){
            i++;
        }

        return recurto(a, match, i++) || recurto(a.substring(0,i) + a.substring(i+1), match, i);

    }
























    static boolean isSmallChar(char c){
        return c >='a' && c <='z';
    }

    static boolean recur(String a, String b){

        if(a.equalsIgnoreCase(b)){
            return true;
        }

        for(int i = 0; i < a.length(); i++){
            if(isSmallChar(a.charAt(i))){
                System.out.println(a.substring(0, i) + a.substring(i));
                boolean recur = recur(a.substring(0, i) + a.substring(i+1), b);
//                boolean recur2 = recur(a, b);
                return recur;
            }
            else{
                continue;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();
//
        scanner.close();
    }
}
