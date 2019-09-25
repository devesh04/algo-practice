package algos.sorting;

import java.util.Arrays;

/**
 * Created by devesh on 15/07/19.
 */
public class Quick {

    public static int [] quickSort(int [] arr){
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return arr;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition-1);
        quickSort(arr, partition, right);
        return arr;
    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[(right+left)/2];
        int leftI = left;
        int rightI = right;

        while(leftI <= rightI){
            while (arr[leftI] < pivot){
                leftI++;
            }
            while (arr[rightI] > pivot){
                rightI--;
            }

            //important:
            if(leftI <= rightI){
                int temp = arr[leftI];
                arr[leftI] = arr[rightI];
                arr[rightI] = temp;
                leftI++;
                rightI--;
            }

        }
        return leftI;
    }


    public static void main(String ar[]){
//        int [] yo = new int[]{1,2,3,4,5,6};
        int [] yo = new int[]{6,5,4,1231,11,12,3,66,2,1};
        int[] ints = quickSort(yo);

        Arrays.stream(ints).forEach(System.out::println);

    }

}
