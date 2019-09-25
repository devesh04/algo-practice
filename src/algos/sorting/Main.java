package algos.sorting;

/**
 * Created by devesh on 15/05/19.
 */
public class Main {

    public static void main(String args[]){
        ISorter sorter = new SelectionSort();

        int [] ar = new int[]{10, 1, 5, 6, 8, 5, 3, 9, 4, 2, 7};
        sorter.sort(ar);
    }

}
