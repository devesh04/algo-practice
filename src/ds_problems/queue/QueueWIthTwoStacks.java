package ds_problems.queue;

import java.util.Scanner;
import java.util.Stack;

class MyQueue<T>{

    Stack<T> in = new Stack<T>();
    Stack<T> out = new Stack<T>();

    public void enqueue(T obj){
        this.in.push(obj);
    }

    private void fillOutPipe(){
        while(!this.in.isEmpty()){
            this.out.push(this.in.pop());
        }
    }

    public void dequeue(){
        if(this.out.isEmpty()){
            fillOutPipe();
        }
        if(!this.out.isEmpty()){
            this.out.pop();
        }
    }

    public T peek(){
        if(this.out.isEmpty()){
            fillOutPipe();
        }
        if(!this.out.isEmpty()){
            return this.out.peek();
        }
        return null;
    }

}

public class QueueWIthTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

