import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            boolean visit[] = new boolean[n + 1];
            ArrayList<Integer> graph[] = new ArrayList[n + 1];
            testCase++;
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph[first].add(second);
                graph[second].add(first);
            }

            Queue<int[]> q = new LinkedList<>();
            // 시작 노드 선정


            for (int start = 1; start <= n; start++) {
                boolean isCycle = false, isRun = false;

                if (!visit[start]) {
                    isRun = true;
                    q.add(new int[]{start, start});
                    visit[start] = true;
                    while (!q.isEmpty()) {
                        int cur[] = q.poll();

                        for (int next : graph[cur[0]]) {
                            if (!visit[next]) {
                                visit[next] = true;
                                q.add(new int[]{next, cur[0]});
                            } else if (next != cur[1])
                                isCycle = true;
                        }
                    }
                }
                if (isRun && !isCycle)
                    count++;
            }

            result(sb, testCase, count);
        }
        System.out.println(sb);

    }

    static void result(StringBuilder sb, int tc, int count) {
        sb.append("Case " + tc + ": ");

        if (count == 0) {
            sb.append("No trees.\n");
        } else if (count == 1) {
            sb.append("There is one tree.\n");
        } else {
            sb.append("A forest of " + count + " trees.\n");
        }

    }

}
