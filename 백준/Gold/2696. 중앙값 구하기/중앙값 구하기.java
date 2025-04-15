import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer>leftQueue = new PriorityQueue<>((o1,o2)->{
                return o2-o1;
            });
            PriorityQueue<Integer>rightQueue = new PriorityQueue<>();
            sb.append((n+1)/2).append("\n");
            int count=0;
            for(int i =0; i<(n+9)/10;i++){
                int input [] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int j=0; j<input.length; j++){
                    count++;
                    leftQueue.add(input[j]);

                    if(!rightQueue.isEmpty() && leftQueue.peek() > rightQueue.peek()){
                        int left = leftQueue.poll();
                        int right = rightQueue.poll();
                        rightQueue.add(left);
                        leftQueue.add(right);
                    }

                    if(leftQueue.size() - rightQueue.size() ==2)
                        rightQueue.add(leftQueue.poll());
                    if(count%2==1)
                        sb.append(leftQueue.peek()+" ");

                    if(count/2==10){
                        sb.append("\n");
                        count=0;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}