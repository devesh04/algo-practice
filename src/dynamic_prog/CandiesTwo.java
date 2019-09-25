package dynamic_prog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CandiesTwo {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {

        if(arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return 1;
        }

        long sum = 0;
        long c = 1;
        int d = 0;
        int i = 1;
        int prev = arr[0];
        while(i < arr.length){
            if(d == 0){
                if(arr[i] > prev){
                    d = 1;
                    c++;
                }
                else if(arr[i] < prev){
                    d = -1;
                    c++;
                }
                else{
                    sum+=c;
                }
                prev = arr[i];
                i++;
            }
            else if(d == 1){
                if(arr[i] > prev){
                    c++;
                    prev = arr[i];
                    i++;
                }
                else{
                    long ss = (c*(c+1))/2;
                    sum+=ss;
                    c=1;
                    d=0;
                    prev = arr[i];
                }
            }
            else if(d == -1){
                if(arr[i] < prev){
                    c++;
                    prev = arr[i];
                    i++;
                }
                else{
                    long ss = (c*(c+1))/2;
                    sum+=ss;
                    c=1;
                    d=0;
                    prev = arr[i];
                }
            }
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
