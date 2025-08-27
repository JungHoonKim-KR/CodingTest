
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, max;
    static int parent[], candy[], groupSize[], candySum[];
    static List<Integer> groupList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        candy = new int[N + 1];
        groupSize = new int[N + 1];
        candySum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            candy[i] = Integer.parseInt(st.nextToken());
            groupSize[i] = 1;
            candySum[i] = candy[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            if (parent[i] == i)
                groupList.add(i);
        }

        long[][] dp = new long[groupList.size() + 1][K];
        for (int i = 1; i <= groupList.size(); i++) {
            for (int j = 1; j < K; j++) {
                int index = groupList.get(i-1);
                if (groupSize[index] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - groupSize[index]] + candySum[index]);
                // 조건 불만족 시 이전 값 계승
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[groupList.size()][K-1]);

    }

    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (groupSize[rootA] < groupSize[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }
            parent[rootB] = rootA;
            candySum[rootA] += candySum[rootB];
            groupSize[rootA] += groupSize[rootB];
        }
    }


}