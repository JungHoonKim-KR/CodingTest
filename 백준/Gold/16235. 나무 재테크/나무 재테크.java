import java.io.*;
import java.util.*;

/*
 1. 입력으로 각 좌표의 양분이 주어진다
 2. 그 다음 나무의 좌표와 나이가 주어진다.
 봄 : 나무의 나이만큼 나무 위치의 양분을 먹고 나이가 1 증가한다. 어린 나무부터 양분을 먹는다. 먹지 못하면 그 나무는 죽는다.
 여름 : 죽는 나무의 나이 /2 값이 해당 좌표의 양분으로 볍한다.
 가을 : 나무 좌표 기준 8방으로 나이가 1인 나무를 추가한다. 이 때 나무의 나이가 5배수여야 한다.
 겨울 : 땅에 영분을 추가한다
 */
public class Main {
    static int n, m, k, result;
    static int input[][];
    static int foods[][];
    static int trees[][];
    static int go[][] = {{1, 0}, {1, -1}, {1, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}};
    static PriorityQueue<Integer>[][] treeList;
    static Queue<int[]> deadTrees = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        input = new int[n][n];
        foods = new int[n][n];
        treeList = new PriorityQueue[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                treeList[i][j] = new PriorityQueue<>();
                foods[i][j] = 5;
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        trees = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            treeList[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()));
        }

        while (k-- > 0) {
            spring();
            summer();
            autumn();
            winter();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += treeList[i][j].size();
            }
        }
        System.out.println(result);
    }

    static void spring() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!treeList[i][j].isEmpty()) {
                    int count = treeList[i][j].size();
                    List<Integer> safeTrees = new ArrayList<>();
                    while (count-- > 0) {
                        int treeOld = treeList[i][j].poll();
                        if (treeOld <= foods[i][j]) {
                            safeTrees.add(treeOld + 1);
                            foods[i][j] -= treeOld;
                        } else {
                            deadTrees.add(new int[]{i, j, treeOld});
                        }
                    }
                    if (!safeTrees.isEmpty())
                        treeList[i][j].addAll(safeTrees);
                }
            }
        }
    }

    static void summer() {
        while (!deadTrees.isEmpty()) {
            int cur[] = deadTrees.poll();
            foods[cur[0]][cur[1]] += cur[2] / 2;
        }
    }

    static void autumn() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    int moveX = i + go[k][0];
                    int moveY = j + go[k][1];
                    if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n)
                        continue;
                    for(int treeOld : treeList[i][j]){
                        if(treeOld %5 == 0){
                            treeList[moveX][moveY].add(1);
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                foods[i][j] += input[i][j];
            }
        }
    }
}
