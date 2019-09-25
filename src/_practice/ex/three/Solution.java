package _practice.ex.three;//package com.test.company_practice.expedia.three;
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//
//class Result {
//
//    /*
//     * Complete the 'findBeforeMatrix' function below.
//     *
//     * The function is expected to return a 2D_INTEGER_ARRAY.
//     * The function accepts 2D_INTEGER_ARRAY after as parameter.
//     */
//
//    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
//    // Write your code here
//
//
//        List<List<Integer>> newList = new ArrayList<>();
//
//        List<Integer> rowList = new ArrayList<>();
//        for(int row= 0; row < after.size(); row++){
//            for(int col = 0; col < after.size(); col++){
//                int current = after.get(row).get(col);
//            }
//        }
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int afterRows = Integer.parseInt(bufferedReader.readLine().trim());
//        int afterColumns = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> after = new ArrayList<>();
//
//        IntStream.range(0, afterRows).forEach(i -> {
//            try {
//                after.add(
//                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<List<Integer>> result = Result.findBeforeMatrix(after);
//
//        result.stream()
//            .map(
//                r -> r.stream()
//                    .map(Object::toString)
//                    .collect(joining(" "))
//            )
//            .map(r -> r + "\n")
//            .collect(toList())
//            .forEach(e -> {
//                try {
//                    bufferedWriter.write(e);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
