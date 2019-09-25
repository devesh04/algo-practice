package logic_problems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class DisjointedSet {

    Map<Integer, Integer> parentMap = new HashMap<>();
    Map<Integer, Integer> rankMap = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    Integer max = 0;

    public void addNew(Integer i){
        parentMap.put(i, i);
        rankMap.put(i, 0);
        countMap.put(i, 1);
    }

    public Integer find(Integer i){

        if(parentMap.get(i).equals(i)){
            return i;
        }

        return find(parentMap.get(i));
    }

    public Integer getSumOfSet(Integer i){
        return countMap.get(find(i));
    }

    public void union(Integer i, Integer j){
        if(i.equals(j)){
            return;
        }
        Integer a = find(i);
        Integer b = find(j);
        if(a.equals(b)){
            return;
        }

        int sumOfSets = countMap.get(a) + countMap.get(b);

        if(rankMap.get(a).intValue() > rankMap.get(b).intValue()){
            parentMap.put(b, a);
            countMap.put(a, sumOfSets);
//            countMap.put(b, 0);
        }
        else if(rankMap.get(a).intValue() < rankMap.get(b).intValue()){
            parentMap.put(a, b);
            countMap.put(b, sumOfSets);
//            countMap.put(a, 0);
        }
        else{
            parentMap.put(a, b);
            rankMap.put(b, rankMap.get(b) +1);
            countMap.put(b, sumOfSets);
//            countMap.put(a, 0);
        }

//        System.out.println("i:"+i + " j:" + j);
//        System.out.println("a:"+a + " b:" + b);
//        printCountMap();


        if(sumOfSets > this.max.intValue()){
            this.max = sumOfSets;
        }
    }

    private void printCountMap(){
        for(Integer i : this.countMap.keySet()){
            System.out.print(i +  ":" + this.countMap.get(i) + "\t");
        }
        System.out.println();
    }

    public Integer getMaxSetCount(){
        return this.max;
    }

    public void printMaxSetCount(){
        System.out.println("Max Set: " + getMaxSetCount());
    }

    public void printSetCounts(int ... ins){
        for(Integer i : ins){
            System.out.println("Count of "+ i + " : " + getSumOfSet(i));
        }
    }

}

public class FriendsCircle {




    static int[] maxCircle(int[][] queries) {
        DisjointedSet ds = new DisjointedSet();
        for(int i = 0; i < queries.length; i++){
            ds.addNew(queries[i][0]);
            ds.addNew(queries[i][1]);
        }

        int [] maxArr = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            ds.union(queries[i][0], queries[i][1]);
            maxArr[i] = ds.getMaxSetCount();
        }
        return maxArr;

    }

    //attempt 3
//    static Map<Integer, Integer> map = new HashMap<>();
//    static List<Set<Integer>> list = new ArrayList<>();
//
//
//    // Complete the maxCircle function below.
//    static int[] maxCircle(int[][] queries) {
//
//        int max = -1;
//        int [] res = new int[queries.length];
//        for(int i = 0; i < queries.length; i++){
//            int one = queries[i][0];
//            int two = queries[i][1];
//
//            if(map.containsKey(one) && map.containsKey(two)){
//                Integer set1 = map.get(one);
//                Integer set2 = map.get(two);
//                Set<Integer> s1 = list.get(set1);
//                Set<Integer> s2 = list.get(set2);
//
//                if(s1 != s2){
//
//                    s1.addAll(s2);
//
//                    if(max < s1.size()){
//                        max = s1.size();
//                    }
//
//                    list.set(set2, s1);
//
//                }
//            }
//            else if(map.containsKey(one) && !map.containsKey(two)){
//                Integer set1 = map.get(one);
//                Set<Integer> s1 = list.get(set1);
//                s1.add(two);
//
//                map.put(two, set1);
//
//                if(max < s1.size()){
//                    max = s1.size();
//                }
//            }
//            else if(map.containsKey(two) && !map.containsKey(one)){
//                Integer set1 = map.get(two);
//                Set<Integer> s1 = list.get(set1);
//
//                s1.add(one);
//                map.put(one, set1);
//
//                if(max < s1.size()){
//                    max = s1.size();
//                }
//            }
//            else{
//
//                Set<Integer> newSet = new HashSet<>();
//                newSet.add(one);
//                newSet.add(two);
//
//                list.add(newSet);
//                int size = list.size();
//                map.put(one, size-1);
//                map.put(two, size-1);
//
//                if(max < newSet.size()){
//                    max = newSet.size();
//                }
//            }
//
//            res[i] = max;
//        }
//
//        return res;
//    }


    //attempt 2 - working fine but time out
//    static Map<Integer, Set<Integer>> map = new HashMap<>();
//    static List<Set<Integer>> list = new ArrayList<>();
//
//
//    // Complete the maxCircle function below.
//    static int[] maxCircle(int[][] queries) {
//
//        int max = -1;
//        int [] res = new int[queries.length];
//        for(int i = 0; i < queries.length; i++){
//            int one = queries[i][0];
//            int two = queries[i][1];
//
//            if(map.containsKey(one) && map.containsKey(two)){
//                Set<Integer> set1 = map.get(one);
//                Set<Integer> set2 = map.get(two);
//                if(set1 != set2){
//                    set1.addAll(set2);
//                    if(max < set1.size()){
//                        max = set1.size();
//                    }
//
//                    set2 = set1;
//
////                    for(Integer integer : set2){
////                        map.replace(integer, set1);
////                    }
//                }
//            }
//            else if(map.containsKey(one) && !map.containsKey(two)){
//                Set<Integer> set1 = map.get(one);
//                set1.add(two);
//                map.put(two, set1);
//
//                if(max < set1.size()){
//                    max = set1.size();
//                }
//            }
//            else if(map.containsKey(two) && !map.containsKey(one)){
//                Set<Integer> set1 = map.get(two);
//                set1.add(one);
//                map.put(one, set1);
//
//                if(max < set1.size()){
//                    max = set1.size();
//                }
//            }
//            else{
//
//                Set<Integer> newSet = new HashSet<>();
//                newSet.add(one);
//                newSet.add(two);
//                list.add(newSet);
//
//                map.put(one, newSet);
//                map.put(two, newSet);
//                if(max < newSet.size()){
//                        max = newSet.size();
//                }
//            }
//
//            res[i] = max;
//        }
//
//        return res;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);


        for (int i = 0; i < ans.length; i++) {

            System.out.println(ans[i]);
//            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
//                bufferedWriter.write("\n");
            }
        }

//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
