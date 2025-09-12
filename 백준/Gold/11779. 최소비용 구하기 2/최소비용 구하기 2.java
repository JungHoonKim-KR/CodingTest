import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, start, end;
    static List<int[]> graph[];
    static int[] distances;
    static int[] prevNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 초기화
        graph = new ArrayList[N + 1];
        distances = new int[N + 1];
        prevNodes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distances[i] = Integer.MAX_VALUE;
        }

        // 입력
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        List<Integer> resultList = prevSearch();

        sb.append(distances[end]).append("\n");
        sb.append(resultList.size()).append("\n");

        for (int i = resultList.size() - 1; i >= 0; i--) {
            sb.append(resultList.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        distances[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (distances[cur[0]] < cur[1])
                continue;
            for (int[] next : graph[cur[0]]) {
                if (distances[next[0]] > distances[cur[0]] + next[1]) {
                    distances[next[0]] = distances[cur[0]] + next[1];
                    prevNodes[next[0]] = cur[0];
                    pq.add(new int[]{next[0], distances[cur[0]] + next[1]});
                }
            }
        }
    }

    static List<Integer> prevSearch() {
        int node = end;
        List<Integer> result = new ArrayList<>();

        while (node != start) {
            result.add(node);
            node = prevNodes[node];
        }
        result.add(start);
        return result;
    }


}