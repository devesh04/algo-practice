package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Megazine {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        
        Map<String, Integer> magMap = new HashMap<String, Integer>();

        for(String s : magazine){

            for(Character c : s.toCharArray()){

            }
            if(magMap.containsKey(s)){
                magMap.put(s, magMap.get(s)+1);
            }
            else{
                magMap.put(s, 1);
            }
        }


        for(String s: note){
            Integer count = magMap.get(s);
            if(count == null || count == 0){
                System.out.println("No");
                return;
            }
            else{
                magMap.put(s, count--);
            }
        }

        System.out.println("Yes");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        String[] mn = scanner.nextLine().split(" ");
//
//        int m = Integer.parseInt(mn[0]);
//
//        int n = Integer.parseInt(mn[1]);
//
//        String[] magazine = new String[m];
//
//        String[] magazineItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < m; i++) {
//            String magazineItem = magazineItems[i];
//            magazine[i] = magazineItem;
//        }
//
//        String[] note = new String[n];
//
//        String[] noteItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            String noteItem = noteItems[i];
//            note[i] = noteItem;
//        }

        checkMagazine(new String []{"hello", "hello", "hello"}, new String []{"hello"});

//        scanner.close();
    }
}