package ds.linked_list;

/**
 * Created by devesh on 16/05/19.
 */
public class LinkList<T> {

    LinkNode<T> root;

    public LinkList(){

    }

    public void add(T obj){
        LinkNode<T> lastNode = getLastNode();
        if(lastNode == null){
            this.root = new LinkNode<T>(obj);
        }
        else{
            lastNode.next = new LinkNode(obj);
        }
    }

    public void add(int i, T obj){
        if(i < 0){
            System.out.println("negative index not allowed");
            return;
        }
        if(i == 0){
            LinkNode<T> firstNode = getFirstNode();
            if(firstNode == null){
                add(obj);
            }
            else{
                LinkNode<T> tLinkNode = new LinkNode<>(obj);
                tLinkNode.next = this.root;
                this.root = tLinkNode;
            }
            return;
        }
        LinkNode<T> newNode = new LinkNode<T>(obj);
        int pointer = 0;
        LinkNode current = this.root;
        while(current != null && pointer < i - 1){
            current = current.next;
            pointer++;
        }

        if(i == pointer){

            if(current.next != null)
                newNode.next = current.next;
            current.next = newNode;
            if(i == 0){

            }
        }
        else{
            System.out.println("i too large");
        }
    }

    private LinkNode<T> getLastNode(){
        if(root == null){
            return null;
        }
        LinkNode c = root;
        while(c.next != null){
            c = c.next;
        }
        return c;
    }

    private LinkNode<T> getFirstNode(){
        if(root == null){
            return null;
        }
        return this.root;
    }

    public String toString(){
        LinkNode current = this.root;
        StringBuilder stringBuilder = new StringBuilder();
        while(current != null){
            stringBuilder.append(current + "\t");
            current = current.next;
        }
        return stringBuilder.toString();
    }


    public static void main(String ar[]){
        LinkList<Integer> linkList = new LinkList();
        linkList.add(0, 10);
        linkList.add(0, 20);
        linkList.add(0, 30);
        linkList.add(0, 40);
        linkList.add(0, 50);
        System.out.println(linkList);

    }
}
