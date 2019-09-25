package ds.heap;

import java.util.Arrays;

/**
 * Created by devesh on 11/07/19.
 */
public class MaxHeap {

    int capacity = 2;
    int size = 0;

    int [] items = new int[capacity];


    private void swap(int i, int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private int dataAt(int i){
        return items[i];
    }

    private boolean isValidIndex(int i){
        return i >= 0 && i < size;
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }

    private int getLeftChildIndex(int i){
        return i*2 + 1;
    }

    private int getRightChildIndex(int i){
        return i*2 + 2;
    }

    private boolean hasParent(int i){
        return isValidIndex(getParentIndex(i));
    }

    private boolean hasLeftChild(int i){
        return isValidIndex(getLeftChildIndex(i));
    }

    private boolean hasRightChild(int i){
        return isValidIndex(getRightChildIndex(i));
    }

    private int getParent(int i){
        return dataAt(getParentIndex(i));
    }

    private int getLeftChild(int i){
        return dataAt(getLeftChildIndex(i));
    }

    private int getRightChild(int i){
        return dataAt(getRightChildIndex(i));
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }

    public int peek(){
        if(size == 0) return -1;
        return items[0];
    }

    public int poll(){
        if(size == 0) return -1;
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {

        int index = 0;
        while(hasLeftChild(index)){
            int maxIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) > getLeftChild(index)){
                maxIndex = getRightChildIndex(index);
            }

            if(dataAt(index) > dataAt(maxIndex)){
                break;
            }
            else{
                swap(index, maxIndex);
            }
            index = maxIndex;
        }
    }

    public void add(int i){
        ensureCapacity();
        items[size] = i;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size-1;
        while (hasParent(index) && getParent(index) < dataAt(index)){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public void printHeap(){
        Arrays.stream(items).limit(size).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String ar[]){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(1);
        maxHeap.printHeap();
        maxHeap.add(2);
        maxHeap.printHeap();
        maxHeap.add(3);
        maxHeap.printHeap();
        maxHeap.add(4);
        maxHeap.printHeap();
        maxHeap.add(5);
        maxHeap.printHeap();


        maxHeap.poll();
        maxHeap.printHeap();
        maxHeap.poll();
        maxHeap.printHeap();
    }

}
