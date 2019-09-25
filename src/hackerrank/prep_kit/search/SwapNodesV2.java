package hackerrank.prep_kit.search;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


/*
https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 */

public class SwapNodesV2 {

    static class Tree {

        int [][] tree;
        int currentPointer;

        public Tree(Integer numberOfNodes){
            this.tree = new int[numberOfNodes][2];
            this.currentPointer = 0;
        }

        public void add(int [] nodes){
            this.tree[currentPointer++] = nodes;
        }

        public void resetPointer(){
            currentPointer = 0;
        }

        public int getLChildIndex(int i){
            return tree[i][0] - 1;
        }

        public int getRChildIndex(int i){
            return tree[i][1] - 1;
        }

        public int getLChild(int i){
            return tree[i][0];
        }

        public int getRChild(int i){
            return tree[i][1];
        }

        public int getData(int i){
            return i+1;
        }

        public boolean isLeaf(int i){
            return getLChild(i) == -1 && getRChild(i) == -1;
        }

        public boolean isValidPointer(int i){
            return i >= 0 && i < this.tree.length;
        }

        public void swapDeep(int i){
//            System.out.println("stringtin swap deep " + i);
            swapDeepRecur(i);
//            printInorder();
        }

        private void swapDeepRecur(int i){
//            System.out.println("herre is the i" + i);
            if(!isValidPointer(i))
                return;

//            System.out.println(i);

            if(isLeaf(i))
                return;

            int l = getLChildIndex(i);
            int r = getRChildIndex(i);
            swapDeepRecur(getLChildIndex(i));


//            int temp = getData(l);
            int temp = this.tree[i][0];
            this.tree[i][0] = this.tree[i][1];
            this.tree[i][1] = temp;

//            System.out.println("swapping- " + (i+1)  + " >>"  + this.tree[i][0] +  " from " + this.tree[i][1]);


            swapDeepRecur(getRChildIndex(i));

//            this.tree[l] = this.tree[r];
//            this.tree[r] = temp;

        }

        public void swap(int k) {
//            System.out.println("k>" + k);
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 1});
            while (!queue.isEmpty())
                swapRecur(k, queue);
        }

        private void swapRecur(int k, Queue<int[]> queue){
            if(queue.isEmpty()){
                return;
            }

            int[] poll = queue.poll();

            int pointer = poll[0];
            int h = poll[1];

//            System.out.println("h>" + h);

            if(!isValidPointer(pointer))
                return;

            if(isLeaf(pointer))
                return;

            int lChildIndex = getLChildIndex(pointer);
            int rChildIndex = getRChildIndex(pointer);


            if(h%k == 0){
                swapDeep(pointer);

//                printInorder();
//                int temp = getData(lChildIndex);
//                this.tree[lChildIndex] = this.tree[rChildIndex];
//                this.tree[rChildIndex] = temp;
            }

            queue.add(new int[]{lChildIndex, h+1});
            queue.add(new int[]{rChildIndex, h+1});

//            swapRecur( h+1, k);
//            swapRecur(rChildIndex, h+1, k);

//            swapRecur(k, queue);

        }


        public int[] getInorder(){
            int [] res = new int[this.tree.length];
            List<Integer> list = new ArrayList<>();
            printInorderRecur(list, 0, 0);

            for(int i = 0; i < res.length; i++){
                res[i] = list.get(i);
            }
            return res;
//            System.out.println();
        }

        private void printInorderRecur(List<Integer> list, int pointer, int arrPointer){

            if(!isValidPointer(pointer)){
                return;
            }

//            if(getData(pointer) == -1){
//                return;
//            }

            printInorderRecur(list, getLChildIndex(pointer), arrPointer+1);

            int data = getData(pointer);
            if(data != -1){
                list.add(data);
//                res[arrPointer] = data;
//                arrPointer++;
//                System.out.print(data + " ");
            }

            printInorderRecur(list, getRChildIndex(pointer), arrPointer+1);
        }

        public void printInorder(){
            printInorderRecur(0);
            System.out.println();
        }

        private void printInorderRecur(int pointer){

            if(!isValidPointer(pointer)){
                return;
            }

//            if(getData(pointer) == -1){
//                return;
//            }

            printInorderRecur(getLChildIndex(pointer));

            int data = getData(pointer);
            if(data != -1){
                System.out.print(data + " ");
            }

            printInorderRecur(getRChildIndex(pointer));
        }


    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {

        Tree tree = new Tree(indexes.length);
        for(int i = 0; i < indexes.length; i++){
            tree.add(indexes[i]);
        }

//        tree.printInorder();
//        System.out.println(">><<<>>");

        int result [][] = new int[queries.length][indexes.length];

        for(int i = 0; i < queries.length; i++){
            tree.swap(queries[i]);
            result[i] = tree.getInorder();
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
