package online.am;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by devesh on 22/07/19.
 */
public class One {


    public static int logic(int numOfParts, List<Integer> parts){

        PriorityQueue<Integer> integers = new PriorityQueue<>(parts);
        int sum = 0;
        while(integers.size() != 1){
            Integer poll = integers.poll();
            Integer poll2 = integers.poll();
            int newSum = poll+poll2;
            sum = sum + newSum;
            integers.add(newSum);
        }
        return sum;

    }
    public static void main(String ar[]){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(10);
        list.add(35);
        list.add(89);

        System.out.println(logic(6, list));

//        Scanner in = new Scanner(System.in);
//
//
//        int testCases = in.nextInt();
//
//        String next = in.nextLine();
//        int[] ints = Arrays.stream(next.split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
}
