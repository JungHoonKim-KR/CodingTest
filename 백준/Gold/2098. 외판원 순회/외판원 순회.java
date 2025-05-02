import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int W[][];
    static int dp[][];
    static int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1<<N];
        for(int i =0; i<N; i++){
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i], -1);
        }
        // 0번 도시, 0b0001
        // 0번 도시를 시작으로 모든 경로의 최소값
        // 이 때 어느 도시를 시작으로 하든 결국 순환구조이기 때문에 상관 없음
        // 0 -> 1 -> 2 -> 3 -> 0  == 2 -> 3-> 0 -> 1 -> 2
        // 최소값이면 그게 최소 경로임
        System.out.println(tsp(0,1));

    }

    static int tsp(int cur, int visit){
        // 모든 곳 방문
        if(visit == (1 << N ) -1){
            return W[cur][0] == 0? INF : W[cur][0];
        }

        // 이미 방문한 곳
        if(dp[cur][visit] != -1)return dp[cur][visit];

        int minCost = INF;
        for(int next = 0; next<N; next++){
            if((visit & (1<<next)) == 0 && W[cur][next] != 0){
                int newVisit = visit | (1<<next);
                int cost = W[cur][next] + tsp(next, newVisit);
                minCost = Math.min(minCost, cost);

            }
        }
        return dp[cur][visit] = minCost;
    }


}