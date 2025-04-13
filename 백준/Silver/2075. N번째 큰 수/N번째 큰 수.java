import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer>q = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o2,o1);
        });

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                q.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i =0; i<n-1; i++){
            q.poll();
        }
        System.out.println(q.poll());

    }
}