import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Hack {
    int x, y, dir, power;

    Hack(int x, int y, int dir, int power) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.power = power;
    }
}

public class Solution {
    static int[][] go = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int N, result;
    static List<Hack> hackList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            hackList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                hackList.add(new Hack((Integer.parseInt(st.nextToken()) + 1000) * 2, (Integer.parseInt(st.nextToken()) + 1000) * 2, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            run();
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }

    static void run() {
        // 이동
        while (!hackList.isEmpty()) {
            HashMap<Integer, ArrayList<Hack>> hackMap = new HashMap<>();
            for (Hack hack : hackList) {
                hack.y += go[hack.dir][0];
                hack.x += go[hack.dir][1];

                if (hack.x < 0 || hack.x >= 4001 || hack.y < 0 || hack.y >= 4001) {
                    continue;
                }
                int key = hack.x * 4001 + hack.y;
                hackMap.computeIfAbsent(key, k -> new ArrayList<>()).add(hack);

            }
            List<Hack> tempList = new LinkedList<>();
            for (List<Hack> hacks : hackMap.values()) {
                if (hacks.size() >= 2) {
                    for (Hack hack : hacks) {
                        result += hack.power;
                    }
                } else {
                    tempList.add(hacks.get(0));
                }
            }
            hackList = tempList;
        }
    }


}