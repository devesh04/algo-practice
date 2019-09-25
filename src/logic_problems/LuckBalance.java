package logic_problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        int important =0, totalLuck = 0;
        for(int i = 0; i < contests.length; i++){
            important+= contests[i][1];
            totalLuck+=contests[i][0];
        }

        int toNotLoose = important - k;

        Arrays.sort(contests, (x,y) -> Integer.compare(x[0], y[0]));

        for(int i =0; i < contests.length && toNotLoose > 0; i++){
            if(contests[i][1] == 1){
                totalLuck-=(2*contests[i][0]);
                toNotLoose--;
            }
        }

        return totalLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
