package hackerrank.unsorted;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren2 {

    // Complete the angryChildren function below.
    static long angryChildren(int k, int[] packets) {

        Arrays.sort(packets);

        long sum = 0;
        for(int i = 0; i < k-1; i++){
            for(int j=i+1; j < k; j++){
                sum+= Math.abs(packets[i] - packets[j]);
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

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] packets = new int[n];

        for (int i = 0; i < n; i++) {
            int packetsItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            packets[i] = packetsItem;
        }

        long result = angryChildren(k, packets);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
