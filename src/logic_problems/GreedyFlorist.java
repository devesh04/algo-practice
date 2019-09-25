package logic_problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, Integer[] c) {

        Arrays.sort(c, Collections.reverseOrder());

        int j = 1, totalSum = 0;
        int currentFactor = 1;

        for(int i = 0; i < c.length; i++){
            totalSum += (c[i] * currentFactor);

            if(j == k){
                j= 1;
                currentFactor++;
            }
            else{
                j++;
            }
        }
        return totalSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        Integer[] c = new Integer[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);

//        bufferedWriter.write(String.valueOf(minimumCost));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
