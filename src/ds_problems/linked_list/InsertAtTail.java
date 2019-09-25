package ds_problems.linked_list;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertAtTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        if(head == null){
            head = new SinglyLinkedListNode(data);
        }
        else{
            SinglyLinkedListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new SinglyLinkedListNode(data);
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

}