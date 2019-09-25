package ds_problems.graph;//package com.test.ds_problems.graph;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.*;
//
///**
// * Created by devesh on 04/07/19.
// */
//public class Matrix {
//
//
//    static class DisjointedSet<T> {
//
//        Map<T, T> parentMap = new HashMap<T, T>();
//        Map<T, Integer> rankMap = new HashMap<T, Integer>();
//
//        public void make(T object){
//            parentMap.put(object, object);
//            rankMap.put(object, 0);
//        }
//
//        public T find(T object){
//            if(object == null || !parentMap.containsKey(object)){
//                return null;
//            }
//            if(parentMap.get(object).equals(object)){
//                return object;
//            }
//
//            return find(parentMap.get(object));
//        }
//
//        private Integer getRank(T object){
//            return rankMap.get(object);
//        }
//
//        public void union(T ob1, T ob2){
//            if(getRank(ob1) > getRank(ob2)){
//                parentMap.replace(ob2, ob1);
//            }
//            else if(getRank(ob1) < getRank(ob2)){
//                parentMap.replace(ob1, ob2);
//            }
//            else{
//                parentMap.replace(ob1, ob2);
//                rankMap.replace(ob2, rankMap.get(ob2) +1 );
//            }
//        }
//    }
//
//    static boolean isMachine(int road [], int i, int [] machines){
//        return machines[road[i]] == 1;
//    }
//
//    static boolean hasMachine(DisjointedSet<Integer> disjointedSet, int [] machines, Integer setA){
//        for(int i = 0; i < machines.length; i++){
//            if(disjointedSet.find(machines[i]) == setA){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Complete the minTime function below.
//    static int minTime(int[][] roads, int[] machines) {
//
//
//        Arrays.sort(roads, (x,y) -> Integer.compare(y[2], x[2]));
//
//        DisjointedSet<Integer> disjointedSet = new DisjointedSet<>();
//        for(int i = 0 ; i < roads.length+1; i++){
//            disjointedSet.make(i);
//        }
//
//        int[] machineLine = new int[roads.length+1];
//        for(int i = 0; i < machines.length; i++){
//            machineLine[machines[i]] = 1;
//        }
//
//        int sum = 0;
//        for(int i = 0; i < roads.length; i++){
//            int[] road = roads[i];
//
//            Integer setA = disjointedSet.find(road[0]);
//            Integer setB = disjointedSet.find(road[1]);
//
//            if(!setA.equals(setB)){
//                boolean b1 = hasMachine(disjointedSet, machines, setA);
//                boolean b2 = hasMachine(disjointedSet, machines, setB);
//                if(b1 && b2){
//                    //break this
//                    sum +=road[2];
//
//                }
//                else{
//                    disjointedSet.union(setA, setB);
//                }
//            }
//        }
//
//        return sum;
//
//
//
////        int[][] graph = createGraph(roads, machines);
////        int[][] machinePair = createMachinePair(roads, machines);
////        return minOnPath(graph, machines, machinePair);
//
//        static class DisjointedSet<T> {
//
//            Map<T, T> parentMap = new HashMap<T, T>();
//            Map<T, Integer> rankMap = new HashMap<T, Integer>();
//
//            public void make(T object){
//                parentMap.put(object, object);
//                rankMap.put(object, 0);
//            }
//
//            public T find(T object){
//                if(object == null || !parentMap.containsKey(object)){
//                    return null;
//                }
//                if(parentMap.get(object).equals(object)){
//                    return object;
//                }
//
//                return find(parentMap.get(object));
//            }
//
//            private Integer getRank(T object){
//                return rankMap.get(object);
//            }
//
//            public void union(T ob1, T ob2){
//                if(getRank(ob1) > getRank(ob2)){
//                    parentMap.replace(ob2, ob1);
//                }
//                else if(getRank(ob1) < getRank(ob2)){
//                    parentMap.replace(ob1, ob2);
//                }
//                else{
//                    parentMap.replace(ob1, ob2);
//                    rankMap.replace(ob2, rankMap.get(ob2) +1 );
//                }
//            }
//        }
//
//        static boolean isMachine(int road [], int i, int [] machines){
//            return machines[road[i]] == 1;
//        }
//
//        static boolean hasMachine(DisjointedSet<Integer> disjointedSet, int [] machines, Integer setA){
//            for(int i = 0; i < machines.length; i++){
//                if(disjointedSet.find(machines[i]) == setA){
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        // Complete the minTime function below.
//        static int minTime(int[][] roads, int[] machines) {
//
//
//            Arrays.sort(roads, (x,y) -> Integer.compare(y[2], x[2]));
//
//            DisjointedSet<Integer> disjointedSet = new DisjointedSet<>();
//            for(int i = 0 ; i < roads.length+1; i++){
//                disjointedSet.make(i);
//            }
//
//            int[] machineLine = new int[roads.length+1];
//            for(int i = 0; i < machines.length; i++){
//                machineLine[machines[i]] = 1;
//            }
//
//            int sum = 0;
//            for(int i = 0; i < roads.length; i++){
//                int[] road = roads[i];
//
//                Integer setA = disjointedSet.find(road[0]);
//                Integer setB = disjointedSet.find(road[1]);
//
//                if(!setA.equals(setB)){
//                    boolean b1 = hasMachine(disjointedSet, machines, setA);
//                    boolean b2 = hasMachine(disjointedSet, machines, setB);
//                    if(b1 && b2){
//                        //break this
//                        sum +=road[2];
//
//                    }
//                    else{
//                        disjointedSet.union(setA, setB);
//                    }
//                }
//            }
//
//            return sum;
//
//
//
////        int[][] graph = createGraph(roads, machines);
////        int[][] machinePair = createMachinePair(roads, machines);
////        return minOnPath(graph, machines, machinePair);
//
//
//
//        }
//
//    }
//
//
//
//
////    static int minOnPath(int[][] graph,  int[] machines, int[][] machinePair){
////        int count = 0;
////        for(int i = 0; i < machines.length; i++){
////            for(int j = 0; j < machines.length; j++){
////                if(i == j || machinePair[i][j] == 1){
////                    continue;
////                }
////                machinePair[i][j] = 1;
////                machinePair[j][i] = 1;
//////                System.out.println("machine pair:" + machines[i] + " " + machines[j]);
//////                int[] minRoad = new int[3];
//////                minRoad[2] = Integer.MAX_VALUE;
////
////                int i1 = minOnPathRecur(graph, machines[i], machines[j], -1, -1, Integer.MAX_VALUE, new HashSet<Integer>());
//////                System.out.println(">>" + i1);
////
////                //update graph
////                if(i1 != Integer.MAX_VALUE && i1 != -1){
////                    count+=i1;
//////                    graph[minRoad[0]][minRoad[1]] = 0;
////                }
////            }
////        }
////        return count;
////    }
////
////
////
////    static int minOnPathRecur(int[][] graph, int cityOne, int cityTwo, int minC1, int minC2, int minValue, Set<Integer> visited){
////
////        visited.add(cityOne);
////
////        if(cityOne == cityTwo){
////            //remove here
////            graph[minC1][minC2] = 0;
////            return minValue;
////        }
////
////        for(int x=0; x<graph.length; x++){
////            if(graph[cityOne][x] > 0 && !visited.contains(x)){
//////                cityOne = x;
////                if(minValue > graph[cityOne][x]){
////                    minC1 = cityOne;
////                    minC2 = x;
////                    minValue = graph[cityOne][x];
////                }
////
////                int i = minOnPathRecur(graph, x, cityTwo, minC1, minC2, minValue, visited);
////                if(i != -1){
////                    return i;
////                }
//////                else{
//////                    if(orginalCity == cityOne){
//////                        minRoad[0] = 0;
//////                        minRoad[1] = 0;
//////                        minRoad[2] = Integer.MAX_VALUE;
//////                    }
////////                    System.out.println("current city:" + cityOne);
//////                }
////            }
////        }
////
////        return -1;
////
////    }
////
////
////    static int[][] createMachinePair(int[][] roads, int [] machines){
////        int [][] line = new int [machines.length][machines.length];
////        return line;
////    }
////    static int[][] createGraph(int[][] roads, int[] machines){
////        int [][] graph = new int[roads.length+1][roads.length+1];
////
////        for(int i =0; i < roads.length; i++){
////            graph[roads[i][0]][roads[i][1]] = roads[i][2];
////            graph[roads[i][1]][roads[i][0]] = roads[i][2];
////        }
////        return graph;
////    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        try {
//            String[] nk = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nk[0]);
//
//            int k = Integer.parseInt(nk[1]);
//
//            int[][] roads = new int[n - 1][3];
//
//            for (int i = 0; i < n - 1; i++) {
//                String[] roadsRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                for (int j = 0; j < 3; j++) {
//                    int roadsItem = Integer.parseInt(roadsRowItems[j]);
//                    roads[i][j] = roadsItem;
//                }
//            }
//
//            int[] machines = new int[k];
//
//            for (int i = 0; i < k; i++) {
//                int machinesItem = scanner.nextInt();
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//                machines[i] = machinesItem;
//            }
//
//            int result = minTime(roads, machines);
//
//
//            System.out.println(result);
//
////        bufferedWriter.write(String.valueOf(result));
////        bufferedWriter.newLine();
//
////        bufferedWriter.close();
//
//            scanner.close();
//        }
//        catch (NumberFormatException e){
//
//        }
//    }
//}
