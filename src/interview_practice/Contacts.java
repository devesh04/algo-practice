package interview_practice;//package com.test.interview_practice;
//
//import java.util.HashMap;
//
///**
// * Created by devesh on 12/07/19.
// */
//public class Contacts {
//
//
//    static class Node{
//        char data;
//        HashMap<Character, Node> childs = new HashMap<>();
//        int number;
//
//        public Node(char c){
//            this.data = c;
//        }
//
//        public Node(char c, boolean isLast){
//            this.data = c;
//            this.number = isLast ? 1 : 0;
//        }
//
//        public Node add(char c, boolean isLast){
////            if(data == c){
////                return;
////            }
//            Node node;
//            if(!childs.containsKey(c)){
//                node = new Node(c, isLast);
//                childs.put(c, node);
////                this.number = this.number + node.number;
//            }
//            else{
//                node = childs.get(c);
//            }
//
//            return node;
//
//        }
//
//    }
//
//    static class Trie{
//        Node root = new Node('*');
//
//        public void add(String str){
//            Node node = this.root;
//            for(int i = 0; i <str.length(); i++){
//                Node newNode = node.add(str.charAt(i), i == str.length() - 1);
//                node.number = node.number + newNode.number;
//                node = newNode;
//            }
//        }
//
//        public void addRecur(Node node, String i, boolean isLast){
//            if(node == null){
//                return;
//            }
//            Node add = node.add(c, isLast);
//            node.number = node.number + add.number;
//            addRecur(add, c);
//        }
//
//        public Node find(String str){
//            Node node = this.root;
//            int i = 0;
//            while(node != null && i < str.length() && node.data != str.charAt(i)){
//                node = node.childs.get(str.charAt(i));
//                i++;
//            }
//            return node;
//        }
//
//        public int findCount(String str){
//            Node node = find(str);
//            if(node == null){
//                return -1;
//            }
//            return node.number;
//        }
//    }
//
//    public static void main(String ar[]){
//        Trie trie = new Trie();
//        trie.add("dev");
//        trie.add("dfv");
//        trie.add("div");
//        trie.add("deves");
//        trie.add("dfvqwe");
//        trie.add("dfvqwesdas");
//
//
//        System.out.println(trie.findCount("d"));
//        System.out.println(trie.findCount("de"));
//        System.out.println(trie.findCount("df"));
//        System.out.println(trie.findCount("dev"));
//        System.out.println(trie.findCount("dfvqwesdas"));
//        System.out.println(trie.findCount("abcd"));
//
//
//    }
//}
