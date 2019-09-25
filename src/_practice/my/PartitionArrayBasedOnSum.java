package _practice.my;

/**
 * Created by devesh on 30/07/19.
 */
public class PartitionArrayBasedOnSum {

    public static boolean isPartitionPossible(int arr[]){
        return recur(arr, 0, 0, 0);
    }

    private static boolean recur(int [] arr, int index, int set1, int set2){
        if(index == arr.length){
            return set1 == set2;
        }
        if(index > arr.length){
            return false;
        }
        return recur(arr, index+1, set1+arr[index], set2) || recur(arr, index+1, set1, set2+arr[index]);
    }

    public static void main(String ar[]){
        System.out.println(isPartitionPossible(new int[]{1, 11, 5, 5}));
    }

}
