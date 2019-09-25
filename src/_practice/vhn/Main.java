package _practice.vhn;

import java.util.*;

/**
 * Created by devesh on 03/11/18.
 */
public class Main {



//         6
//         2
//         10
//         1 8 4 5 2 0


    public static void execute(){
        Scanner s = new Scanner(System.in);

        int arraySize = Integer.parseInt(s.nextLine());
        int newArraySize = Integer.parseInt(s.nextLine());
        int sumOfArray = Integer.parseInt(s.nextLine());
        String [] _array = s.nextLine().split("\\s");
        int [] array = new int[arraySize];

        for(int i = 0; i<arraySize; i++){
            array[i] = Integer.parseInt(_array[i]);
        }

        List<Integer> list = new ArrayList<>();

        recursive(array, array.length, sumOfArray, list, newArraySize);
    }

    private static boolean recursive(int arr[], int lenArr, int remainingSum, List<Integer> result, int k){

        if(result.size() > k){
            return false;
        }
        if(remainingSum < 0){
            return false;
        }
        if(lenArr < 1){
            return false;
        }
        if(result.size() == k && remainingSum == 0){
            Collections.sort(result);
            System.out.println(Arrays.toString(result.toArray()));
            return true;
        }

        int i = arr[lenArr - 1];
        if(i > remainingSum){
            recursive(arr, lenArr - 1, remainingSum, result, k);
        }
        else{
            ArrayList<Integer> integers = new ArrayList<>(result);
            integers.add(i);
            return  recursive(arr, lenArr - 1, remainingSum - i, integers, k) ||
            recursive(arr, lenArr - 1, remainingSum, result, k);
        }
        return false;
    }


    public static void main(String args[]){
        execute();
    }
}
