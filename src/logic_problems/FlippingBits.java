package logic_problems;

import java.io.IOException;
import java.util.Scanner;

public class FlippingBits {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String s1 = Long.toBinaryString(n);
        int i = s1.length();
        StringBuilder sb = new StringBuilder();
        while (i < 32){
            sb.append("0");
            i++;
        }


        sb.append(s1);
        s1 = sb.toString();

        s1 = s1.replaceAll("1", "2");
        s1 = s1.replaceAll("0", "1");
        s1 = s1.replaceAll("2", "0");

        return Long.valueOf(s1, 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
