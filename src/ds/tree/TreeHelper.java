package ds.tree;

/**
 * Created by devesh on 14/05/19.
 */
public class TreeHelper {

    public static void print(TreeNode root){
        if(root != null){
            System.out.print(root);
            print(root.leftChild);
            print(root.rightChild);
        }
    }

    public static void mirror(TreeNode root){

    }

    public static void mirrorRecur(TreeNode root){
        if(root.leftChild != null){
            TreeNode temp = root.rightChild;
            root.rightChild = root.leftChild;
            root.leftChild = temp;
        }

    }

    public static void turnToList(BST bst){
        if(bst == null || bst.rootNode == null){
            return;
        }
        turnToListRec(bst.rootNode);
        TreeNode newRoot = bst.rootNode;
        while(newRoot.leftChild != null){
            newRoot = newRoot.leftChild;
        }

        while(newRoot != null){
            System.out.print(newRoot);
            newRoot = newRoot.rightChild;
        }
    }

    private static TreeNode last = null;

//    public static void turnToListRec(TreeNode root){
//        if(root == null){
//            return;
//        }
//        last = root;
//        turnToListRec(root.leftChild);
//        root.leftChild = last;
//        last.rightChild = root;
//        turnToListRec(root.rightChild);
//    }

    public static TreeNode turnToListRec(TreeNode root){

        if(root == null){
            return null;
        }
        if(root.hasLeftChild()){
            TreeNode treeNode = turnToListRec(root.leftChild);

            while(treeNode.rightChild != null){
                treeNode = treeNode.rightChild;
            }

            treeNode.rightChild = root;
            root.leftChild = treeNode;

        }
        if(root.hasRightChild()){
            TreeNode treeNode = turnToListRec(root.rightChild);
            while (treeNode.leftChild != null){
                treeNode = treeNode.leftChild;
            }
            treeNode.leftChild = root;
            root.rightChild = treeNode;
        }

        return root;
    }
}
