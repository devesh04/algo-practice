package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by devesh on 14/05/19.
 */
public class NormalTree {

    TreeNode root;

    public boolean isEmpty(){
        return root == null;
    }

    @Deprecated
    //wrong logic
    public void add(TreeNode node){
        if(isEmpty()){
            root = node;
            return;
        }
        addRec(node, root);
    }

    private boolean addRec(TreeNode node, TreeNode root) {
        if(root == null) return false;

        if(root.leftChild == null){
            root.leftChild = node;
            return true;
        }
        else if(root.rightChild == null){
            root.rightChild = node;
            return true;
        }

        boolean b = addRec(node, root.leftChild);
        if(b){
            return b;
        }


        boolean b1 = addRec(node, root.rightChild);

        if(b1){
            return b1;
        }
        return false;
    }

    public void insert(TreeNode root, TreeNode node){

        if(root == null){
            this.root = node;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode poll = queue.poll();

            if(poll.leftChild == null){
                poll.leftChild = node;
                break;
            }
            else{
                queue.add(poll.leftChild);
            }

            if(poll.rightChild == null){
                poll.rightChild = node;
                break;
            }
            else{
                queue.add(poll.rightChild);
            }

        }
    }


    public void inorder(){
        inorderRec(this.root);
    }

    public void inorderRec(TreeNode root){
        if(root == null){
            return;
        }
        inorderRec(root.leftChild);
        System.out.print(root);
        inorderRec(root.rightChild);
    }

    public void levelPrint(){
        ArrayList<TreeNode> list = new ArrayList<>();
        if(this.root != null)
        list.add(this.root);
        levelPrintRec(list);
    }

    private void levelPrintRec(List<TreeNode> nodes){

        if(nodes == null || nodes.isEmpty()){
            return;
        }
        List<TreeNode> newNodes = new ArrayList<>();
        for(TreeNode node : nodes){
            System.out.print(node);
            if(node.leftChild != null){
                newNodes.add(node.leftChild);
            }
            if(node.rightChild != null){
                newNodes.add(node.rightChild);
            }
        }
        System.out.println();
        levelPrintRec(newNodes);
    }

    public TreeNode getDeepest(TreeNode node){
        while (node.rightChild != null){
            node = node.rightChild;
        }
        if(node.leftChild != null){
            getDeepest(node);
        }
        return node;
    }

    public TreeNode getDeepestParent(TreeNode node){
        while (node.rightChild != null){
            node = node.rightChild;
        }
        if(node.leftChild != null){
            getDeepest(node);
        }
        return node;
    }

    public void mirrorIt(TreeNode root){
        if(root == null){
            return;
        }
        mirrorIt(root.leftChild);
        mirrorIt(root.rightChild);
        if(root.leftChild != null){
            TreeNode temp = root.rightChild;
            root.rightChild = root.leftChild;
            if(temp != null){
                root.leftChild = temp;
            }
            else{
                root.leftChild = null;
            }
        }
    }

    public void delete(TreeNode node){
        TreeNode rightMost = getDeepest(this.root);
        deleteRec(this.root, node, rightMost);
    }

    public void deleteRec(TreeNode root, TreeNode node, TreeNode rightMost){
        if(root == null){
            System.out.println("not found");
            return;
        }
        if(root.data == node.data){
            rightMost.leftChild = root.leftChild;
            rightMost.rightChild = root.rightChild;
            return;
        }
        deleteRec(root.leftChild, node, rightMost);
        deleteRec(root.rightChild, node, rightMost);
    }



    public static void main(String ar[]){

        NormalTree tree = new NormalTree();
        tree.insert(tree.root, new TreeNode(1));
        tree.insert(tree.root, new TreeNode(2));
        tree.insert(tree.root, new TreeNode(3));
        tree.insert(tree.root, new TreeNode(4));
        tree.insert(tree.root, new TreeNode(5));
        tree.insert(tree.root, new TreeNode(6));
        tree.insert(tree.root, new TreeNode(7));
        tree.insert(tree.root, new TreeNode(8));

//        NormalTree tree = new NormalTree();
//        tree.add(new TreeNode(1));
//        tree.add(new TreeNode(2));
//        tree.add(new TreeNode(3));
//        tree.add(new TreeNode(4));
//        tree.add(new TreeNode(5));
//        tree.add(new TreeNode(6));
//        tree.add(new TreeNode(7));
//        tree.add(new TreeNode(8));

//        tree.inorder();
//        tree.delete(new TreeNode(3));
        tree.levelPrint();
        tree.mirrorIt(tree.root);
        tree.levelPrint();

    }

}
