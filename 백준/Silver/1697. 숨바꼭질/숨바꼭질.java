import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 100000;
        int arr[] = new int[max+1];
        boolean visit[] = new boolean[max+1];
        Queue<Integer>queue = new LinkedList<>();
        queue.add(n);
        visit[n] = true;
        while(!queue.isEmpty()){
            //방문
            Integer cur = queue.poll();
            if(cur == k){
                break;
            }
            if(cur-1>=0 && !visit[cur-1]){
                // go -1
                queue.add(cur-1);
                arr[cur-1] = arr[cur]+1;
                visit[cur-1] = true;
            }
            if(cur+1<=max && !visit[cur+1]){
                queue.add(cur+1);
                arr[cur+1] = arr[cur]+1;
                visit[cur+1] = true;
            }
            if(cur * 2 <=max && !visit[cur*2]){
                queue.add(cur*2);
                arr[cur*2] = arr[cur]+1;
                visit[cur*2] = true;
            }
        }
        System.out.println(arr[k]);


    }





}
