package ds.trie;

import java.util.List;

/**
 * Created by devesh on 22/05/19.
 */
public class SearchTrie {

    Trie trie;
    TrieNode current;
    String tillNow = "";

    public SearchTrie(Trie e){
        this.trie = e;
        this.current = e.root;
    }



    public void search(char a){
        if(current == null || current.isLeaf()){
            System.out.println("No result Found");
            return;
        }
        TrieNode trieNode = current.children.get(a);
        if(trieNode == null){
            System.out.println("No Result Found2");
            return;
        }

        this.current = trieNode;


        List<String> possible = trieNode.possible();
        if(possible == null || possible.isEmpty()){
            System.out.println("No Result Found3");
            return;
        }
        System.out.println("Suggestions:");
        for(String po : possible){
            System.out.println(this.tillNow + po);
        }

        this.tillNow = this.tillNow + this.current.data;
        System.out.println("--------------------------------");
    }

}
