package scratch;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
         int turn = 0;
         if(p == 1 || p == n){
             return 0;
         }
         int currentTurns = 0; 
         if(p <= n/2){
            int currentPage1 = 0;
            int currentPage2 = 1; 
            while(currentPage1 != p && currentPage2 != p){
                currentPage1 = currentPage2 + 1;
                currentPage2 = currentPage1 + 1;
                currentTurns++;
            }
         }
         else{
            int currentPage1 = n%2 == 0 ? n : n-1;
            int currentPage2 = n%2 == 0 ? n+1 : n;
            while(currentPage1 != p && currentPage2 != p){
                currentPage1 = currentPage1 - 2;
                currentPage2 = currentPage1 + 1;
                currentTurns++;
            }
         }

         return currentTurns;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int result = pageCount(6, 4);
        System.out.println(result);


    }
}
