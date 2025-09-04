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
    static Hack[][] hackMap = new Hack[4001][4001];

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
//            System.out.println("#" + t + " " + result);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }

    static void run() {
        // 이동
        while (!hackList.isEmpty()) {
            for (int i = hackList.size() - 1; i >= 0; i--) {
                Hack hack = hackList.get(i);
                // 이전 턴에서 핵분열이 안된 핵 없애기
                hackMap[hack.y][hack.x] = null;
                if(hack.power == 0){
                    hackList.remove(i);
                    continue;
                }

                // 이동
                hack.y += go[hack.dir][0];
                hack.x += go[hack.dir][1];

                // 범위 벗어나면 제거
                if (hack.y < 0 || hack.y > 4000 || hack.x < 0 || hack.x > 4000) {
                    hackList.remove(i);
                    continue;
                }

                // 비어있으면 넣기
                if (hackMap[hack.y][hack.x] == null) {
                    hackMap[hack.y][hack.x] = hack;
                } else {
                    Hack lastHack = hackMap[hack.y][hack.x];
                    result += lastHack.power + hack.power;
                    lastHack.power = 0;
                    hackList.remove(hack);
                }
            }
        }
    }


}