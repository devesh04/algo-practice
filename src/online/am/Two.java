package online.am;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by devesh on 22/07/19.
 */
public class Two {

    public static void main(String ar[]){

        Scanner in = new Scanner(System.in);


        int testCases = in.nextInt();

        String next = in.nextLine();
        int[] ints = Arrays.stream(next.split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
}
