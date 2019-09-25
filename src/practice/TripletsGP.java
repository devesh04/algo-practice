package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TripletsGP {

    // Complete the countTriplets function below.

//    static long countTriplets(List<Long> arr, long r) {
//
//        Map<Long, Long> map = new HashMap<>();
//        Set<Long> set = new HashSet<Long>();
//
//        for(Long l : arr){
//            if(map.containsKey(l)){
//                map.put(l, map.get(l) + 1);
//            }
//            else{
//                map.put(l, 1l);
//            }
//
//            set.add(l);
//        }
//
//        long total = 0l;
//
//        for(Long l : arr){
//            long max = 1;
//            boolean found = true;
//            for(int i = 1; i < 3; i++){
//                Long desired = l  * (long)Math.pow(r, i);
//
//                System.out.println(l + "  >" + desired);
//                if(map.containsKey(desired)){
//                    Long dc = map.get(desired);
//                    if(dc > max){
//                        max = dc;
//                    }
//                    // max = Math.max(max, map.get(desired));
//                }
//                else{
//                    found = false;
//                    break;
//                }
//            }
//
//            if(!map.remove(l, 1)){
//                map.replace(l, map.get(l) - 1);
//            }
//
//            if(found){
//                total = total + max;
//            }
//            else{
//                continue;
//            }
//        }
//
//        return total;
//
//    }


    static List<Integer> getIndexes(Map<Long, List<Integer>> map, Long key, Integer greaterThan){
        List<Integer> list = map.get(key);
        List<Integer> result = new ArrayList<>();
        if(list != null){

            for(Integer integer : list){
                if(integer > greaterThan){
                    result.add(integer);
                }
            }
        }
        return result;
    }

    static int getCount(Map<Long, List<Integer>> map, Long key, Integer greaterThan){
        List<Integer> list = map.get(key);
        int result = 0;
        if(list != null){
            for(Integer integer : list){
                if(integer > greaterThan){
                    result++;
                }
            }
        }
        return result;
    }

//    static long countTriplets(List<Long> arr, long r) {
//
//        Map<Long, List<Integer>> map = new HashMap<>();
//
//        for(int i = 0; i < arr.size(); i++){
//            if(map.containsKey(arr.get(i))){
//                map.get(arr.get(i)).add(i);
//            }
//            else{
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(arr.get(i), list);
//            }
//        }
//
//
//        int total = 0;
//
//        for(int i =0; i < arr.size(); i++){
//            Long current = arr.get(i);
//            Long next1 = current*r;
//            Long next2 = current*r*r;
//
//            if(map.containsKey(next1) && map.containsKey(next2)){
//                List<Integer> indexes = getIndexes(map, next1, i);
//                if(indexes.size() > 0){
//                    for(Integer index : indexes){
//                        int count = getCount(map, next2, index);
//                        total = total + count;
//                    }
//                }
//                continue;
//            }
//            else{
//                continue;
//            }
//        }
//
//        return total;
//    }


    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        for(Long item : arr){
            if(!rightMap.containsKey(item)){
                rightMap.put(item, 1l);
            }
            else{
                rightMap.replace(item, rightMap.get(item) + 1);
            }
        }

        long sum = 0;

        for(int i = 0; i < arr.size(); i++){

            Long current = arr.get(i);

            long leftCount = 0;
            long rightCount = 0;

            if(current % r == 0){
                leftCount = leftMap.getOrDefault(current/r, 0l);
            }

            rightMap.replace(current, rightMap.get(current) - 1);

            if(leftCount != 0)
                rightCount = rightMap.getOrDefault(current*r, 0l);

            sum = sum + (leftCount*rightCount);

            leftMap.put(current, leftMap.getOrDefault(current, 0l) + 1);

        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);


        bufferedReader.close();
    }
}
