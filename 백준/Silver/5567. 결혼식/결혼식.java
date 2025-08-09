import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count=0;
    static boolean visit[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visit[1] = true;
        for(int i : graph.get(1)) {
            if(!visit[i]) {
                visit[i] = true;
                count++;
            }
            for(int j : graph.get(i)) {
                if(!visit[j]) {
                    visit[j] = true;
                    count++;

                }
            }
        }
        System.out.println(count);

    }
}

