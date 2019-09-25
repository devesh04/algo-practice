package ds.tree.plain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by devesh on 16/05/19.
 */
public class Tree {

    Node root;

    public Tree(){
        root = new Node(10,
                new Node(20, new Node(40), new Node(50)),
                new Node(30, new Node(60), new Node(70)));
    }

    public void inorderPrint(){
        inorderPrintRec(root);
    }

    public void inorderPrintRec(Node current){
        if(current == null) return;

        System.out.print(current + "\t");

        inorderPrintRec(current.left);

        inorderPrintRec(current.right);
    }

    public void spiralTraversal(){
        Stack<Node> nodes = new Stack<>();
        nodes.add(this.root);

        Stack<Node> stack = new Stack<>();
//        stack.add(this.root);
        spiralTraversalRec(0, stack, nodes);
    }

    public void spiralTraversalRec(int h, Stack<Node> stack, Stack<Node> queue){
        if(h%2 == 0){
            while (!stack.isEmpty()){
                Node poll = stack.pop();
                System.out.print(poll);

                if(poll.right != null){
                    queue.add(poll.right);
                }
                if(poll.left != null){
                    queue.add(poll.left);
                }

            }

        }
        else {
            while (!queue.isEmpty()) {
                Node pop = queue.pop();
                System.out.print(pop);

                if (pop.left != null) {
                    stack.add(pop.left);
                }
                if (pop.right != null) {
                    stack.add(pop.right);
                }


            }
        }
        if(!queue.isEmpty() || !stack.isEmpty()){
            spiralTraversalRec(h+1, stack, queue);
        }
    }


    public void lateralTraversal(){
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(this.root);
        lateralTraversalRec(nodes);
    }

    public void lateralTraversalRec(Queue<Node> queue){
        if(queue.isEmpty()) return;
        Node poll = queue.poll();
        System.out.print(poll);
        if(poll.left != null){
            queue.add(poll.left);
        }
        if(poll.right != null){
            queue.add(poll.right);
        }
        lateralTraversalRec(queue);
    }



    public String toString(){
        return root.toString();
    }

    public static void main(String ar[]){
        Tree tree = new Tree();
//        tree.inorderPrint();
//        tree.lateralTraversal();
        tree.spiralTraversal();
    }
}
