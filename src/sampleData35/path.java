package sampleData35;

import java.io.*;
import java.util.Arrays;

public class path {
    private static class node{
        int value;
        node left;
        node right;
        public node(int value){
            this.value=value;
        }
    }
    private static class binaryTree{
        node root;
        int[] value;
        int[] preOrder;
        int[] order;
        int maxSum =Integer.MIN_VALUE;

        public binaryTree(int[] value, int[] preOrder) {
            this.value = value;
            this.preOrder = preOrder;
            order = new int[value.length];
            for(int i =0; i<value.length; i++){
                order[i] = i;
            }
        }

        void build(){
            root = buildTree(0,0,value.length-1);
        }
        node buildTree(int preIndex,int start, int end){
            if(start>end){return null;}
            int inIndex =  findIndex(order,preOrder[preIndex],start,end);

            node curRoot = new node(value[inIndex]);
            if(start == end)
                return curRoot;

            curRoot.left = buildTree(preIndex+1,start,inIndex-1);
            curRoot.right = buildTree(preIndex+1 + (inIndex-start),inIndex+1,end);
            return curRoot;
        }
        int findIndex(int[] array, int value, int start, int end) {
            for (int i = start; i <= end; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1;
        }
        int findSum(){
            sumdfs(root);
            return maxSum;
        }

        int sumdfs(node cur){
            if(cur == null)return Integer.MIN_VALUE;

            int left = sumdfs(cur.left);
            int right = sumdfs(cur.right);
            if(cur.left == null && cur.right == null){
                maxSum = Math.max(maxSum,cur.value);
                return cur.value;
            }
            if(cur.left != null && cur.right != null)
                maxSum = Math.max(maxSum,cur.value + left + right);
            return cur.value + Math.max(left,right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("path.inp"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("path.out"));
        int T = Integer.parseInt(bufferedReader.readLine());
        for(int tc=0;tc<T;tc++){
            int maxNum = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine().trim();
            int[] value = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            s = bufferedReader.readLine().trim();
            int[] order = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            binaryTree binaryTree = new binaryTree(value, order);
            binaryTree.build();
            int sum = binaryTree.findSum();
            bufferedWriter.write(sum+"\n");
        }
        bufferedWriter.close();
    }
}
