import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, weight;

        Node(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        long dist[] = new long[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<Node> list = new ArrayList<>(e + 1);


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        dist[1] = 0;

        for (int i = 0; i < v - 1; i++) {
            boolean update = false;
            for (Node node : list) {
                if (dist[node.from] != Integer.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight) {
                    dist[node.to] = dist[node.from] + node.weight;
                    update = true;
                }
            }
            // 더 이상 할 필요 없다
            if (!update)
                break;
        }

        for (Node node : list) {
            if (dist[node.from] != Integer.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                sb.append("-1\n");
            else sb.append(dist[i]).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();


    }


}
