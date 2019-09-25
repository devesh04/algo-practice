package hackerrank.unsorted;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MaxSubArray {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        
        // int [] copy = Arrays.copyOf(arr, arr.length);
        // Arrays.sort(copy);

        // if(copy[copy.length-1] <= 0){
        //     return new int[]{copy[copy.length-1], copy[copy.length-1]};
        // }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int maxSubSum = -100000;
        for(int i = 0; i < arr.length; i++){
            currSum = Math.max(currSum+arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
            
            
            maxSubSum = Math.max(maxSubSum, Math.max(maxSubSum+arr[i], arr[i]));
        }

        return new int[]{maxSum, maxSubSum};


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
