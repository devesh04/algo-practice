package dynamic_prog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {

     long sum = 1;
     long count = 2;

     for(int i = 1; i<arr.length-1; i++){

         if(arr[i] == arr[i-1]){
             sum ++;
             if(arr[i] < arr[i+1]){
                 count++;
             }
             else{
                 count = 1;
             }
         }
         else if(arr[i] > arr[i-1] && arr[i] >= arr[i+1]){
             sum += count;
             count = 1;
         }
         else{
             sum += count;
             count++;

         }
     }

     sum += count;

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
