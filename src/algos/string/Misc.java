package algos.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by devesh on 10/10/18.
 */
public class Misc {

    public static String reverseString(String string){
        char[] chars = string.toCharArray();

        for(int i = 0, j=(chars.length -1); i < j; i++, j--){
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
        return String.valueOf(chars);
    }

    public static char [] reverseString(char[] chars, int start, int end){

        for(int i = start, j=end; i < j; i++, j--){
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
        return chars;
    }

    public static String reverseWords(String string){
        String s = reverseString(string);
        char[] chars = s.toCharArray();
        int pointer = 0;
        int startWord = 0;

        while (pointer <  chars.length){
            char aChar = chars[pointer];
            if(aChar == ' '){
                reverseString(chars, startWord, pointer - 1);
                startWord = pointer + 1;
            }
            else if(pointer == chars.length - 1){
                reverseString(chars, startWord, pointer);
            }
            pointer++;
        }
        return String.valueOf(chars);
    }

    public static void permutation(String string){
        char [] chars = string.toCharArray();
        permutation(0, new char[chars.length], new int[chars.length], chars);
    }

    private static void permutation(int depth, char [] perm, int[] used, char[] original){
        int len = original.length;
        if(depth == len) System.out.println(perm);
        else{
            for(int i=0; i < len; i++){
                if(used[i] != 1){
                    used[i] = 1;
                    perm[depth] = original[i];
                    permutation(depth+1, perm, used, original);
                    used[i] = 0;
                }
            }
        }
    }

    private static void permutation2(String prefix, String input){
        if(input.length() == 0) System.out.println(prefix);
        for(int i = 0; i < input.length(); i++){
            permutation2(prefix+input.charAt(i), input.substring(0, i) + input.substring(i, input.length() -1));
        }
    }

    public static void combination(String string){
        char [] chars = string.toCharArray();
        combination(0, new char[chars.length], 0, chars);
    }

    private static void combination(int depth, char [] perm, int start, char[] original){
        int len = original.length;
        for(int i=start; i < len; i++){
            perm[depth] = original[i];
            if(depth + 1 < len -1){
                perm[depth + 1] = '\0';
            }
            System.out.println(String.valueOf(perm));
            if(i < len -1)
            combination(depth+1, perm, start+1, original);
        }
    }

    public static String candyCrush(String string){
//        char[] chars = string.toCharArray();
        return removeAdj(string);
    }

    private static String removeAdj(char[] chars) {
        int len = chars.length;
        boolean recurse = false;
        for(int i = 0; i < chars.length; i++){
            if(i>0 && chars[i] == chars[i-1]){
                chars[i] = '\0';

            }
        }
        if(recurse) removeAdj(chars);
        return String.valueOf(chars);
    }

    private static String removeAdj(String chars) {
        boolean recurse = false;
        for(int i = 0; i < chars.length(); i++){

            if(i>0 && chars.charAt(i) == chars.charAt(i-1)){
                chars = chars.substring(0, i-1) + ( (i < chars.length() -1 ) ? chars.substring(i+1, chars.length()) : "");
//                chars = chars.replaceFirst(String.valueOf(chars.charAt(i)), "");
                return removeAdj(chars);
            }
        }
        return chars;
    }

    public static List<String> interLeaved(String a, String b){
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        Set<String> set = new HashSet<>();
        inter(a, b, 0, 0, set);
        inter(b, a, 0, 0, set);
        System.out.println(set);
        return null;
    }

    public static List<String> interLeaved2(String a, String b){
        inter(a, b, "", a.length() + b.length());
        return null;
    }


    private static void inter(String a, String b, String res, int desiredLen){
        if(res.length() == desiredLen){
            System.out.println(res);
        }
        else{
            if(a.length() > 0){
                inter(a.substring(1, a.length()), b, res + String.valueOf(a.charAt(0)), desiredLen);
            }
            if(b.length() > 0)
            inter(b.substring(1, b.length()), a, res + String.valueOf(b.charAt(0)), desiredLen);
        }

    }

    private static void inter(String a, String b, int i, int j, Set<String> set){
        System.out.println(i + " " + j);
        if(i > a.length()) return;
        if(j > b.length()) return;
        String aa = i == 0 ? "" : a.substring(0, i);
        String bb = j == 0 ? "" : b.substring(0, j);
        String s = aa + bb + a.substring(i, a.length()) + b.substring(j, b.length());
        System.out.println(s);
        set.add(s);

        inter(a, b, i,j+1, set);
        inter(a, b, i+1,j, set);
//        inter(a, b, i,j+1);
    }

//    private static void inter(String a, String b, int i, int j){
//
//        String aSub = i == 0 ? "" : a.substring(0, i);
//        String bSub = j == 0 ? "" : b.substring(0, j);
//        System.out.println(aSub + bSub +a.substring(i, a.length()) + b.substring(j, b.length()));
//
//        if(i > 0){
//            inter(a, b, --i, ++j);
//        }
//
//        if(j > 0){
//            inter(a,b, i, --j);
//        }
//    }

//    private static void interLeaved(char [] a, char [] b, String res, int [] aUsed, int [] bUsed){
//        if(res.length() == a.length + b.length){
////            bUsed = new int[b.length];
////            aUsed = new int[a.length];
//            System.out.println(res);
//        }
//        else{
//            for(int i = 0; i < a.length; i++){
////            bUsed = new int[b.length];
//                if(aUsed[i] != 1){
//                    aUsed[i] = 1;
//                    res = res + String.valueOf(a[i]);
//                    interLeaved(a, b, res, aUsed, bUsed);
//
////                    aUsed[i] = 0;
//                }
////            aUsed[i] = 0;
//            }
//
//            for(int i = 0; i < b.length; i++){
////            bUsed = new int[b.length];
//                if(bUsed[i] != 1){
////                    bUsed[i] = 1;
//                    res = res + String.valueOf(a[i]);
////                    interLeaved(a, b, res, aUsed, bUsed);
//                    interLeaved(b, a, res, bUsed, aUsed);
////                    bUsed[i] = 0;
//                }
////            aUsed[i] = 0;
//            }
//
//            bUsed = new int[b.length];
//            aUsed = new int[a.length];
//
////            for(int i = 0; i < b.length; i++){
//////            bUsed = new int[b.length];
////                if(aUsed[i] != 1){
////                    aUsed[i] = 1;
////                    res = res + String.valueOf(a[i]);
//////                    interLeaved(a, b, res, aUsed, bUsed);
////                    interLeaved(a, b, res, aUsed, bUsed);
////                    aUsed[i] = 0;
////                }
//////            aUsed[i] = 0;
////            }
////            for(int j = 0; j < b.length; j++){
//////            aUsed = new int[a.length];
////                if(bUsed[j] != 1){
////                    bUsed[j] = 1;
////                    res = res + String.valueOf(b[j]);
////                    interLeaved(a,b, res, aUsed, bUsed);
//////                bUsed[j] = 0;
////                }
//////            bUsed[j] = 0;
////            }
//        }
//
//    }


    public static void main(String ar[]){


        String string = Misc.reverseString("abcddcba");
        System.out.println(string);

        string = Misc.reverseWords("hello my name is hero");
        System.out.println(string);

        long docCount = System.currentTimeMillis();
//        Misc.permutation("devesh");
//        Misc.permutation2("", "devesh");
//        Misc.combination("abc");

        Misc.interLeaved2("ab", "cd");

//        System.out.println(Misc.candyCrush("aaaaeeeeeeeeeeedddddddjjjjjjjjjjdddeeeeeeeeez"));
//        System.out.println(Misc.candyCrush("deveeeeeesh"));
        System.out.println(System.currentTimeMillis() - docCount);
    }
}
