package ds_problems.queue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        int max = -1;

        for(int i = 0; i < h.length; i++){
            int height = h[i];
            int currentW = 1;
            int pointer = i-1;
            while(pointer >= 0 && h[pointer] >= height){
                currentW++;
                pointer--;
            }
            pointer = i+1;
            while(pointer < h.length && h[pointer] >= height){
                currentW++;
                pointer++;
            }

            max = Math.max(max, height*currentW);
        }

        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
