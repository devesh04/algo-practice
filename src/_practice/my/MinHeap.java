package _practice.my;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devesh on 30/07/19.
 */
public class MinHeap {

    List<Integer> list = new ArrayList<>();

    public int getParentIndex(int i){
        return (i-1)/2;
    }

    public int getLeftIndex(int i){
        return 2*i + 1;
    }

    public int getRightIndex(int i){
        return 2*i + 2;
    }

    public Integer getParent(int i){
        return list.get(getParentIndex(i));
    }

    private boolean isValidIndex(int i){
        return i >= 0 && i < list.size();
    }

    public boolean hasParent(int i){
        return isValidIndex(getParentIndex(i));
    }

    public boolean hasLeft(int i){
        return isValidIndex(getLeftIndex(i));
    }

    public boolean hasRight(int i){
        return isValidIndex(getRightIndex(i));
    }

    public Integer getLeft(int i){
        return list.get(getLeftIndex(i));
    }

    public Integer getRight(int i){
        return list.get(getRightIndex(i));
    }

    public void add(Integer integer){
        list.add(integer);
        heapifyUp();
    }

    private void swap(int i, int j){
        Integer integer = list.get(i);
        list.set(i, list.get(j));
        list.set(j, integer);
    }

    private void heapifyUp() {
        int size = list.size();
        int currentIndex = size-1;
        while(currentIndex >=0  && getParent(currentIndex) >= 0 && list.get(currentIndex)  < getParent(currentIndex)){
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public Integer peek(){
        return list.get(0);
    }

    public Integer poll(){
        Integer integer = list.get(0);
        heapifyDown();
        list.remove(list.size()-1);
        return integer;
    }

    private void heapifyDown() {
        int size = list.size();
        list.set(0, list.get(size-1));
        int currentIndex = 0;

        while (hasLeft(currentIndex)){
            int inde = getLeftIndex(currentIndex);
            if(hasRight(currentIndex) && getRight(currentIndex) < list.get(inde)){
                inde = getRightIndex(currentIndex);
            }
            if(list.get(inde) < list.get(currentIndex)){
                swap(inde, currentIndex);
            }
            else{
                break;
            }
            currentIndex = inde;
        }
    }

    public static void main(String ar[]){
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(4);

        while(minHeap.list.size() != 0){
            System.out.println(minHeap.poll());
        }

        minHeap.add(89);
        minHeap.add(37);
        minHeap.add(90);

        while(minHeap.list.size() != 0){
            System.out.println(minHeap.poll());
        }

    }
}
