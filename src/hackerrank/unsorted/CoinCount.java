package hackerrank.unsorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinCount {

//    public static int getCount(int[] coins, int sum){
//        int[][]dp = new int[coins.length][sum+1];
//        for(int i = 0; i < coins.length; i++){
//            dp[i][0]=1;
//        }
//        for(int i = 1; i < sum+1; i++){
//            dp[0][i]= i % coins[0] == 0 ? 1 : 0;
//        }
//
//        for(int i = 1; i < coins.length; i++){
//            for(int j = 1; j <= sum; j++){
//                int c = 0;
//                if(j - coins[i] >= 0){
//                    c = dp[i][j-coins[i]];
//                }
//                dp[i][j] = dp[i-1][j] + c;
//            }
//        }
//
//        for(int i = 0; i < dp.length; i++){
//            for(int j = 0; j < dp[i].length; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return dp[coins.length-1][sum];
//
//    }

    public static int getCount(int[] coins, int sum){
        Arrays.sort(coins);
        List<List<Integer>> lists = new ArrayList<>();
        int[] res = new int[1];
        back(coins, 0, sum, new ArrayList<>(), res, 0, lists);
        int c = 0;
        for(int i = 0; i < coins.length; i++){
            if(sum % coins[i] == 0){
                c++;
            }
        }

        for(List<Integer> li : lists){
            li.forEach(System.out::print);
            System.out.println();
        }
        return res[0]+c;
    }

    private static void back(int[] coins, int cur, int sum, List<Integer> list, int[] res, int z, List<List<Integer>> lists){
        if(cur > sum){
            return;
        }
        if(cur == sum){
            res[0]++;
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < coins.length; i++){
            if(i > 0 && coins[i] == coins[i-1]){
                continue;
            }
            list.add(coins[i]);
            back(coins, cur+coins[i], sum, list, res, z+1, lists);
            list.remove(list.size()-1);
        }
    }

    public static void main(String ar[]){
        int[] coins = new int[]{3, 2,1};
//        int[] coins = new int[]{2,5,10,20,25};

        System.out.println(getCount(coins, 4));
//        System.out.println(getCount(coins, 50));
//        System.out.println(getCount(coins, 10));

    }

}
