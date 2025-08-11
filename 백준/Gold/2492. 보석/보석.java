import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t, k;
    static List<int[]> v;

    // 정사각형 내의 금강석 개수를 세는 함수
    static int f(int x, int y) {
        int count = 0;
        for (int[] point : v) {
            // x, y를 왼쪽 아래 꼭짓점으로 가정
            if (point[0] >= x && point[0] <= x + k && point[1] >= y && point[1] <= y + k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 가로 길이
        m = Integer.parseInt(st.nextToken()); // 세로 길이
        t = Integer.parseInt(st.nextToken()); // 금강석 개수
        k = Integer.parseInt(st.nextToken()); // 정사각형 한 변의 길이

        v = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            v.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int maxCount = 0;
        int bestX = 0, bestY = 0;

        // 모든 금강석의 x, y 좌표를 조합하여 정사각형의 왼쪽 아래 꼭짓점 후보를 탐색
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                int xx, yy;

                // 금강석 i의 x 좌표를 정사각형의 왼쪽 변으로 설정
                // 지도를 벗어나지 않도록 조정
                if (v.get(i)[0] + k > n) {
                    xx = n - k;
                } else {
                    xx = v.get(i)[0];
                }

                // 금강석 j의 y 좌표를 정사각형의 아래 변으로 설정
                // 지도를 벗어나지 않도록 조정
                if (v.get(j)[1] + k > m) {
                    yy = m - k;
                } else {
                    yy = v.get(j)[1];
                }

                // 현재 정사각형 내의 금강석 개수를 세고 최댓값 갱신
                int currentCount = f(xx, yy);
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                    bestX = xx;
                    bestY = yy + k; // 문제 출력 형식에 맞게 왼쪽 위 y 좌표로 저장
                }
            }
        }

        // 최적의 정사각형의 왼쪽 위 꼭짓점 좌표와 최대 금강석 개수 출력
        System.out.println(bestX + " " + bestY);
        System.out.println(maxCount);
    }
}