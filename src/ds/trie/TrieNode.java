package ds.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devesh on 22/05/19.
 */
public class TrieNode {

    char data;
    Map<Character, TrieNode> children;
    boolean isLeaf;
    boolean isComplete;

    public TrieNode(char data){
        this.data = data;
    }

    public TrieNode addChild(TrieNode node){
        if(children == null){
            this.children = new HashMap<>();
        }
        this.children.put(node.data, node);
        if(isLeaf){
            isLeaf = !isLeaf;
        }
        return this;
    }

    public boolean isLeaf(){
        return children == null || children.isEmpty();
    }

    public String toString(){
        return String.valueOf(data);
    }

    public List<String> possible(){

        ArrayList<String> res = new ArrayList<>();
        possibleRecursive(this, ""+this.data, res);
        return res;

//        if(!isLeaf()){
//            List<String> result = new ArrayList<>();
//            for(Character character : children.keySet()){
//                String res = ""+this.data;
//                List<String> possible = children.get(character).possible();
//                if(possible != null){
//                    for(String po : possible){
//                        res  = res + po;
//                        result.add(res);
//                    }
//                }
//                else{
//                    result.add(res);
//                }
//            }
//        }
//        return null;
    }

    private void possibleRecursive(TrieNode current, String prefix, List<String> list){
        if(current == null){
            list.add(prefix);
            return;
        }
        Map<Character, TrieNode> children = current.children;
        if(children == null || children.isEmpty()){
            list.add(prefix);
            return;
        }
        for(Character character : children.keySet()){
            possibleRecursive(children.get(character), prefix+character, list);
        }
    }

    public boolean hasChild(Character c){
        return this.children != null && this.children.containsKey(c);
    }


    public TrieNode getChild(Character c){
        return this.children.get(c);
    }

}
