package hackerrank.prep_kit.search;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/making-candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

*/

public class MakingCandies {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
//        return getPassesRecur(m, w, p, n, 0, 0);

        long c = 0, pass = 0;

        long minPasses = Long.MAX_VALUE;
        while(c < n){
            if(c - p >= 0){
                if(w > m){
                    m++;
                }
                else{
                    w++;
                }
                c = c-p;

                minPasses = Math.min(pass + minPasses, pass + ((n - c)/(m*w)));
            }
            else{
                c = c + (m*w);
                pass++;

//                pass = pass + ((p - c) / (m * w));
//                System.out.println(pass);
//                c = c + (m*w)*(((p - c) / (m * w)));
//                minPasses = Math.min(minPasses, (n - c)/(m*w));
            }
        }

        return minPasses;
    }

//    static long getPassesRecur(long m, long w, long p, long n, long c, long pass){
//
//        if(c >= n){
//            return pass;
//        }
////        System.out.println(c);
//
////        long cc = getPassesRecur(m, w, p, n, c + (w*m), pass+1);
//
//        long aa = Long.MAX_VALUE;
//        long bb = Long.MAX_VALUE;
//        long cc = Long.MAX_VALUE;
//        if(c-p >= 0){
//            if(w > m){
//                aa = getPassesRecur(m + 1, w, p, n, c - p, pass);
//            }
//            else{
//                bb = getPassesRecur(m, w+1, p, n, c - p, pass);
//            }
//        }
//        else{
//            cc = getPassesRecur(m, w, p, n, c + (w*m), pass+1);
//        }
//
//
//
//
//        return Math.min(Math.min(aa, bb), cc);
//
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
