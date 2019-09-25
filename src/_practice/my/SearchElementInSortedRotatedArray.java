package _practice.my;

/**
 * Created by devesh on 30/07/19.
 */
public class SearchElementInSortedRotatedArray {

    public static int search(int[] arr, int k){
        if(arr.length == 0){
            return -1;
        }
        int i = pivotIndex(arr);
        if(arr[i] == k){
            return i;
        }
        if(k >= arr[0] && arr[i] <= k){
            return binarySearch(arr, k, 0, i);
        }
        else{

            return binarySearch(arr, k, i, arr.length-1);
        }
    }

    public static int binarySearch(int[] arr, int k, int start, int end){

        if(start > end){
            return -1;
        }

        int i = (start+end)/2;

        if(arr[i] == k){
            return i;
        }

        else if(arr[i] > k){
            return binarySearch(arr, k, start, i);
        }
        else{
            return binarySearch(arr, k, i+1, end);
        }
    }

    private static int pivotIndex(int arr[]){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String ar[]){
        int search = search(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 9);
        System.out.println(search);
    }

}
