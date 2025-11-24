import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = {1,5,10,50};
    static int n;
    static Set<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dfs(0,0,0);
        System.out.println(set.size());


    }

    static void dfs(int depth, int start, int sum){
        if(depth == n){
            set.add(sum);
            return;
        }

        for(int i = start; i<4; i++){
            dfs(depth+1, i, sum + arr[i]);
        }
    }
}
