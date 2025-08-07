import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dfs(0, new int[k],1);
        System.out.println(sb);
    }

    static void dfs(int depth, int arr[], int preNum) {
        if (depth ==k){
            for(int a : arr){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = preNum; i<=n; i++){
            arr[depth] = i;
            dfs(depth+1, arr, i);
        }
    }


}


