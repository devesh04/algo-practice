package hackerrank.unsorted;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsGraph {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

        int [][] graph = new int[n+1][n+1];
        for(int i = 0 ; i < edges.length; i++){
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }

        int[] res = new int[n-1];
        Arrays.fill(res, -1);
        int[] visited = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        queue.add(-1);
        visited[s] = 1;
        int dist = 6;
        while(queue.size() != 0){
            while(queue.size() != 0 && queue.peek() == -1){
                queue.poll();
                dist+=6;
            }
            bfs(graph, queue, dist, res, visited, s);
        }

        
        return res;
    
    }

    private static void bfs(int[][]graph, Queue<Integer> queue, int dist, int[] res, int[]visited, int s){
        if(queue.size() == 0){
            return;
        }
        int node = queue.poll();
        for(int i = 1; i < graph.length; i++){
            if(graph[node][i] == 1 && visited[i] != 1){
                visited[i] = 1;
                if(i>s) {
                    res[i - 2] = dist;
                }
                else{
                    res[i - 1] = dist;
                }
                queue.add(i);
            }
        }
        queue.add(-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

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
