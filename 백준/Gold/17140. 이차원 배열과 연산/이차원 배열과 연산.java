import java.io.*;
import java.util.*;

class Node {
    int value, count;

    Node(int v, int c) {
        value = v;
        count = c;
    }
}

public class Main {
    static int r = 3, c = 3;
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        for (time = 0; time <= 100; time++) {
            if (arr[targetR][targetC] == k) {
                break;
            }

            if (r >= c) {
                operation();
            } else {
                transpose();
                operation();
                transpose();
            }

        }
        System.out.println(time == 101 ? -1 : time);
    }

    static void operation() {
        int maxLen = 0;
        for (int i = 1; i <=r; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= c; j++) {
                int value = arr[i][j];
                if(value == 0)
                    continue;
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
                if (n1.count == n2.count) {
                    return n1.value - n2.value;
                }
                return n1.count - n2.count;
            });

            for (int key : map.keySet()) {
                pq.add(new Node(key, map.get(key)));
            }

            int index = 1;


            while (!pq.isEmpty()) {
                if (index > 100)
                    break;
                Node node = pq.poll();
                arr[i][index++] = node.value;
                arr[i][index++] = node.count;

            }
            maxLen = Math.max(maxLen, index-1);
            while(index <= 100){
                arr[i][index++] = 0;
            }
        }
        c = maxLen;
    }

    static void transpose() {
        int temp[][] = new int[101][101];

        for(int i = 1; i <=100; i++ ){
            for(int j = 1; j <=100; j++){
                temp[i][j] = arr[j][i];
            }
        }

        arr = temp;
        int tempLen = c;
        c = r;
        r = tempLen;
    }
}
