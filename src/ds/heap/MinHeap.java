package ds.heap;

import java.util.Arrays;

/**
 * Created by devesh on 11/07/19.
 */
public class MinHeap {

    private static final int INITIAL_CAPACITY = 8;

    private int capacity = INITIAL_CAPACITY;
    private int size;
    private int [] items = new int[INITIAL_CAPACITY];

    private int getLeftIndex(int i){
        return i*2 + 1;
    }

    private int getRightIndex(int i){
        return i*2 + 2;
    }

    private int getParentIndex(int i){
        return (i -1) / 2;
    }

    private boolean isValidIndex(int i){
        return i >= 0 && i < this.size;
    }

    private boolean hasParent(int i){
        return isValidIndex(getParentIndex(i));
    }

    private boolean hasLeftChild(int i){
        return isValidIndex(getLeftIndex(i));
    }

    private boolean hasRightChild(int i){
        return isValidIndex(getRightIndex(i));
    }

    private int getParent(int i){
        return this.items[getParentIndex(i)];
    }

    private int getLeftChild(int i){
        return this.items[getLeftIndex(i)];
    }

    private int getRightChild(int i){
        return this.items[getRightIndex(i)];
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }

    private void swap(int i, int j){
        int item = this.items[i];
        items[i] = items[j];
        items[j] = item;
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

    public void add(int i){
        ensureCapacity();
        items[size] = i;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && getParent(index) > items[index]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int minIndex = getLeftIndex(index);
            if(hasRightChild(index) && items[getRightIndex(index)] < items[minIndex]){
                minIndex = getRightIndex(index);
            }

            if(items[index] > items[minIndex]){
                swap(index, minIndex);
            }
            else{
                 break;
            }
            index = minIndex;
        }
    }

    public void printHeap(){
        for(int i = 0; i < size; i++){
            System.out.print(items[i]);
        }
        System.out.println();
    }


    public static void main(String ar[]){
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        minHeap.printHeap();
        minHeap.add(2);
        minHeap.printHeap();
        minHeap.add(3);
        minHeap.printHeap();
        minHeap.add(4);
        minHeap.printHeap();
        minHeap.add(0);
        minHeap.printHeap();

        minHeap.poll();
        minHeap.printHeap();


    }


}
