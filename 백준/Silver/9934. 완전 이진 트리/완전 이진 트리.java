import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb =new StringBuilder();
    static int arr[];
    static int n;
    static ArrayList<Integer>list[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        dfs(0, 0, arr.length-1);
        for(int i = 0; i<n; i++){
            for(int r : list[i]){
                sb.append(r+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int depth, int start, int end){
        if(depth == n-1){
            list[depth].add(arr[start]);
            return;
        }

        int mid = (start+end)/2;
        list[depth].add(arr[mid]);
        dfs(depth+1, start, mid-1);
        dfs(depth+1, mid+1, end);
    }


}


