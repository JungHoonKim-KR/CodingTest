import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 100000;
        boolean visit[] = new boolean[INF+1];
        int arr[] = new int[INF+1];
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == end){
                System.out.println(arr[end]);
                return;
            }

            if(2*cur<=INF && !visit[cur*2]){
                q.add(cur *2);
                visit[cur*2] = true;
                arr[cur*2] = arr[cur];
            }
            if(cur !=0 && !visit[cur-1]){
                q.add(cur-1);
                visit[cur-1] = true;
                arr[cur-1] = arr[cur]+1;
            }
            if(cur != INF && !visit[cur+1]){
                q.add(cur+1);
                visit[cur+1] = true;
                arr[cur+1] = arr[cur]+1;
            }
        }


    }



}
