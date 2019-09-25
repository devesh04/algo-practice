package dynamic_prog;

/**
 * Created by devesh on 12/07/19.
 */
public class NumWaysStairs {


    public static int logic(int  n) {
        int [] memo = new int[n+1];
        for(int i = 0; i < memo.length; i++){
            memo[i] = -1;
        }
        return numWays(n, memo);
    }

    private static int numWays(int stairsLeft, int[] memo){

        if(memo[stairsLeft] != -1){
            return memo[stairsLeft];
        }

        if(stairsLeft < 0){
            return 0;
        }

        if(stairsLeft == 0){
            return 1;
        }

        int i = numWays(stairsLeft - 1, memo);
//        System.out.println(i);
        if(stairsLeft >= 2){
//            System.out.println(i1  + "  asda");
            i+=numWays(stairsLeft-2, memo);
        }

        memo[stairsLeft] = i;

        return i;
    }


    public static void main(String []st){

        int logic = logic(1);
        System.out.println(logic);
         logic = logic(3);
        System.out.println(logic);
         logic = logic(4);
        System.out.println(logic);
    }
}
