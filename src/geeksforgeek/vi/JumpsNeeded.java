package geeksforgeek.vi;

/**
 * Created by devesh on 19/06/19.
 */
public class JumpsNeeded {

    static int getMaxJumps(int [] arr){
        int last = arr[arr.length - 1];
        int pointer = 0;
        int maxJumps = 0;
        int jumps = 0;
        while(pointer < arr.length){
            if(arr[pointer] == last){
                jumps++;
                if(maxJumps <  jumps){
                    maxJumps = jumps;
                }
                jumps = 0;
            }
            else{
                jumps = jumps + 1;
            }
            pointer++;
        }

        return maxJumps;
    }

    public static void main(String ar[]){
        int a [] = new int[]{ 1, 0, 1, 0, 1};
         a = new int[]{ 1, 1, 1, 1, 0};
        System.out.println(getMaxJumps(a));
    }

}
