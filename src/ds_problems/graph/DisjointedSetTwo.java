package ds_problems.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devesh on 05/07/19.
 */
public class DisjointedSetTwo {

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
        Integer a = find(i);
        Integer b = find(j);

        int sumOfSets = countMap.get(a) + countMap.get(b);
        if(rankMap.get(a) > rankMap.get(b)){
            parentMap.put(b, a);
            countMap.put(a, sumOfSets);
        }
        else if(rankMap.get(a) < rankMap.get(b)){
            parentMap.put(a, b);
            countMap.put(b, sumOfSets);
        }
        else{
            parentMap.put(a, b);
            rankMap.put(b, rankMap.get(b) +1);
            countMap.put(b, sumOfSets);
        }

        if(sumOfSets > this.max){
            this.max = sumOfSets;
        }
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



    public static void main(String ar[]){
        DisjointedSetTwo ds = new DisjointedSetTwo();

        ds.addNew(1);
        ds.addNew(2);
        ds.addNew(3);
        ds.addNew(4);

        ds.printMaxSetCount();


        ds.union(1, 2);

        ds.printMaxSetCount();

        ds.union(3, 4);

        ds.printMaxSetCount();
        ds.union(2, 4);

        ds.printMaxSetCount();

    }



}
