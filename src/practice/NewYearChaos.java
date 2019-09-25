package practice;

import java.util.Scanner;

public class NewYearChaos {

    static void minimumBribes(int[] q) {

        int bribes = 0;
        for(int i = 0; i < q.length; i++){

            if(q[i] > i+1+2){
                System.out.println("Too chaotic");
                return;
            }

            for(int j=Math.max(0, q[i]-2); j < i; j++){
                if(q[j] > q[i]){
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    // Complete the minimumBribes function below.
//    static void minimumBribes(int[] q) {
//        int bribes = 0;
//        for(int i = 0; i < q.length;){
//            int currentShould = i+1;
//            if(q[i] == currentShould){
//                i++;
//                continue;
//            }
////            System.out.println(">>" + (q[i] - currentShould));
//            if((q[i] - currentShould > 2)){
//                System.out.println("Too chaotic");
//                return;
//            }
//            else{
//                bribes = bribes + (q[i] - currentShould);
//
//                shift(q, i, q[i] -1);
////                int temp = q[q[i] -1];
////                q[q[i] -1] = q[i];
////                q[i] = temp;
//            }
//        }
//
//        System.out.println(bribes);
//
//    }

    private static void shift(int a[], int i, int j){
        int pointer = i;
        int temp =  a[pointer];
        while(pointer != j){
            a[pointer] = a[pointer+1];
            pointer++;
        }
        a[pointer] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
