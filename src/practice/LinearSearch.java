package practice;


import util.commons.Executable;

import java.util.Scanner;

/**
 * Created by devesh on 03/09/18.
 */
public class LinearSearch implements Executable {

    public void execute(){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine(); // Reading input from STDIN
        String input2 = s.nextLine();

        String[] split = input.split("\\s");

        int arraySize = Integer.parseInt(split[0]);
        int toSearch = Integer.parseInt(split[1]);

        String [] array = input2.split("\\s");

        for(int i = arraySize - 1; i >= 0; i--){
            int i1 = Integer.parseInt(array[i]);
            if(i1 == toSearch){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("-1");
    }

}
