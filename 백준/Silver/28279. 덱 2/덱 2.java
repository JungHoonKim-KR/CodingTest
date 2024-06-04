import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int data = Integer.parseInt(st.nextToken());
                deque.addFirst(data);
            }
            else if(command == 2){
                int data = Integer.parseInt(st.nextToken());
                deque.addLast(data);
            }
            else if(command == 3){
                Integer result = deque.pollFirst();
                bw.write((result != null? result:-1)+"\n");
            }
            else if(command == 4){
                Integer result = deque.pollLast();
                bw.write((result != null? result:-1)+"\n");
            }
            else if(command==5) bw.write(deque.size()+"\n");
            else if(command==6) bw.write((deque.isEmpty()?1:0)+"\n");
            else if(command==7) bw.write((deque.isEmpty()? -1: deque.peekFirst())+"\n");
            else if(command==8) bw.write((deque.isEmpty()?-1:deque.peekLast())+"\n");
        }
        bw.flush();
        bw.close();
    }
}