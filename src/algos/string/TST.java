package algos.string;

/**
 * Created by devesh on 09/10/18.
 */
public class TST {

    TSTNode rootNode;

    public TSTNode addString(TSTNode rootNode, char[] string, int i){
        char c = string[i];
        if(rootNode == null){
            rootNode = new TSTNode();
            rootNode.ch = c;
            rootNode.isEndOfString = (string.length - 1 == i);
        }

        if(rootNode.ch > c){
            rootNode.left = addString(rootNode.left, string, i);
        }
        else if(rootNode.ch < c){
            rootNode.right = addString(rootNode.right, string, i);
        }
        else if(rootNode.ch == c){
            if(string.length - 1 == i) rootNode.isEndOfString = true;
            else
            rootNode.equal = addString(rootNode.equal, string, ++i);
        }

        return rootNode;
    }

    public void print(TSTNode node){
        if(node == null){
            return;
        }
        System.out.println(String.valueOf(node.ch) + (node.isEndOfString ? "1" : "0"));
        print(node.left);
        print(node.equal);
        print(node.right);
    }

    public boolean search(TSTNode node, char [] string, int i){
        if(node == null){
            return false;
        }
        char c = string[i];

        if(string.length -1 == i){
            if( node.isEndOfString && node.ch == c)
                return true;
            return false;
        }

        if(c > node.ch){
            return search(node.right, string, i);
        }
        else if (c < node.ch){
            return search(node.left, string, i);
        }
        else{
            return search(node.equal, string, ++i);
        }

    }

   public static void main(String args[]){
       TST tst = new TST();
       TSTNode tstNode = tst.addString(null, "devesh".toCharArray(), 0);
       tstNode = tst.addString(tstNode, "ginni".toCharArray(), 0);
       tstNode = tst.addString(tstNode, "ginnis".toCharArray(), 0);
       tstNode = tst.addString(tstNode, "devesh".toCharArray(), 0);
       tstNode = tst.addString(tstNode, "devesh".toCharArray(), 0);
       tstNode = tst.addString(tstNode, "devesh".toCharArray(), 0);
//       tst.print(tstNode);
       boolean search = tst.search(tstNode, "devesh".toCharArray(), 0);
       System.out.println(search);
       search = tst.search(tstNode, "ginnis".toCharArray(), 0);
       System.out.println(search);
       search = tst.search(tstNode, "doremon".toCharArray(), 0);
       System.out.println(search);


   }



}
