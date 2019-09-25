package ds.trie;

import java.util.Scanner;

/**
 * Created by devesh on 22/05/19.
 */
public class Main {

    static Scanner s = new Scanner(System.in);


    public static void main(String a[]){
        Trie basic = Trie.basic();
        SearchTrie searchTrie = new SearchTrie(basic);
        String ss;
        while(!(ss = Main.s.nextLine()).equals("\n\n")){
//            String s = Main.s.nextLine();
            searchTrie.search(ss.charAt(0));
        }

        Trie fresh = Trie.fresh();
        fresh.addWord("hello");
        fresh.addWord("hiii");
        fresh.addWord("hiiiyy");
        fresh.addWord("hey");
        fresh.addWord("hi");
        fresh.addWord("him");
        fresh.addWord("hola");
        fresh.addWord("bola");
        fresh.addWord("ola");

//        fresh.printAllCompleteWords();
        fresh.print();
    }

}
