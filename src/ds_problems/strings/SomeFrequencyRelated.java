package ds_problems.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SomeFrequencyRelated {

    // Complete the isValid function below.
    static String isValid(String s) {

        int [] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }   

            if(map.size() > 2){
                return "NO";
            }
        }


        if(map.size() == 1){
            return "YES";
        }

        int i = 0; 
        int [][] mat = new int[2][2];
        int indexOfBigFrequency = -1;
        int maxValue = -1;
        for(Integer j : map.keySet()){
            mat[i][0] = j;
            mat[i][1] = map.get(j);
            if(maxValue < map.get(j)){
                maxValue = map.get(j);
                indexOfBigFrequency = i;
            }
            i++;
        }

        if(indexOfBigFrequency == -1){
            return "NO";
        }

//        mat[indexOfBigFrequency][1] == mat[(indexOfBigFrequency+1)%2][1]+1
//                ||
        return mat[(indexOfBigFrequency+1)%2][1] == 1
                ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
