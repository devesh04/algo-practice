package ds.linked_list;

/**
 * Created by devesh on 16/05/19.
 */
public class LinkNode<T> {
    T data;
    LinkNode next;

    public LinkNode(T obj){
        this.data = obj;
    }

    public LinkNode(T obj, LinkNode node){
        this.data = obj;
        this.next = node;
    }

    public String toString(){
        return this.data.toString();
    }
}
