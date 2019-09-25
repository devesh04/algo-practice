package logic_problems.arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by devesh on 01/07/19.
 * <p>
 * <p>
 * <p>
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 * <p>
 * For example, given the array  we perform the following steps:
 * <p>
 * i   arr                         swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  swaps to sort the array.
 * <p>
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * <p>
 * 4
 * 4 3 1 2
 * <p>
 * 3
 * <p>
 * -----
 * <p>
 * <p>
 * Sample Input 0
 * <p>
 * 4
 * 4 3 1 2
 * Sample Output 0
 * <p>
 * 3
 * Explanation 0
 * <p>
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 * <p>
 * <p>
 * ----
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * 2 3 4 1 5
 * Sample Output 1
 * <p>
 * 3
 * Explanation 1
 * <p>
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 * <p>
 * ------
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 7
 * 1 3 5 2 4 6 7
 * Sample Output 2
 * <p>
 * 3
 * Explanation 2
 * <p>
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 */

public class MinimumSwaps {

    // Complete the minimumSwaps function below.

    static int minimumSwaps(int[] arr) {

        int minValue = Arrays.stream(arr)
                .min()
                .getAsInt();

        int [] temp = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            temp[i] = arr[i] - i - minValue;
        }
//        int diff = diff(0, temp);
        int diff = newww(temp);
        return diff;
    }

    static int newww(int arr[]){

        int i = 0;
        int swaps = 0;
        boolean allZero = true;
        while (true){

            if(i == arr.length){
                if(allZero){
                    break;
                }
                i = 0;
                allZero = true;
            }
            int firstValue = arr[i];
            if(firstValue == 0){
                i++;
                continue;
            }
            allZero = false;
            if(firstValue > 0){
                int secondValue = arr[i+arr[i]];
                if(secondValue < 0){
                    arr[i+arr[i]] = 0;
                    arr[i] = firstValue + secondValue;
                    swaps++;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        return swaps;
    }

    static int diff(int startPoint, int arr[]){
        boolean calculateStartPoint = true;
        int swaps = 0;
        if(startPoint == arr.length){
            return swaps;
        }
        for(int i = startPoint; i < arr.length; i++){
            if(calculateStartPoint && arr[i] == 0){
                startPoint++;
                continue;
            }
            else{
                calculateStartPoint = false;
            }

            int firstValue = arr[i];
            if(firstValue <=0){
                continue;
            }
            else{
                int secondValue = arr[i+arr[i]];
                if(secondValue >= 0){
                    continue;
                }
                else{
                    arr[i+arr[i]] = 0;
                    arr[i] = firstValue + secondValue;

//                    int temp = orig[i+arr[i]];
//                    orig[i+arr[i]] = orig[i];
//                    orig[i] = temp;

                    swaps++;
                    break;
                }
            }
        }

        return swaps+diff(startPoint, arr);
    }


//    static int diff(int startPoint, int arr[]){
//        boolean calculateStartPoint = true;
//        int swaps = 0;
//        if(startPoint == arr.length){
//            return swaps;
//        }
//        for(int i = startPoint; i < arr.length; i++){
//            if(calculateStartPoint && arr[i] == 0){
//                startPoint++;
//                continue;
//            }
//            else{
//                calculateStartPoint = false;
//            }
//
//            int firstValue = arr[i];
//            if(firstValue <=0){
//                continue;
//            }
//            else{
//                int secondValue = arr[i+arr[i]];
//                if(secondValue >= 0){
//                    continue;
//                }
//                else{
//                    arr[i+arr[i]] = 0;
//                    arr[i] = firstValue + secondValue;
//
////                    int temp = orig[i+arr[i]];
////                    orig[i+arr[i]] = orig[i];
////                    orig[i] = temp;
//
//                    swaps++;
//                    break;
//                }
//            }
//        }
//
//        return swaps+diff(startPoint, arr);
//    }


//    static int minimumSwaps(int[] arr) {
//
//        Queue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
//        Queue<Integer> negatives = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i =0; i < arr.length; i++){
//            int diff = arr[i] - (i + 1);
//            if(diff > 0){
//                positives.add(diff);
//            }
//            else if(diff < 0){
//                negatives.add(diff);
//            }
//        }
//        int swap = 0;
//        while(positives.size() > 0 && negatives.size() > 0){
//            Integer positive = positives.poll();
//            Integer negative = negatives.poll();
//
//            int diff = positive + negative;
//            if(diff > 0){
//                positives.add(diff);
//            }
//            else if(diff < 0){
//                negatives.add(diff);
//            }
//            swap++;
//        }
//        return swap;
//    }



//    static int minimumSwaps(int[] arr) {
//
//        int swaps = 0;
//
//        int toStartFrom = 0;
//        boolean runWhile = true;
//        while (runWhile){
//
//            int minValue = Integer.MAX_VALUE;
//            int minIndex = 0;
//            int maxValue = Integer.MIN_VALUE;
//            int maxIndex = 0;
//
//            int add = arr.length;
//
//            for(int i = toStartFrom; i < arr.length; i++){
//
//                if(arr[i] == i+1){
//                    toStartFrom = i;
//                }
//
//                int newValue = arr[i] + add;
//                if(newValue > maxValue){
//                    maxValue = newValue;
//                    maxIndex = i;
//                }
//                if(newValue < minValue){
//                    minValue = newValue;
//                    minIndex = i;
//                }
//                add--;
//            }
//
//            if(minIndex == maxIndex){
//                break;
//            }
//
//            //swap
//            int temp = arr[maxIndex];
//            arr[maxIndex] = arr[minIndex];
//            arr[minIndex] = temp;
//            swaps++;
//
//        }
//
//        return swaps;
//
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

        int res = minimumSwaps(arr);

        System.out.println(res);
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
