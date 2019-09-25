package hackerrank.prep_kit.recursions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking

Davis has a number of staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module  on a new line.

For example, there is  staircase in the house that is  steps high. Davis can step on the following sequences of steps:
 */


public class StairCases {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        long [] memo = new long[n+1];
        Arrays.fill(memo, -1l);

        long res = ways(n, memo);

        long l = res % 10000000007l;
        return (int)l;

    }

    static long ways(int n, long [] memo){

        if(n < 0){
            return 0l;
        }
        if(n == 0){
            return 1l;
        }
        if(memo[n] != -1){
            return memo[n];
        }

        long l = ways(n - 1, memo) + ways(n - 2, memo) + ways(n - 3, memo);
        memo[n] = l;
        return l;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
