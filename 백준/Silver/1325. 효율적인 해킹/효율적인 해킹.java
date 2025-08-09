import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean visit[];
    static int maxArr[];
    static int n,m,c,p,max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        maxArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            graph[c].add(p);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (!visit[next]) {
                        visit[next] = true;
                        queue.add(next);
                        maxArr[next]++;
                    }
                }
            }
        }
        for (int v : maxArr) {
            max = Math.max(max, v);
        }

        for (int i = 1; i <= n; i++) {
            if (max == maxArr[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }


}

