import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue<Integer> dataQueue = new LinkedList<>();
        IntStream.rangeClosed(1,num).forEach(dataQueue::add);

        while(dataQueue.size()!=1){
            dataQueue.poll();
            int secondData=dataQueue.poll();
            dataQueue.add(secondData);
        }
        bw.write(dataQueue.peek()+"");
        bw.flush();
        bw.close();
    }
}