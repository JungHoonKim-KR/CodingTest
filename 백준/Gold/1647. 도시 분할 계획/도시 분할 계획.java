import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i  = 1; i < N+1; i++){
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2)->e1[2] - e2[2]);
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b,c});
        }
        int result = 0, count = 0;
        while(count != N-2){
            int[] cur = pq.poll();

            if(find(cur[0]) != find(cur[1])){
                union(cur[0], cur[1]);
                result += cur[2];
                count++;
            }
        }
        System.out.println(result);

    }
    static int find(int n){
        if(parent[n] == n){return n;}
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB)
            parent[rootB] = rootA;
    }




}