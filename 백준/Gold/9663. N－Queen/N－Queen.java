import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {
    static int N;
    static int count;
    static int arr[];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제 받기
        N = Integer.parseInt(br.readLine());
        count = 0;
        //nxn의 boolean 배열을 만든다
        arr = new int[N];
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i; // arr안에 우선 값을 넣은 후에 비교를 해야 비교가 된다.(그래야 if문에서 넣어본 자리가 맞는 자리인지 비교할 수 있다. 만약 안넣는다면 초기값은 무조건 0이기 때문에 i가 N까지 돌 때까지 0번 열만 비교할 것이다.)
            if (proof(depth)) {//true일때 즉 놓을 수 있는 자리일때
                dfs(depth + 1);
            }
        }
    }

    public static boolean proof(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth])
                return false;

            if (Math.abs(depth - i) == Math.abs(arr[depth] - (arr[i])))
                return false;
        }
        return true;
    }


}

























