package interview_practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by devesh on 12/07/19.
 */
public class RunningIntegerMedian {



    public double[] getMedian(int [] ints){

        double[] medians = new double[ints.length];

        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        for(int i = 0; i< ints.length; i++){

            addInQueue(ints[i], lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }

    private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;

        if(bigger.size() == smaller.size()){
            return ((double)bigger.peek() + smaller.peek()) / 2;
        }
        else{
            return bigger.peek();
        }
    }

    private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;

        if(bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }

    private void addInQueue(int anInt, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.size() == 0 || lowers.peek() > anInt){
            lowers.add(anInt);
        }
        else{
            highers.add(anInt);
        }
    }

    public static void main(String ar[]){

//        String s = Integer.toBinaryString(5);
//        String s1 = "";
//        for(char c : s.toCharArray()){
//            s1+=(c == '1' ? '0' : '1');
//        }
//        System.out.println(Integer.parseInt(s1, 2));

        RunningIntegerMedian median = new RunningIntegerMedian();
        double[] median1 = median.getMedian(new int[]{1, 2, 3, 4, 5});
        for(int i = 0; i < median1.length; i++){
            System.out.print(median1[i] + " ");
        }

        System.out.println();

        median1 = median.getMedian(new int[]{1, 2, 3, 4, 5, 600});
        for(int i = 0; i < median1.length; i++){
            System.out.print(median1[i] + " ");
        }

    }
}
