package sampleData7;

import java.io.*;
import java.util.StringTokenizer;

class SegmentTree {
    int treeSize;
    int tree[];
    long arr[];

    SegmentTree(int arrSize) {
        int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int) Math.pow(2, height + 1);
        this.tree = new int[treeSize];
        this.arr = new long[arrSize];
    }

    int init(int node, int start, int end) {
        if (start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        int left = init(node * 2, start, mid);
        int right = init(node * 2 + 1, mid + 1, end);
        return tree[node] = (arr[left]<=arr[right])?left:right;
    }

    int query(int node, int start, int end, int left, int right){
        if(left > end || right<start) return -1;
        if(left <= start && right>=end) return tree[node];

        int mid = (start+end)/2;
        int leftIndex = query(node*2,start,mid,left,right);
        int rightIndex = query(node*2+1,mid+1,end,left,right);
        if(leftIndex==-1) return rightIndex;
        if(rightIndex == -1) return leftIndex;
        return (arr[leftIndex] <= arr[rightIndex])? leftIndex:rightIndex;
    }

    void update(int node, int start, int end, int index, long value) {
        if (index < start || end < index) return;
        if (start == end) {
            arr[index] = value;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);
        int leftIndex = tree[node*2];
        int rightIndex = tree[node*2 +1];
        tree[node] = (arr[leftIndex] <= arr[rightIndex])?leftIndex:rightIndex;
    }

//    long sum(int node, int start, int end, int left, int right) {
//        if (left > end || right < start) return 0;
//
//        if (left <= start && right >= end) return tree[node];
//
//        int mid = (start + end) / 2;
//        return sum(node, start, mid, left, right) + sum(node, mid + 1, end, left, right);
//    }
}
public class rmq {
    public static void main(String[] args) throws IOException {
        File file1 = new File("rmq.inp");
        File file2 = new File("rmq.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer st;

        int arraySize = Integer.parseInt(bufferedReader.readLine());
        int num = 20;
        SegmentTree segmentTree = new SegmentTree(arraySize);
        long firstIndex, lastIndex, sumIndex=0;
        String command = null;
        st = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<arraySize-1;i++){
            if(num == 0){
                st = new StringTokenizer(bufferedReader.readLine());
                num = 19;
            }else num --;
            long data = Long.parseLong(st.nextToken());
            segmentTree.arr[i] = data;
        }

        segmentTree.init(1,0,arraySize-1);
        bufferedReader.readLine();

        while(true) {
            st = new StringTokenizer(bufferedReader.readLine());
            command = st.nextToken();
            if (command.equals("s")) break;

            firstIndex = Long.parseLong(st.nextToken());
            lastIndex = Long.parseLong(st.nextToken());

            if(command.equals("c")){
                segmentTree.update(1,0,arraySize-1, (int) firstIndex, lastIndex);
            }
            else {
                sumIndex += segmentTree.query(1,0,arraySize-1, (int) firstIndex, (int) lastIndex);
            }
        }
        fileWriter.write(sumIndex % 100000+"");
        fileWriter.flush();
        fileWriter.close();

    }
}
