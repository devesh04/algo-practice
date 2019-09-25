package _practice.my;

import java.util.Stack;

/**
 * Created by devesh on 30/07/19.
 */
public class BTreeZigZag {

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

        public void printZigZag(){
            Stack<Node> stack = new Stack<>();
            Stack<Node> stack1 = new Stack<>();
            stack1.add(this);
            printZigzagRecur(0, stack, stack1);
        }

        private void printZigzagRecur(int level, Stack<Node> stack, Stack<Node> queue){
            if(stack.size() == 0 && queue.size() == 0){
                return;
            }
            if(level%2 == 0){
                while(queue.size() != 0){
                    Node poll = queue.pop();
                    System.out.println(poll.value);
                    if(poll.left != null){
                        stack.add(poll.left);
                    }
                    if(poll.right != null){
                        stack.add(poll.right);
                    }
                }
            }
            else{
                while (stack.size() != 0){
                    Node poll = stack.pop();
                    System.out.println(poll.value);
                    if(poll.right != null){
                        queue.add(poll.right);
                    }
                    if(poll.left != null){
                        queue.add(poll.left);
                    }
                }
            }

            printZigzagRecur(level+1, stack, queue);
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

//        root.printInorder();

        System.out.println();

        root.printZigZag();
//        root.printInorder();
    }

}
