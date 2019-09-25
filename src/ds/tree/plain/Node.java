package ds.tree.plain;

/**
 * Created by devesh on 16/05/19.
 */
public class Node {

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }


    public String toString(){
        return this.data + "\t";
    }
}
