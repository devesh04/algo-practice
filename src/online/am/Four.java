package online.am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by devesh on 22/07/19.
 */
public class Four {

    public static List<List<Integer>> logic(int deviceCapacity, List<List<Integer>> foreground, List<List<Integer>> background){


        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);

        foreground.add(list);
        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        foreground.add(list);


        list = new ArrayList<>();
        list.add(-1);
        list.add(-799);
        foreground.add(list);

        for( List<Integer> in : foreground){
            System.out.println(in.get(0) + " " + in.get(1));
        }

        foreground.sort((x,y) -> x.get(1) > y.get(1) ? 1 : -1);

        for( List<Integer> in : foreground){
            System.out.println(in.get(0) + " " + in.get(1));
        }

        Collections.binarySearch(foreground, list, (x,y) -> x.get(1) > y.get(1) ? 1 : -1);

        return null;

    }

    public static void main(String ar[]){
    logic(1, new ArrayList<>(), null);

    }
}
