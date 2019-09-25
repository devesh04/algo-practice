package practice;


import util.commons.Executable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by devesh on 03/09/18.
 */
public class PoliceAndTheif implements Executable {

    public void execute() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            char[][] A = new char[N][N];
            for(int i_A=0; i_A<N; i_A++)
            {
                String[] arr_A = br.readLine().split(" ");
                for(int j_A=0; j_A<arr_A.length; j_A++)
                {
                    A[i_A][j_A] = arr_A[j_A].charAt(0);
                }
            }

            int out_ = solution(A, K);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();

    }

    static int solution(char[][] A, int K){
        // Write your code here
        int count = 0;
        for(int i = 0; i < A.length; i++){
            List<Character> queu = new ArrayList<>();
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] == 'P'){
//                    System.out.println(A[i][j] + "  " +queu);
                    if(queu.contains('T')){
                        count++;
                        queu.remove(queu.indexOf('T'));
                        queu.add('F');
                        if(queu.size() > K){
                            queu.remove(0);
                        }
                    }
                    else{
                        queu.add('P');
                        if(queu.size() > K){
                            queu.remove(0);
                        }
                    }
                }
                else{
                    if(queu.contains('P')){
                        count++;
                        queu.remove(queu.indexOf('P'));
                        queu.add('F');
                        if(queu.size() > K){
                            queu.remove(0);
                        }
                    }
                    else{
                        queu.add('T');
                        if(queu.size() > K){
                            queu.remove(0);
                        }
                    }
                }
            }
        }
        return count;
    }

//    public static class Utils {
//
//        static Scanner s = new Scanner(System.in);
//
//        public static int noOfTestCases(){
//            return (int) s.nextLong();
//        }
//        public static String readLine(){
//            return s.nextLine();
//        }
//
//        public static void doIt() throws IOException {
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            PrintWriter wr = new PrintWriter(System.out);
//            int T = Integer.parseInt(br.readLine().trim());
//            for(int t_i=0; t_i<T; t_i++)
//            {
//                String[] line = br.readLine().split(" ");
//                int N = Integer.parseInt(line[0]);
//                int K = Integer.parseInt(line[1]);
//                char[][] A = new char[N][N];
//                for(int i_A=0; i_A<N; i_A++)
//                {
//                    String[] arr_A = br.readLine().split(" ");
//                    for(int j_A=0; j_A<arr_A.length; j_A++)
//                    {
//                        A[i_A][j_A] = arr_A[j_A].charAt(0);
//                    }
//                }
//
//                int out_ = solution(A, K);
//                System.out.println(out_);
//                System.out.println("");
//            }
//
//            wr.close();
//            br.close();
//        }
//    }

}
