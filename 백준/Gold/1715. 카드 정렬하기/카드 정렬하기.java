import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        for(int i =0; i<n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count=0;
        while(pq.size()!=1){
            Integer card1 = pq.poll();
            Integer card2 = pq.poll();
            count+= card1 + card2;
            pq.add(card1+card2);
        }
        System.out.println(count);

    }

}