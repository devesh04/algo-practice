package ds_problems.graph;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


public class MinimumMoves {

    static char[][] toCharGrid(String[] grid){
        char[][] chars = new char[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++){
            char[] chars1 = grid[i].toCharArray();
            chars[i] = chars1;
        }
        return chars;
    }

    static List<int[]> getNewIndex(char[][] grid, int i, int j, int diffX, int diffY, List<int[]> list){
//        i = i + diffX;
//        j = j + diffY;
        int x = i;
        int y = j;
        while(isIndexFine(grid, x+diffX, y+diffY) && grid[x+diffX][y+diffY] != '-' && grid[x+diffX][y+diffY] != 'X'){
            x = x + diffX;
            y = y + diffY;
//            grid[x][y] = '-';
            list.add(new int[]{x,y});
        }

//        if(x == i && y == j){
////            list.add(new int[]{-5,-5});
//        }
//        else{
//            list.add(new int[]{x,y});
//        }
        return list;
    }

    static boolean isIndexFine(int [][] grid, int i, int j){
        return i >= 0 && j >=0 && i < grid.length && j < grid[i].length;
    }

    static boolean isIndexFine(char [][] grid, int i, int j){
        return i >= 0 && j >=0 && i < grid.length && j < grid[i].length;
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        char[][] chars = toCharGrid(grid);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if(poll[0] == goalX && poll[1] == goalY){
                return poll[2];
            }

            chars[poll[0]][poll[1]] = '-';

            List<int[]> list = new ArrayList<>();
            getNewIndex(chars, poll[0], poll[1], 1, 0, list);
            getNewIndex(chars, poll[0], poll[1], 0, 1, list);
            getNewIndex(chars, poll[0], poll[1], -1, 0, list);
            getNewIndex(chars, poll[0], poll[1], 0, -1, list);

            for(int[] item : list){
                if(isIndexFine(chars, item[0], item[1])){
                    queue.add(new int[]{item[0], item[1], 1+poll[2]});
                }
            }

//            newIndex = getNewIndex(chars, poll[0], poll[1], 0, 1);
//            for(int[] item : newIndex){
//                if(isIndexFine(chars, item[0], item[1])){
//                    queue.add(new int[]{item[0], item[1], 1+poll[2]});
//                }
//            }
//
//
//            newIndex = getNewIndex(chars, poll[0], poll[1], -1, 0);
//            for(int[] item : newIndex){
//                if(isIndexFine(chars, item[0], item[1])){
//                    queue.add(new int[]{item[0], item[1], 1+poll[2]});
//                }
//            }
//
//            newIndex = getNewIndex(chars, poll[0], poll[1], 0, -1);
//            for(int[] item : newIndex){
//                if(isIndexFine(chars, item[0], item[1])){
//                    queue.add(new int[]{item[0], item[1], 1+poll[2]});
//                }
//            }
        }

        return -1;
    }




//    static int move(char[][] grid, int x, int y, int i, int j, int c){
//        if(x==i && y ==j){
//            return c;
//        }
//
//        if(x < 0 || x >=grid.length || y < 0 || y >= grid.length || grid[x][y] == 'X' || grid[x][y] == '-'){
//            return Integer.MAX_VALUE;
//        }
//
//        grid[x][y] = '-';
//
//
//
//    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
