package ds.arrays;

/**
 * Created by devesh on 03/03/19.
 */
public class Array {


    private static final int RESIZING_FACTOR = 2;

    private int[] arr;
    private int cursor;

    public Array(){
        arr = new int[1];
        cursor = -1;
    }

    private boolean isFull(){
        return cursor == arr.length - 1;
    }

    private void resizeArray(){
        int [] newArr = new int[arr.length * RESIZING_FACTOR];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;

        System.out.println("Resizing to " + arr.length);
    }

    public void add(int i){
        if(isFull()){
            resizeArray();
        }
        cursor++;
        arr[cursor] = i;

//        System.out.println(toString());
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i <= this.cursor; i++){
            stringBuilder.append(this.arr[i] + " ");
        }
        return stringBuilder.toString();
    }

    public static void main(String args[]){
        Array array = new Array();
        for(int i =0; i <  10; i++){
            array.add(i);
        }
//        System.out.println(array.toString());


    }
}
