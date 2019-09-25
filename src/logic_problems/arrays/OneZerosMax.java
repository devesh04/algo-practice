package logic_problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devesh on 02/07/19.
 */
public class OneZerosMax {

    public static void main(String ar[]){
        System.out.println(logic(new int[]{0, 0, 1, 0, 1, 0, 0}));

    }

    private static int logic(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int endingIndex = -1;

        for(int i = 0; i < arr.length; i++){
            sum = sum + (arr[i] == 0? -1 : 1);
            if(map.containsKey(sum)){
                if(max < (i - map.get(sum))){
                    max = (i - map.get(sum));
                    endingIndex = i;
                }
            }
            else{
                map.put(sum, i);
            }
        }

        if(endingIndex == -1){
            System.out.println("No");
        }
        else{
            System.out.println((endingIndex - max + 1) + " : " + endingIndex);
        }

        return max;
    }

}
