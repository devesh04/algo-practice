package hackerrank.problem;

import util.annotations.Expert;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/morgan-and-a-string/problem
 */

@Expert
public class StackLexigraph {

    // Complete the morganAndString function below.
    static String morganAndString(String a, String b) {
        Queue<Character> left = new LinkedList<>();
        Queue<Character> right = new LinkedList<>();
        
        int i = 0; int j = 0;
        String res= "";
        while(i != a.length() && j != b.length()){
            if(a.charAt(i) == b.charAt(j)){
                left.add(a.charAt(i));
                right.add(a.charAt(i));
                i++;
                j++;
            }
            else if(a.charAt(i) < b.charAt(j)){
                if(left.size() == 0){
                    res+=a.charAt(i);
                    i++;
                }
                else{
                    res+=left.poll();
                }
            }
            else{
                if(right.size()== 0){
                    res+=b.charAt(j);
                    j++;
                }
                else{
                    res+=right.poll();
                }
            }
        }

        while(left.size() != 0 || right.size() != 0){
            if(left.size() > 0 && right.size() > 0){
                if(left.peek() < right.peek()){
                    res+=left.poll();
                }
                else if(left.peek() > right.peek()){
                    res+=right.poll();
                }
                else{
                    res+=left.poll();
                }
            }
            else if(left.size() > 0){
                res+=left.poll();
            }
            else{
                res+=right.poll();
            }
        }

        while (i < a.length()){
            res+=a.charAt(i);
            i++;
        }

        while (j < b.length()){
            res+=b.charAt(j);
            j++;
        }

        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = morganAndString(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
