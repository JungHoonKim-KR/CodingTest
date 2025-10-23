import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]>list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (p1, p2)->{
            if(p1[0]==p2[0])
                return p1[1]-p2[1];
            return p1[0]-p2[0];
        });

        PriorityQueue<int[]>pq = new PriorityQueue<>((p1, p2) ->{
            return p1[1]-p2[1];
        });

        pq.add(list.get(0));
        int result = 1;
        for(int i = 1; i<list.size(); i++){
            // curStart < end면 회의실 추가
            int[] cur = list.get(i);

            if(cur[0] < pq.peek()[1]){
                pq.add(cur);
                result = Math.max(pq.size(), result);
            }
            else{
                pq.poll();
                pq.add(cur);
            }
        }
        System.out.println(result);


    }


}