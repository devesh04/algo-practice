package practice;


import util.commons.Executable;

import java.util.Scanner;


/**
 * Created by devesh on 03/09/18.
 */
public class BreakupApp implements Executable {

    public void execute(){

        int testCases = Utils.noOfTestCases();
        int [] arr = new int [30];
        for(int i = 0; i < testCases; i++){
            String[] split = Utils.readLine().split("\\s");
            int weitage = split[0].equals("G:") ? 2 : 1;
            for(String sp : split){
                if(sp.length() == 2 || sp.length() == 1){

                }
                else {
                    continue;
                }
                if(sp.charAt(0) == '1' || sp.charAt(0) == '2' || sp.charAt(0) == '3'){
                    try{
                        int i1 = Integer.parseInt(sp);
                        arr[i1 -1] = arr[i1 -1] + weitage;
                    }
                    catch (NumberFormatException e){
                        continue;
                    }
                }
            }
        }

        int maximumIndex = -1;
        int maximumCount = -1;
        for(int i = 0; i < arr.length; i++){
            if(maximumCount > 0 && maximumCount == arr[i]){
                System.out.println("No Date");
                return;
            }
            else if(maximumCount < arr[i]){
                maximumCount = arr[i];
                maximumIndex = i;
            }
        }

        if(maximumIndex == 18 || maximumIndex == 19){
            System.out.println("Date");
        }
        else{
            System.out.println("No Date");
        }

    }

    public static class Utils {

        static Scanner s = new Scanner(System.in);

        public static int noOfTestCases(){
            return (int) s.nextLong();
        }
        public static String readLine(){
            return s.nextLine();
        }
    }

}
