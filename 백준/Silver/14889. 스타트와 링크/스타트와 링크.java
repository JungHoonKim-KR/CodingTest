import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int n;
    static int result=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         n = Integer.parseInt(br.readLine());
        arr = new int [n][n];
        for(int i = 0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[] booleans = new boolean[arr.length];
        booleans[0] = true;
        dfs(1, booleans, 1);

        bw.write(result+"");
        bw.flush();
    }
    static void dfs(int depth, boolean visited[], int index){
        if(depth == n/2){
            int sum1 =0,sum2=0;
            for(int i=0; i<n-1; i++){
                for(int j = i+1; j<n; j++){
                    //team1
                    if(visited[i] && visited[j]){
                        sum1 += arr[i][j] + arr[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        sum2 += arr[i][j] + arr[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(sum1 - sum2));
            return;
        }

        for(int i=index; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, visited, i+1);
                visited[i] = false;
            }
        }
    }

}