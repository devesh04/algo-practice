package ds_problems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    static Scanner scanner = new Scanner(System.in);

    static void function(int[][] graph, int startingIndex){

        
        startingIndex = startingIndex-1;

        int [] result = new int[graph.length];
        for(int j = 0; j < graph.length; j++){
            result[j] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingIndex);

        while(!queue.isEmpty()){
            bfs(graph,queue, result);
        }

        for(int j = 0; j < graph.length; j++){
            if(j == startingIndex){
                continue;
            }
            System.out.print(result[j] + " ");
        }
        System.out.println();
    }

    private static void bfs(int[][] graph, Queue<Integer> queue, int[] result) {

        Integer poll = queue.poll();
        int sum = result[poll] == -1 ? 0 : result[poll];
        for(int x = 0; x< graph.length; x++){

            if(graph[poll][x] == 1 && result[x] == -1){
                result[x] = 6+sum;

                queue.add(x);
            }
        }
    }


//    static void bfs(int [][] graph, int start, int sum, int[] result){
//
//        for(int x = 0; x< graph.length; x++){
//            if(graph[start][x] == 1){
//                if(result[x] == -1){
//                    result[x] = 6+sum;
//                }
//                bfs(graph, x, 6+sum, result);
//            }
//        }
//    }

//    static int distance(int [][] graph, int from, int to){
//        if(from == to){
//            return 0;
//        }
//        if(graph[from][to] == 1){
//            return 6;
//        }
//
//        int min = -1;
//
//        for(int i = 0; i < graph.length; i++){
//            if(i == from || graph[from][i] == 0){
//                continue;
//            }
//
//            return 6 + distance(graph, i, to);
//
//        }
//    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int testCases = scanner.nextInt();
        String next = scanner.nextLine();

        for(int t=0; t < testCases; t++){

            next = scanner.nextLine();
            int[] ints = Arrays.stream(next.split("\\s")).mapToInt(Integer::parseInt).toArray();

            int[][] graph = new int[ints[0]][ints[0]];

            for(int i = 0; i < ints[1]; i++){
                next = scanner.nextLine();
                int[] points = Arrays.stream(next.split("\\s")).mapToInt(Integer::parseInt).toArray();
                graph[points[0]][points[1]] = points[2];
                graph[points[1]][points[0]] = points[2];
            }


            next = scanner.nextLine();
            function(graph, Integer.parseInt(next));

        }

    }
}

