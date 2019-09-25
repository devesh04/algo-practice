package scratch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by devesh on 06/08/19.
 */
public class TreeCamera {

    static class Node{
        int value;
        Node left;
        Node right;
//        boolean camera;


        public Node(int value){
            this.value = value;
        }

        public Node addLeft(int value){
            this.left = new Node(value);
            return this.left;
        }


        public Node addRight(int value){
            this.right = new Node(value);
            return this.right;
        }


        public int getMinCameras(){

            Queue<Node> queue = new LinkedList<>();
            HashSet<Node> cameras = new HashSet<>();
            queue.add(this);

            int count = 0;
            while(!queue.isEmpty()){
                count+=getMinCamerasRecur(queue, cameras, 0);
            }

            int count2 = 1;

//            this.camera = true;
            queue = new LinkedList<>();
            cameras = new HashSet<>();
            cameras.add(this);
            queue.add(this);
            while(!queue.isEmpty()){
                count2+=getMinCamerasRecur(queue, cameras, 0);
            }
            return Math.min(count, count2);
        }

        private int getMinCamerasRecur(Queue<Node> queue, Set<Node> cameras,  int count){
            Node node = queue.poll();
            if(node == null){
                return count;
            }
            if(cameras.contains(node) == true){
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            else{
                if(node.left != null){
                    cameras.add(node.left);
//                    node.left.camera = true;
                    queue.add(node.left);
                    count++;
                }
                if(node.right != null){
                    cameras.add(node.right);
//                    node.right.camera = true;
                    queue.add(node.right);
                    count++;
                }
            }
            return count;

        }

    }


    public static void main(String ar[]){
        Node node = new Node(0);
        node.addLeft(0).addLeft(0).addLeft(0).addRight(0);
//        Node right = node.addRight(3);


        System.out.println(node.getMinCameras());

    }

}
