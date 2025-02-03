import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int indegree[] = new int[n+1];
        List<List<Integer>>graph = new LinkedList<>();

        for(int i =0; i<=n; i++){
            graph.add(new LinkedList<>());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            indegree[to]++;
        }

        // indegree가 0인 노드 넣기
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        //초기값 찾기
        for(int i =1; i<=n; i++){
            if(indegree[i]==0)
                pq.add(i);
        }
        while(!pq.isEmpty()){
            Integer cur = pq.poll();
            bw.write(cur+" ");
            // 해당 노드와 연결된 노드 확인
            if(!graph.get(cur).isEmpty()){
                for(int c : graph.get(cur)){
                    indegree[c]--;
                    if(indegree[c]==0)
                        pq.add(c);
                }
            }

        }
        bw.flush();


    }
}
