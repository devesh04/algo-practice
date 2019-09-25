package _practice.my;

import java.util.*;

/**
 * Created by devesh on 30/07/19.
 */
public class BTreeKDistanceFromNode {

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

        public List<Node> getNodesAtDistance(int k, Node root, Node node){
            Map<Node, Node> parentMap = getParentMap(root);
            Set<Node> visited = new HashSet<>();
            Queue<Node> queue = new LinkedList<>();
            Node currentNode = node;
            queue.add(currentNode);
            while(k != 0){
                int size = queue.size();
                while(size != 0){
                    Node poll = queue.poll();
                    if(poll.left != null && !visited.contains(poll.left)){
                        queue.add(poll.left);
                        visited.add(poll.left);
                    }
                    if(poll.right != null && !visited.contains(poll.right)){
                        queue.add(poll.right);
                        visited.add(poll.right);
                    }
                    if(parentMap.get(poll) != null && !visited.contains(parentMap.get(poll))){
                        queue.add(parentMap.get(poll));
                        visited.add(parentMap.get(poll));
                    }
                    size--;
                }
                k--;
            }
            return (List<Node>) queue;
        }

        private Map<Node,Node> getParentMap(Node root) {
            HashMap<Node, Node> map = new HashMap<>();
            getParentMapRecur(root, map);
            return map;
        }

        private void getParentMapRecur(Node root, Map<Node, Node> nodeMap){
            if(root == null){
                return;
            }
            if(root.left != null){

                nodeMap.put(root.left, root);
            }
            if(root.right != null){
                nodeMap.put(root.right, root);
            }
            getParentMapRecur(root.left, nodeMap);
            getParentMapRecur(root.right, nodeMap);
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
        List<Node> nodesAtDistance = root.getNodesAtDistance(2, root, root.left);

        for(Node no : nodesAtDistance){
            System.out.println(no.value);
        }
//        root.printInorder();
    }

}
