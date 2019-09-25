package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devesh on 09/10/18.
 */
public class BST {

    private static final String TAB = "    ";
    TreeNode rootNode;

    public void addData(int data){
        if(this.rootNode == null){
            this.rootNode = new TreeNode(data);
        }
        else{
            this.rootNode = _addData(rootNode, data);
        }

    }

    private TreeNode _addData(TreeNode node, int data){
        if(node == null){
            return new TreeNode(data);
        }
        if(node.data > data){
            node.leftChild = _addData(node.leftChild, data);
        }
        else{
            node.rightChild = _addData(node.rightChild, data);
        }
        return node;
    }

    public void print(){
        _print(this.rootNode);
    }

    private void _print(TreeNode node){
        if(node == null) return;
        _print(node.leftChild);
        System.out.println(node.data);
        _print(node.rightChild);
    }

    public int length(){
        return length(this.rootNode);
    }

    private int length(TreeNode node){
        if(node == null) return 0;
        return Math.max(1+length(node.leftChild), 1+length(node.rightChild));
    }

    public int size(){
        return size(this.rootNode);
    }

    private int size(TreeNode node) {
        if(node == null) return 0;
        return 1 + size(node.leftChild) + size(node.rightChild);
    }

    public void pprint(){
        pprint(this.rootNode, this.rootNode.length());
    }

    private void pprint(TreeNode node, int totalH){
        if(node == null){
            System.out.print("X");
            return;
        }
        for(int i = 0; i < node.length() + 1; i++){
            System.out.print(TAB);
        }
        System.out.println(node.data);
        for(int i = 1; i < node.length(); i++){
            System.out.print(TAB);
        }
        pprint(node.leftChild, totalH);
        for(int i = 0; i< totalH - node.length(); i++){
            System.out.print(TAB);
            System.out.print(TAB);
        }
        pprint(node.rightChild,totalH);
    }

    public void lateralPrint(int level){
        ArrayList<Integer> integers = new ArrayList<>();

        lateralPrint(this.rootNode, level, 0, integers);
        System.out.println(integers);
    }

//    private void lateralPrint(TreeNode node, int level, int h, List<Integer> list) {
//        if(node == null) return;
//        int i = h - node.length() + 1;
//        if(i == level){
//            list.add(node.data);
//        }
//        lateralPrint(node.leftChild, level, h, list);
//        lateralPrint(node.rightChild, level, h, list);
//    }

    private void lateralPrint(TreeNode node, int level, int depth, List<Integer> list) {
        if(node == null){
            return;
        }
        if(depth == level){
            list.add(node.data);
        }
        lateralPrint(node.leftChild, level, depth+1, list);
        lateralPrint(node.rightChild, level, depth+1, list);
    }

    public static void main(String args []){
        BST bst = new BST();
        bst.addData(9);
        bst.addData(1);
        bst.addData(3);
        bst.addData(2);
        bst.addData(4);

//        bst.print();
        System.out.println(bst.length());
        System.out.println(bst.size());
//        bst.pprint();
//        System.out.println();
        bst.lateralPrint(0);
        bst.lateralPrint(1);
        bst.lateralPrint(2);
        bst.lateralPrint(3);
    }

    public static BST basic(){
        BST bst = new BST();
        bst.addData(9);
        bst.addData(1);
        bst.addData(3);
        bst.addData(2);
        bst.addData(4);
        bst.addData(4);
        return bst;
    }

}
