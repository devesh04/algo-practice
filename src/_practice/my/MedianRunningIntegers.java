package _practice.my;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by devesh on 30/07/19.
 */
public class MedianRunningIntegers {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();


    public void add(Integer a){
        Integer peek = left.peek();
        if(peek == null || a < peek){
            left.add(a);
        }
        else{
            right.add(a);
        }
        rebalance(left, right);
    }

    private void rebalance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if(left.size() - right.size() >= 2){
            right.add(left.poll());
        }
        else if(right.size() - left.size() >= 2){
            left.add(right.poll());
        }
    }

    public Double getMedian(){
        if(right.size() == left.size()){
            return (double)(right.peek() + left.peek()) / 2;
        }
        else if(right.size() > left.size()){
            return (double)right.peek();
        }
        else{
            return (double)left.peek();
        }
    }


    public static void main(String ar[]){
        MedianRunningIntegers integers = new MedianRunningIntegers();
        integers.add(100);
        System.out.println(integers.getMedian());

        integers.add(2);
        System.out.println(integers.getMedian());

        integers.add(3);
        System.out.println(integers.getMedian());

        integers.add(4);
        System.out.println(integers.getMedian());

        integers.add(5);
        System.out.println(integers.getMedian());

        integers.add(600);
        System.out.println(integers.getMedian());


//        integers.add(20);
//        System.out.println(integers.getMedian());


//        integers.add(400);
//        System.out.println(integers.getMedian());

    }

}
