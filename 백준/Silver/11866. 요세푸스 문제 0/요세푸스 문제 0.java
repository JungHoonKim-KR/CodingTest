import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer>dataQueue = new LinkedList<>();
        IntStream.rangeClosed(1,size).forEach(dataQueue::add);
        bw.write("<");
        for(int i=0;i<size;i++){
            int count = 0;
            int data;
            while(count != k){
                data = dataQueue.poll();
                if(count == k-1 && i != size-1)
                    bw.write(data+", ");
                else if(count == k-1 && i == size-1) bw.write(data+">");
                else dataQueue.add(data);
                count++;
            }
        }
        bw.flush();
        bw.close();
    }
}