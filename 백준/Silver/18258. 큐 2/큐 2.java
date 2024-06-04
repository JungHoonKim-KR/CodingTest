import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> dataQueue = new LinkedList<>();
        String line, command;
        int data;
        for(int i=0;i<n;i++){
            line = br.readLine();
            st = new StringTokenizer(line);

            command = st.nextToken();

            if(command.equals("push")){
                data = Integer.parseInt(st.nextToken());
                dataQueue.add(data);
            }
            else if(command.equals("pop")){
                if(dataQueue.isEmpty())
                    bw.write(-1+"\n");
                else
                    bw.write(dataQueue.poll()+"\n");
            }
            else if(command.equals("size")){
                bw.write(dataQueue.size()+"\n");
            }
            else if(command.equals("empty")){
                if(dataQueue.isEmpty())
                    bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(command.equals("front")){
                if(dataQueue.isEmpty())
                    bw.write(-1+"\n");
                else bw.write(dataQueue.peek()+"\n");
            }
            else if(command.equals("back")){
                if(dataQueue.isEmpty())
                    bw.write(-1+"\n");
                else bw.write(((LinkedList<Integer>)dataQueue).getLast()+"\n");
            }


        }
        bw.flush();
        bw.close();

    }
}