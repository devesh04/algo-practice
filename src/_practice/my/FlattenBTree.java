package _practice.my;

/**
 * Created by devesh on 30/07/19.
 */
public class FlattenBTree {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        public void addLeft(int i){
            this.left = new Node(i);
        }

        public void addRight(int i){
            this.right = new Node(i);
        }

        public void printInorder(){
            printInorderRecur(this);
        }

        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }

        public void printInorderRecur(Node node){
            if(node == null){
                return;
            }
            printInorderRecur(node.left);
            System.out.println(node.value);
            printInorderRecur(node.right);
        }

        public void flatten(){
            flattenRecur(this);
        }

        public void flattenRecur(Node node){

            if(node == null || node.isLeaf()){
                return;
            }
            flattenRecur(node.left);
            Node rightTemp = node.right;
            Node leftTemp = node.left;
            if(leftTemp != null){
                node.right = leftTemp;
                while(leftTemp.right != null){
                    leftTemp = leftTemp.right;
                }
                leftTemp.right = rightTemp;
            }
            node.left = null;

            flattenRecur(node.right);
        }

    }


    public static void main(String ar[]){
        Node root = new Node(1);
        root.addLeft(2);
        root.addRight(3);

        root.left.addLeft(4);
        root.left.addRight(5);

        root.right.addLeft(6);
        root.right.addRight(7);

        root.printInorder();

        System.out.println();
        root.flatten();
        root.printInorder();

    }

}
