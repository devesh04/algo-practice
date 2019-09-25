package geeksforgeek.vi;

/**
 * Created by devesh on 19/06/19.
 */
public class CheckIfSubArray {

    static boolean isSubArray(int [] main, int[] sub){
        int i = 0;
        int j = 0;

        while( i < main.length && j < sub.length){
            if(main[i] == sub[j]){
                if(j == sub.length - 1){
                    return true;
                }
                i++;
                j++;
            }
            else{
                i++;
                j=0;
            }
        }

        return false;
    }

    public static void main(String ar[]){
        int a [] = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int b[] = new int[]{2};
        System.out.println(isSubArray(a, b));
    }

}
