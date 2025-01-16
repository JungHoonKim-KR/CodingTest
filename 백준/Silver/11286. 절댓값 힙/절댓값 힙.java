import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            int compare = Math.abs(o1) - Math.abs(o2);
            if(compare ==0){
                return o1 - o2;
            }
            return compare;
        });
        StringBuilder sb = new StringBuilder();


        for(int i =0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num ==0){
                if(pq.isEmpty()){
                    sb.append(num+"\n");
                }
                else sb.append(pq.poll()+"\n");
            }
            else pq.add(num);
        }
        System.out.println(sb);

    }


}
