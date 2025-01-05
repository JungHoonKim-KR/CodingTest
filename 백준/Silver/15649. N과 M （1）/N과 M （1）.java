import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean boolArr [] = new boolean[n+1];
        int arr [] = new int[m];
        dfs(boolArr, arr, 0, n, m);
        br.close();
        bw.close();
    }

    static void dfs(boolean boolArr[], int arr[], int depth, int n, int m){
        if(depth == m){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }

        for(int i =1; i<=n; i++){
            if(!boolArr[i]){
                boolArr[i] = true;
                arr[depth] = i;
                dfs(boolArr, arr, depth+1, n, m);
                boolArr[i] = false;
            }
        }
    }

}
