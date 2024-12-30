import java.io.*;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] structType = br.readLine().split(" ");
        String[] data = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        Deque<String> queue = new LinkedList<>();
        for(int i =0; i<n;i++){
            if(structType[i].equals("0")){
                queue.addFirst(data[i]);
            }
        }
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i =0; i<m; i++){
            queue.addLast(st.nextToken());
            bw.write(queue.pollFirst()+" ");
        }
        bw.flush();
        bw.close();
    }


}