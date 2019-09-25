package hackerrank.unsorted;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DijkstraTwo {


    static int[] shortestReach(int n, int[][] edges, int s) {


        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        int[] res = new int[n+1];
        Arrays.fill(res, -1);
        res[s] = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(s);

        while(visited.size() < n){
            Integer minD = Integer.MAX_VALUE;
            Integer minNode = -1;
            for(int i = 1; i < graph.length; i++){
                if(graph[s][i] != 0 && !visited.contains(i) && graph[s][i] < minD){
                    minD = graph[s][i];
                    minNode = i;
                }
            }
            visited.add(minNode);

            for(int i = 1; i < graph.length; i++){
                if(graph[minNode][i] != 0){
                    if(res[i] == -1){
                        System.out.println(res[minNode]);
                        res[i] = minD + graph[minNode][i];
                    }
                    else {
                        res[i] = Math.min(res[i], res[minNode] + graph[minNode][i]);
                    }
                }
            }
        }

        int [] result = new int[res.length-2];
        for(int i = 1; i < res.length; i++){
            if(i == s){
                continue;
            }
            result[i-1] = res[i];
        }

        return result;
    }

    // Complete the shortestReach function below.
//    static int[] shortestReach(int n, int[][] edges, int s) {
//
//
//        int[][] graph = new int[n+1][n+1];
//        for(int i = 0; i < edges.length; i++){
//            graph[edges[i][0]][edges[i][1]] = edges[i][2];
//            graph[edges[i][1]][edges[i][0]] = edges[i][2];
//        }
//
//        int[] res = new int[n-1];
//        Arrays.fill(res, -1);
//        Set<Integer> visited = new HashSet<>();
//        visited.add(s);
//        backTrack(res, s, graph, s, 0, visited);
//
////        for(int i = 0; i < res.length; i++){
////            if(res[i] == Integer.MAX_VALUE){
////                res[i] = -1;
////            }
////        }
//
//        return res;
//    }
//
//    private static void backTrack(int[] res, int s, int[][] graph, Integer node, int dist, Set<Integer> visited){
//
//        if(node > s){
//            if(res[node-2] == -1){
//                res[node-2] = dist;
//            }
//            else{
//                res[node-2] = Math.min(res[node-2], dist);
//            }
//
//        }
//        else if(node < s){
//            if(res[node-1] == -1){
//                res[node-1] = dist;
//            }
//            else{
//                res[node-1] = Math.min(res[node-1], dist);
//            }
//        }
//
//        for(int i = 1; i < graph.length; i++){
//            if(graph[node][i] != 0 && !visited.contains(i)){
//                visited.add(i);
//                backTrack(res, s, graph, i, dist+graph[node][i], visited);
//                visited.remove(i);
//            }
//        }
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
