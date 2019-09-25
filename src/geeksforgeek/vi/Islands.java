package geeksforgeek.vi;

/**
 * Created by devesh on 19/06/19.
 */
public class Islands {

    static int getNumber(int [][] arr, int row, int column){
        int [][] copy = new int[row][column];
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
//                System.out.println(i + " " + j);
                if(arr[i][j] == 1 && copy[i][j] != 1){

                    printAndHighlight(arr, i, j, "right now on");

                    copy[i][j] = 1;
                    boolean newIsland = true;

                    for(int l = Math.max(i-1, 0); l < Math.min(row, i+2); l++){
                        for(int m = Math.max(j-1, 0); m < Math.min(column, j+2); m++){
                            if(l == i && m == j){
                                continue;
                            }

                            printAndHighlight(arr, l, m, "checking neighbour");

                            if(arr[l][m] == 1 && copy[l][m] == 1){
                                newIsland = false;
                            }
                            else if(arr[l][m] == 1 && copy[l][m] != 1){
                                copy[l][m] = 1;
                            }
                        }
                    }

//                    for(int l = Math.max(i-1, 0); l < Math.min(row, i+1); l++){
//                        for(int m = Math.max(j-1, 0); m < Math.min(column, j+1); m++){
//
//                            if(l == i && m == j){
//                                continue;
//                            }
//
//                            if(arr[l][m] == 1 && copy[l][m] == 1){
//                                newIsland = false;
//                            }
//                            else if(arr[l][m] == 1 && copy[l][m] != 1){
//                                copy[l][m] = 1;
//                            }
//                        }
//                    }

                    if(newIsland){
                        System.out.println("Found new island");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void printAndHighlight(int ar[][], int l, int m, String title){
        System.out.println(title);
        for(int i = 0; i < ar.length; i++){
            for(int j = 0; j < ar[i].length; j++){
                if(i == l && j == m){
                    System.out.print( "["+ar[i][j] + "]" + "\t");
                }
                else{
                    System.out.print( ar[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String ar[]){
        int [] [] arr = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println(getNumber(arr, 5, 5));
    }

}
