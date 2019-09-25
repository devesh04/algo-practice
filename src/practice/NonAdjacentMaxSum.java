package practice;

import java.io.IOException;
import java.util.Scanner;

public class NonAdjacentMaxSum {

    // Complete the maxSubsetSum function below.
    public static int maxSubsetSum(int[] arr) {
        int [] copy = new int[arr.length];

        if (arr.length == 0) return 0;
        copy[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        copy[1] = Math.max(copy[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            copy[i] = Math.max(copy[i-1], arr[i]+copy[i-2]);
        return copy[arr.length-1];
    }


//    static int maxSubsetSum(int[] arr) {
//
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < arr.length; i++) {
//            int recur = recur(arr, i, 0, Integer.MIN_VALUE, 0);
////            System.out.println(recur);
//            max = Math.max(max, recur);
//        }
//
//        return max;
//    }
//
//    static int recur(int [] arr, int i, int currentSum, int maxSum, int level){
//
//        if(i >= arr.length){
//            return currentSum;
//        }
//
////        if(level != 0)
//        currentSum = currentSum + arr[i];
//
////        System.out.println("current sum" + currentSum);
//
//        if(level != 0)
//            maxSum = Math.max(maxSum, currentSum);
//
////        System.out.println("current max" + maxSum);
//
//
//        for(int j = i+1; j < arr.length; j++){
//            if(j == i+1){
//                continue;
//            }
//
////            System.out.println("using max sum - " + maxSum);
//            int sum = recur(arr, j, currentSum, maxSum, 1);
//            maxSum = Math.max(maxSum, sum);
////            System.out.println("setting max sum - " + maxSum);
//        }
////        System.out.print(currentSum + " " + maxSum + "\t") ;
////        maxSum = Math.max(maxSum, currentSum);
//        return maxSum;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

//        5
//        3 5 -7 8 10

//        5
//        3 7 4 6 5

        int res = maxSubsetSum(arr);

        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
