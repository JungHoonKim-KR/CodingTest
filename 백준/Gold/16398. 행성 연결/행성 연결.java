import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2)-> e1[2] -  e2[2]);
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(i != j){
                    pq.add(new int[]{i,j,input});
                }
            }
        }
        long result = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(union(cur[0], cur[1])){
                result += cur[2];
            }
        }
        System.out.println(result);
    }

    static int find(int n){
        if(parent[n] == n)return n;
        return parent[n] = find(parent[n]);
    }

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] =  rootA;
            return true;
        }
        return false;
    }


}