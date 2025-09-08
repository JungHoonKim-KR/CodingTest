import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        PriorityQueue<int[]>pq = new  PriorityQueue<>((e1,e2)->e1[2]-e2[2]);
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            pq.add(new int[]{0,i, Integer.parseInt(br.readLine())});
        }


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int input = Integer.parseInt(st.nextToken());
                if(i != j){
                    pq.add(new int[]{i,j,input});
                }
            }
        }
        int result = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(union(cur[0],cur[1])){
                result += cur[2];
            }
        }
        System.out.println(result);
    }

    static int find(int n){
        if(parent[n] ==n)return n;
        return  parent[n] = find(parent[n]);
    }

    static boolean union(int n1, int n2){
        int root1 = find(n1);
        int root2 = find(n2);

        if(root1 != root2){
            parent[root2] =  root1;
            return true;
        }
        return false;
    }




}