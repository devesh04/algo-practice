package algos.string;

/**
 * Created by devesh on 09/10/18.
 */

public class TSTNode {

    char ch;
    boolean isEndOfString;
    TSTNode left;
    TSTNode equal;
    TSTNode right;


    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public TSTNode getLeft() {
        return left;
    }

    public void setLeft(TSTNode left) {
        this.left = left;
    }

    public TSTNode getEqual() {
        return equal;
    }

    public void setEqual(TSTNode equal) {
        this.equal = equal;
    }

    public TSTNode getRight() {
        return right;
    }

    public void setRight(TSTNode right) {
        this.right = right;
    }

    public boolean isEndOfString() {
        return isEndOfString;
    }

    public void setEndOfString(boolean endOfString) {
        isEndOfString = endOfString;
    }



}
