package logic_problems;

import java.io.IOException;
import java.util.Scanner;


class Node{
    int value; //for leaf since we know length already
    Node[] childs = new Node[2];

    public Node(){
    }
}

class Trie{

    Node root;

    public Trie(){
        this.root = new Node();
    }

//    public void add(String s){
//        addRecur(s.toCharArray(), 0, this.root);
//    }
//
//    public void add(char[] s){
//        addRecur(s, 0, this.root);
//    }

    public int getBit(int num, int i){
        return (num & (1 << i)) != 0 ? 1 : 0;
    }

    public void add(int num){
//        System.out.println(num);
        Node current = this.root;
        for(int i = 32 -1; i >=0; i--){
//        for(int i = 0; i < 32; i++){
//            System.out.println("it:" + i);
            int toAdd = getBit(num, i);
//            System.out.println("toAdd" + toAdd);
            if(current.childs[toAdd] == null){
                current.childs[toAdd] = new Node();
            }
            current = current.childs[toAdd];
        }
//        System.out.println();
        current.value = num;
    }

    int getClosest(int num){
        Node current = this.root;
        for(int i = 32 -1; i >=0; i--){
            int toFind = getBit(num, i) ^ 1;
//            System.out.println(">>"+toFind);
//            System.out.println("<<"+(toFind^1));
            if(current.childs[toFind] == null){
                current = current.childs[toFind^1];
            }
            else{
                current = current.childs[toFind];
            }
        }
        return num ^ current.value;
    }


//    public void print(){
//        print(this.root, "");
//    }
//
//
//    private void print(Node root, String prefix) {
//        if(root == null){
////            System.out.println(prefix);
//            return;
//        }
//        if(root.childs[0] == null && root.childs[1] == null){
//            System.out.println(prefix);
//            return;
//        }
//
//        for(Node node : root.childs){
//            print(node, prefix + node.getKey());
//        }
//    }

}

public class XorQueriesOpti {



    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {
        // solve here

        Trie trie = new Trie();
        for(int i = 0; i < arr.length;  i++){
            trie.add(arr[i]);
        }

        int [] res = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            int closest = trie.getClosest(queries[i]);
            res[i] = closest;
        }
        return res;


//        int [] res = new int[queries.length];
//        for(int i = 0 ; i < queries.length; i++){
//            int max = Integer.MIN_VALUE;
//            for(int j = 0; j < arr.length; j++){
//                int xor = getXor(arr[j], queries[i]);
//                if(max < xor){
//                    max = xor;
//                }
//            }
//            res[i] = max;
//        }
//        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "");
//            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
            }
        }

//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }


}
