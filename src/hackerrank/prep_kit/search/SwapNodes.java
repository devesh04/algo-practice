package hackerrank.prep_kit.search;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 */

public class SwapNodes {

    static class Tree {

        int [] tree;
        int currentPointer;

        public Tree(Integer numberOfNodes){
            this.tree = new int[numberOfNodes];
            this.tree[0] = 1;
            currentPointer++;
        }

        public void add(int [] nodes){
            this.tree[currentPointer++] = nodes[0];
            this.tree[currentPointer++] = nodes[1];
        }

        public void resetPointer(){
            currentPointer = 0;
        }

        public int getLChildIndex(int i){
            return 2*i + 1 < this.tree.length ? 2*i + 1 : -1;
        }

        public int getRChildIndex(int i){
            return 2*i + 2 < this.tree.length ? 2*i + 2 : -1;
        }

        public int getLChild(int i){
            if(2*i + 1 < this.tree.length){
                return this.tree[2*i + 1];
            }
            else{
                return -1;
            }
        }

        public int getRChild(int i){
            if(2*i + 1 < this.tree.length){
                return this.tree[2*i + 2];
            }
            else{
                return -1;

            }
        }

        public int getData(int i){
            if(i >= 0 && i < this.tree.length){
                return this.tree[i];
            }
            return -1;
        }

        public boolean isLeaf(int i){
            return getLChild(i) == -1 && getRChild(i) == -1;
        }

        public boolean isValidPointer(int i){
            return i >= 0 && i < this.tree.length;
        }

        public void swapDeep(int i){
            swapDeepRecur(i);
        }

        private void swapDeepRecur(int i){
            if(!isValidPointer(i))
                return;

//            System.out.println(i);

            if(isLeaf(i))
                return;

            int l = getLChildIndex(i);
            int r = getRChildIndex(i);
            swapDeepRecur(getLChildIndex(i));
            swapDeepRecur(getRChildIndex(i));

            int temp = getData(l);
            this.tree[l] = this.tree[r];
            this.tree[r] = temp;

        }

        public void swap(int k) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 1});
            swapRecur(k, queue);
        }

        private void swapRecur(int k, Queue<int[]> queue){
            if(queue.isEmpty()){
                return;
            }

            int[] poll = queue.poll();

            int pointer = poll[0];
            int h = poll[1];

            if(!isValidPointer(pointer))
                return;

            if(isLeaf(pointer))
                return;

            int lChildIndex = getLChildIndex(pointer);
            int rChildIndex = getRChildIndex(pointer);


            if(h%k == 0){
                swapDeep(pointer);

                printInorder();
//                int temp = getData(lChildIndex);
//                this.tree[lChildIndex] = this.tree[rChildIndex];
//                this.tree[rChildIndex] = temp;
            }

            queue.add(new int[]{lChildIndex, h+1});
            queue.add(new int[]{rChildIndex, h+1});

//            swapRecur( h+1, k);
//            swapRecur(rChildIndex, h+1, k);

            swapRecur(k, queue);

        }


        public void printInorder(){
            printInorderRecur(0);
            System.out.println();
        }

        private void printInorderRecur(int pointer){

            if(!isValidPointer(pointer)){
                return;
            }

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
    static void swapNodes(int[][] indexes, int[] queries) {

        Tree tree = new Tree(2*indexes.length + 1);
        for(int i = 0; i < indexes.length; i++){
            tree.add(indexes[i]);
        }

        tree.printInorder();
        System.out.println(">><<<>>");

        for(int i = 0; i < queries.length; i++){
            tree.swap(queries[i]);
            tree.printInorder();
        }

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

//        int[][] result = swapNodes(indexes, queries);
        swapNodes(indexes, queries);

//        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
//            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
//                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
//
//                if (resultColumnItr != result[resultRowItr].length - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            if (resultRowItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
