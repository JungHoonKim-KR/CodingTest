import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<int[]> balloons = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            balloons.add(new int[]{i + 1, Integer.parseInt(inputs[i])});
        }

        List<Integer> result = burstBalloons(balloons);
        for (int num : result) {
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> burstBalloons(List<int[]> balloons) {
        List<Integer> results = new ArrayList<>();
        int index = 0;

        while (!balloons.isEmpty()) {
            int[] current = balloons.remove(index);
            results.add(current[0]);

            if (balloons.isEmpty()) {
                break;
            }

            int move = current[1];
            if (move > 0) {
                index = (index + move - 1) % balloons.size();
            } else {
                index = (index + move) % balloons.size();
                if (index < 0) {
                    index += balloons.size();
                }
            }
        }

        return results;
    }
}
