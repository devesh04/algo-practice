package algos.sorting;

/**
 * Created by devesh on 15/05/19.
 */
// Find the minimum element in arr[0...4]
// and place it at beginning
public class SelectionSort extends Sorter {

    @Override
    public void sort(int[] a) {

        int j = 0;
        for(int i = 0; i< a.length; i++){
            int min = Integer.MAX_VALUE;
            int minValue = Integer.MAX_VALUE;
            for(int z= j; z < a.length; z++){
                if(minValue > a[z]){
                    min = z;
                    minValue = a[z];
                }
            }
            swap(a, j, min);
            j++;
        }

        print(a);
    }
}
