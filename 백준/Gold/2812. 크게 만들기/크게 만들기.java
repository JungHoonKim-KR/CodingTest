import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer>queue = new ArrayDeque<>();

        int arr[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i<n; i++){
            int cur = arr[i];

            while(k >0 && !queue.isEmpty() && queue.peekLast() < cur){
                k--;
                queue.removeLast();
            }

            queue.addLast(cur);


        }

        if(k >0){
            for(int i = 0; i<k; i++){
                queue.removeLast();
            }
        }
        while(!queue.isEmpty()){
            sb.append(queue.removeFirst());
        }
        System.out.println(sb);


    }
}
