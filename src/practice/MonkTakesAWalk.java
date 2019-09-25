package practice;


import util.commons.Executable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by devesh on 03/09/18.
 */
public class MonkTakesAWalk implements Executable {

    public void execute(){

        Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.nextLine());

        Set<Character> set = new HashSet();
        for(char ch : "aeiouAEIOU".toCharArray()){
            set.add(ch);
        }

        for(int i = 0; i < testCases; i++){
            int count = 0;
            String s1 = s.nextLine();
            for(int j = 0; j < s1.length(); j++){
                if(set.contains(s1.charAt(j))){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
