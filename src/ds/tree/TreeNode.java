package ds.tree;

/**
 * Created by devesh on 09/10/18.
 */
public class TreeNode {

    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(){

    }

    public TreeNode(int data){
        this(data, null, null);
    }

    public TreeNode(int data, TreeNode leftChild, TreeNode rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int size() {
        int size = 1;
        if(leftChild != null){
            size += leftChild.size();
        }
        if(rightChild != null){
            size += rightChild.size();
        }
        return size;
    }

    public int length() {
        int leftH = 0;
        int rightH = 0;
        if(leftChild != null){
            leftH = leftChild.length();
        }
        if(rightChild != null){
            rightH = rightChild.size();
        }
        return Math.max(leftH, rightH) + 1;
    }

    public String toString(){
        return this.data + "\t";
    }

    public boolean isLeaf(){
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean hasLeftChild(){
        return this.leftChild != null;
    }

    public boolean hasRightChild(){
        return this.rightChild != null;
    }
}
