import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((n + 1) / 2).append("\n"); // 중앙값 개수 출력

            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            int count = 0; // 전체 수열에서 몇 번째 수인지
            int outputCount = 0; // 한 줄에 10개씩 출력 제어용

            int totalLines = (n + 9) / 10; // ceil(n / 10)
            for (int i = 0; i < totalLines; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int num : input) {
                    count++;
                    q.add(num);

                    if (count % 2 == 1) { // 홀수 번째일 때만 중앙값 출력
                        ArrayList<Integer> temp = new ArrayList<>();
                        int midIdx = q.size() / 2;
                        for (int k = 0; k < midIdx; k++) {
                            temp.add(q.poll());
                        }

                        int median = q.peek(); // 중앙값 확인
                        sb.append(median).append(" ");
                        outputCount++;

                        if (outputCount % 10 == 0) sb.append("\n");

                        // 복원
                        q.addAll(temp);
                    }

                    if (count == n) break;
                }
            }
            if (outputCount % 10 != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
