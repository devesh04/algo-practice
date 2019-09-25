package ds_problems.graph;

import java.io.IOException;
import java.util.Scanner;

public class DFS {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] != 1){
                    continue;
                }
                max = Math.max(max, recursive(grid, i, j));
            }
        }
        return max;
    }

    static boolean isIndexFine(int [][] grid, int i, int j){
        return i >= 0 && j >=0 && i < grid.length && j < grid[i].length;
    }

    static int recursive(int [][] grid, int i, int j){
        if(!isIndexFine(grid, i, j)){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        if(grid[i][j] == -1){
            return 0;
        }
//        printGrid(grid);
//        System.out.println("i"+i + " j"+j + " " + grid[i][j]);
        grid[i][j] = -1;

        int mysum = 1;
        for(int x=i-1; x<=i+1; x++){
            for(int y=j-1; y<=j+1; y++){
                mysum+=recursive(grid, x, y);
            }
        }
        return mysum;
    }

    private static void printGrid(int [][] grid){
        for(int i=0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
