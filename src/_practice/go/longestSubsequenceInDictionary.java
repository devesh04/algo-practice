package _practice.go;

import java.util.*;

/**
 * Created by devesh on 17/08/19.
 */
public class longestSubsequenceInDictionary {

    static class Pair{
        String word;
        int i;

        public Pair(String word, int i){
            this.word = word;
            this.i = i;
        }
    }

    public static String getLongestSubsequenceWord(List<String> words, String input){
        Map<Character, Queue<Pair>> map = new HashMap<>();
        String longestWord = null;
        int longestWordLen = -1;
        for(String w : words){
            if(w.length() > 0){
                Queue<Pair> get = map.getOrDefault(w.charAt(0), new LinkedList<>());
                get.add(new Pair(w, 0));
                map.put(w.charAt(0), get);
            }
        }

        int i = 0;
        while (i < input.length()){
            Character c = input.charAt(i);
            Queue<Pair> pairs = map.get(c);
            if(pairs == null){
                i++;
                continue;
            }
            int size = pairs.size();
            while(size != 0){
                Pair pop = pairs.poll();
                pop.i++;
                if(pop.word.length() == pop.i && longestWordLen < pop.word.length()){
                    longestWordLen = pop.word.length();
                    longestWord = pop.word;
                }
                else{
                    Queue<Pair> stack = map.getOrDefault(pop.word.charAt(pop.i), new LinkedList<>());
                    stack.add(pop);
                    map.put(pop.word.charAt(pop.i), stack);
                }
                size--;
            }
            i++;
        }

        return longestWord;

    }

    public static void main(String ar[]){
        List<String> words = new ArrayList<>();
        words.add("able");
        words.add("ale");
        words.add("apple");
        words.add("bale");
        words.add("kangaroo");

        String input = "abppplee";

        String longestSubsequenceWord = getLongestSubsequenceWord(words, input);
        System.out.println(longestSubsequenceWord);
    }
}
