package ds.trie;

import java.util.Map;

/**
 * Created by devesh on 22/05/19.
 */
public class Trie {

    TrieNode root;

    public Trie(){
        this.root = new TrieNode('*');
    }

    public static Trie basic(){


        TrieNode first = new TrieNode('c');
        first.addChild(
                new TrieNode('a')
                .addChild(new TrieNode('r').addChild(new TrieNode('t')).addChild(new TrieNode('d')))
                        .addChild(new TrieNode('t')))
                .addChild(new TrieNode('o').addChild(new TrieNode('m').addChild(new TrieNode('e'))));

        Trie trie = new Trie();
        trie.root.addChild(first);

        return trie;
    }

    public static Trie fresh(){
        return new Trie();
    }


    public void addWord(String word){
        char[] chars = word.toCharArray();
        TrieNode currentNode = this.root;
        int currentChar = 0;
        while(currentChar < chars.length){
            char aChar = chars[currentChar];
            if(currentNode.hasChild(aChar)){
                currentNode = currentNode.getChild(aChar);
                currentChar++;
            }
            else{
                TrieNode trieNode = new TrieNode(aChar);
                currentNode.addChild(trieNode);

                currentNode = trieNode;
                currentChar++;
            }
        }
        currentNode.isComplete = true;
    }

    public void printAllCompleteWords(){
        printAllCompleteWordsRec(this.root, "");
    }

    public void print(){
        print(this.root, "");
    }

    private void print(TrieNode root, String prefix) {
        if(root == null){
//            System.out.println(prefix);
            return;
        }
        if(root.children == null || root.children.isEmpty()){
            System.out.println(prefix);
            return;
        }

        for(Map.Entry<Character, TrieNode> node : root.children.entrySet()){
            print(node.getValue(), prefix + node.getKey());
        }
    }

    private void printAllCompleteWordsRec(TrieNode root, String prefix) {
        if(root == null){
            System.out.println(prefix);
            return;
        }
        if(root.isComplete){
            System.out.println(prefix);
        }

        if(root.children == null || root.children.isEmpty()){
            return;
        }

        for(Map.Entry<Character, TrieNode> node : root.children.entrySet()){
            printAllCompleteWordsRec(node.getValue(), prefix + node.getKey());
        }
    }

}
