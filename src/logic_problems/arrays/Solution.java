package logic_problems.arrays;//package com.test.logic_problems.arrays;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//public class Solution {
//
//    // Complete the arrayManipulation function below.
//
//    static class Pool {
//        int start;
//        int end;
//        int sum;
//        int maxSum = Integer.MIN_VALUE;
//
//        Pool left;
//        Pool right;
//
//        public Pool(int[] query){
//            this.start = query[0];
//            this.end = query[1];
//            this.sum = query[2];
//        }
//
//        public boolean doesOverlap(Pool pool){
//            return pool.end <= this.end || pool.start >= this.start;
//        }
//
//        public boolean isSubset(Pool pool){
//            return pool.end <= this.end && pool.start >= this.start;
//        }
//
//        public void addPool(Pool pool){
//            recursiveAdd(this, pool);
//        }
//
//        private void recursiveAdd(Pool parentPool, Pool poolToAdd){
//            if(parentPool.start >= poolToAdd.start){
//                if(parentPool.left == null){
//                    parentPool.left = poolToAdd;
//                    if(parentPool.maxSum < (paparentPool.left.sum)
//                }
//                else{
//                    recursiveAdd(parentPool.left, poolToAdd);
//                }
//            }
//            else {
//                if (parentPool.right == null) {
//                    parentPool.right = poolToAdd;
//                }
//                else{
//                    recursiveAdd(parentPool.right, poolToAdd);
//                }
//            }
//        }
//    }
//
//    static long arrayManipulation(int n, int[][] queries) {
//
//        int [] arr = new int[n];
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < queries.length; i++){
//            int start = queries[i][0];
//            int end = queries[i][1];
//            int add = queries[i][2];
//
//            for(int j = start-1; j <end; j++){
//                int sum = arr[j] + add;
//                arr[j] = sum;
//                if(max < sum){
//                    max = sum;
//                }
//            }
//        }
//        return max;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nm = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nm[0]);
//
//        int m = Integer.parseInt(nm[1]);
//
//        int[][] queries = new int[m][3];
//
//        for (int i = 0; i < m; i++) {
//            String[] queriesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 3; j++) {
//                int queriesItem = Integer.parseInt(queriesRowItems[j]);
//                queries[i][j] = queriesItem;
//            }
//        }
//
//        long result = arrayManipulation(n, queries);
//
//        System.out.println(result);
//
////        bufferedWriter.write(String.valueOf(result));
////        bufferedWriter.newLine();
//
////        bufferedWriter.close();
//
//        scanner.close();
//    }
//}
