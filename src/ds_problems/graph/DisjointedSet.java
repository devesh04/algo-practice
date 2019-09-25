package ds_problems.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devesh on 04/07/19.
 */
public class DisjointedSet<T> {

    Map<T, T> parentMap = new HashMap<T, T>();
    Map<T, Integer> rankMap = new HashMap<T, Integer>();

    public void make(T object){
        parentMap.put(object, object);
        rankMap.put(object, 0);
    }

    public T find(T object){
        if(object == null || !parentMap.containsKey(object)){
            return null;
        }
        if(parentMap.get(object).equals(object)){
            return object;
        }

        return find(parentMap.get(object));
    }

    private Integer getRank(T object){
        return rankMap.get(object);
    }

    public void union(T ob1, T ob2){
        if(getRank(ob1) > getRank(ob2)){
            parentMap.replace(ob2, ob1);
        }
        else{
            parentMap.replace(ob1, ob2);
        }
    }


    public static void main(String ar[]){
        DisjointedSet<String> stringDisjointedSet = new DisjointedSet<>();
        stringDisjointedSet.make("a1");
        stringDisjointedSet.make("a2");
        stringDisjointedSet.make("a3");
        stringDisjointedSet.make("b1");
        stringDisjointedSet.make("c1");


        System.out.println(stringDisjointedSet.find("a1"));
        System.out.println(stringDisjointedSet.find("a2"));
        System.out.println(stringDisjointedSet.find("a3"));
        System.out.println();


        stringDisjointedSet.union("a1", "a2");

        System.out.println(stringDisjointedSet.find("a1"));
        System.out.println(stringDisjointedSet.find("a2"));
        System.out.println(stringDisjointedSet.find("a3"));
        System.out.println();

        stringDisjointedSet.union("a3", "a1");

        System.out.println(stringDisjointedSet.find("a1"));
        System.out.println(stringDisjointedSet.find("a2"));
        System.out.println(stringDisjointedSet.find("a3"));
        System.out.println();



    }

}
