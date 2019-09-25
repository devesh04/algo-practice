package practice;

import java.util.Scanner;

class Solution {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

  	public static void preOrder( Node root ) {

    	if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

	public static Node insert(Node root,int data) {
        return recur(root, data);
//    	    return root;
    }

    static Node recur(Node node, int data){
        if(node == null){
            node = new Node(data);
            return node;
        }
        if(node.data > data){
            node.left = recur(node.left, data);
        }
        else{
            node.right = recur(node.right, data);
        }
        return node;
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }
}