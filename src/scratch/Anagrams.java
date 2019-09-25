package scratch;

/**
 * Created by devesh on 01/08/19.
 */
public class Anagrams {

    public void printAnagrams(String str){
        printAnagramsRecursive("", str, 0);
        System.out.println();
    }

    private void printAnagramsRecursive(String prefix, String str, int level){

        if(str.length() == 0){
            System.out.println(prefix);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            printAnagramsRecursive(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()), level+1);
        }
    }

    public static void main(String ar[]){
        Anagrams anagrams = new Anagrams();
        anagrams.printAnagrams("a");
        anagrams.printAnagrams("ab");
        anagrams.printAnagrams("abc");
        anagrams.printAnagrams("abcd");

    }

}
