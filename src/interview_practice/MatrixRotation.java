package interview_practice;

/**
 * Created by devesh on 11/07/19.
 */
public class MatrixRotation {


    static void rotateAnti(int [][] arr){
        int N = arr.length - 1;

        for(int i = 0; i < arr.length; i++){

            for (int y = i; y < N-i; y++)
            {
                // store current cell in temp variable
                int temp = arr[i][y];

                // move values from right to top
                arr[i][y] = arr[y][N-i];

                // move values from bottom to right
                arr[y][N-i] = arr[N-i][N-y];

                // move values from left to bottom
                arr[N-i][N-y] = arr[N-y][i];

                // assign temp to left
                arr[N-y][i] = temp;
            }
        }
    }

    static void rotateCLock(int [][] arr){
        int n = arr.length -1;
        for(int i = 0; i < arr.length/2; i++){
            for(int j = i; j < n-i; j++){

                int temp = arr[i][j];

//                arr[i][j] = arr[j][n-i];
                arr[i][j] = arr[n-j][i];

                arr[n-j][i] = arr[n-i][n-j];

                arr[n-i][n-j] = arr[j][n-i];

                arr[j][n-i] = temp;
            }
        }
    }

    static void printArr(int [][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String ar[]){

        int [][] arr = new int[][]{{1,2,3}, {4,5,6}, {7, 8, 9}};

        printArr(arr);
        rotateCLock(arr);
        printArr(arr);

    }
}
