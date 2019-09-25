package hackerrank.prep_kit.recursions;

import util.annotations.Incomplete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking

A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. Cells marked with a - are to be filled with the word list.

The following shows an example crossword from the input  grid and the list of words to fit, :

 */

@Incomplete
public class Crosswords {


//    private static char getChar(String [] cross, int row, int column){
//        return cross[row].charAt(column);
//    }
//
//    private static int[] findNext(String [] cross, int row, int column){
//        for(int i = row; i < cross.length; i++){
//            for(int j = column; j < cross.length; j++){
//                if(getChar(cross, i,j) == '-'){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return null;
//    }
//
//    private static int[] isHorizontal(String [] cross, int row, int column){
//        if()
//    }

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        String[] split = words.split(";");
        Map<Integer, List<String>> map = new HashMap<>();
        for(String s : split){
            if(map.containsKey(s.length())){
                map.get(s.length()).add(s);
            }
            else{
                List<String> objects = new ArrayList<>();
                objects.add(s);
                map.put(s.length(), objects);
            }
        }
        Stack<String> stack = new Stack<>();
        int[] pointer = new int[] {0,0};
        while(stack.size()!= split.length){
            doIt(crossword, split, map, pointer, stack);
        }
        return split; //fix it
    }

    private static int getLength(String[] crossword, int [] pointer){
        String s = crossword[pointer[0]];
        return s.replaceAll("\\+", "").length();
    }

    private static void doIt(String[] crossword, String[] split, Map<Integer, List<String>> map,  int[] pointer, Stack<String> stack) {
        int length = getLength(crossword, pointer);
        if(length == 0){
            pointer[0]++;
        }
        else if(length == 1){

        }
        else{
            boolean b = map.containsKey(length);
            if(b && map.get(length).size() != 0){
                stack.add(map.get(length).remove(0));
            }
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}