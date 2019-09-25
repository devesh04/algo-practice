package algos.sorting;

/**
 * Created by devesh on 15/05/19.
 */
public abstract class Sorter implements ISorter {


    void print(int [] ar){
        for(int i = 0; i < ar.length; i++){
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }

    void swap(int[] ar, int i, int j){
        int i1 = ar[i];
        ar[i] = ar[j];
        ar[j] = i1;
    }
}
