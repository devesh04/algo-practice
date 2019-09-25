package practice;//package com.test.practice;
//
//import java.util.*;
//import java.io.*;
//
//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//
//    public String toString(){
//        return this.data+"";
//    }
//}
//
//class Solution {
//
//	/*
//
//    class Node
//    	int data;
//    	Node left;
//    	Node right;
//	*/
//
//    public static void topView(Node root) {
//
//        Map<Integer, Node> map = new TreeMap<>();
//        LinkedHashMap<Node, Integer> insMap = new LinkedHashMap<>();
//
//        insMap.put(root, 0);
//        while(insMap.size() != 0){
//            recur(map, insMap);
//        }
//
////        recur(root, 0, map);
//        for(Node i : map.values()){
//            System.out.print(i.data + " ");
//        }
//    }
//
//    static void recur(Map<Integer, Node> map, LinkedHashMap<Node, Integer> queue){
//
//
//        Map.Entry<Node, Integer> first = null;
//        for(Map.Entry<Node, Integer> item : queue.entrySet()){
//            first = item;
//            break;
//        }
//
//        Node node = first.getKey();
//        Integer c = first.getValue();
//
//        queue.remove(node);
//
//        if(node == null){
//            return;
//        }
//
//        if(!map.containsKey(c)){
//            map.put(c, node);
//        }
//
//
//        if(node.left != null)
//            queue.put(node.left, c-1);
//        if(node.right != null)
//            queue.put(node.right, c+1);
////        recur(node.left, c -1, map);
////        recur(node.right, c+1, map);
//    }
//
////    public static void topView(Node root) {
////        List<Integer> res = new ArrayList<>();
////        recurLeft(root, res);
////        recurRight(root.right, res);
////
////        for(Integer i : res){
////            System.out.print(i + " ");
////        }
////    }
//
//    static void recurLeft(Node root, List<Integer> list){
//        if(root == null){
//            return;
//        }
//        recurLeft(root.left, list);
//        list.add(root.data);
//        return;
//    }
//
//    static void recurRight(Node root, List<Integer> list){
//        if(root == null){
//            return;
//        }
//        list.add(root.data);
//        recurRight(root.right, list);
//        return;
//    }
//
//	public static Node insert(Node root, int data) {
//        if(root == null) {
//            return new Node(data);
//        } else {
//            Node cur;
//            if(data <= root.data) {
//                cur = insert(root.left, data);
//                root.left = cur;
//            } else {
//                cur = insert(root.right, data);
//                root.right = cur;
//            }
//            return root;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        topView(root);
//    }
//}