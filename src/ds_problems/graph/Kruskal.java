package ds_problems.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */


    static class DisjointedSet<T> {

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
            else if(getRank(ob1) < getRank(ob2)){
                parentMap.replace(ob1, ob2);
            }
            else{
                parentMap.replace(ob1, ob2);
                rankMap.replace(ob2, rankMap.get(ob2) +1 );
            }
        }
    }



    static class Edge{
        Integer a;
        Integer b;
        Integer weight;

        public Edge(Integer a, Integer b, Integer weight){
            this.a= a;
            this.b = b;
            this.weight = weight;
        }

        public String toString( ){
            return "a" +a + " b" + b + " w" + weight;
        }
    }


    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {


        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < gFrom.size(); i++){
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        edges.sort(Comparator.comparingInt(x -> x.weight));

        DisjointedSet<Integer> disjointedSet = new DisjointedSet<>();
        for(int i = 0; i < gNodes; i++){
            disjointedSet.make(i+1);
        }

        int sum = 0;
        for(int i = 0; i < edges.size(); i++){
            Edge edge = edges.get(i);
            System.out.println("edge:" + edge);
            Integer setA = disjointedSet.find(edge.a);
            Integer setB = disjointedSet.find(edge.b);

            if(!setA.equals(setB)){
                sum+=edge.weight;
                disjointedSet.union(setA, setB);
            }
        }
        return sum;

    }

}

public class Kruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.

        System.out.println(res);
//        bufferedWriter.write(res);

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
