import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            tc++;

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int treeCount = 0;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    boolean isTree = bfs(i, q);
                    if (isTree) treeCount++;
                }
            }

            sb.append("Case ").append(tc).append(": ");
            if (treeCount == 0)       sb.append("No trees.\n");
            else if (treeCount == 1)  sb.append("There is one tree.\n");
            else                       sb.append("A forest of ").append(treeCount).append(" trees.\n");
        }
        System.out.print(sb);
    }

    // 시작 노드, 그리고 큐는 재사용
    static boolean bfs(int start, Queue<int[]> q) {
        visited[start] = true;
        q.clear();
        q.add(new int[]{start, 0}); // {현재, 부모}

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int nxt : graph[cur[0]]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;        // enqueue 시점에 방문 처리
                    q.add(new int[]{nxt, cur[0]});
                } else if (nxt != cur[1]) {
                    // 이미 방문된 노드이면서, 부모가 아닌 경우 → 사이클
                    q.clear();                  
                    return false;
                }
            }
        }
        return true;
    }
}
