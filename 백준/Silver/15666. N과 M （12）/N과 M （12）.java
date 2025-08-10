import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int input[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        dfs(0,0,new int[s]);
        System.out.println(sb);
    }

    static void dfs(int depth, int start,  int arr[]){
        if(depth == s){
            for(int i = 0; i < s; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = start; i<n; i++){
            if(prev != input[i] ){
                prev = input[i];
                arr[depth] = input[i];
                dfs(depth+1, i,  arr);
            }
        }



    }


}

