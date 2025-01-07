import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        boolean visit[] = new boolean[n+1];
        queue.add(new int[]{n, 0});
        while(true){
            int[] count = queue.poll();
            if(count[0] == 1){
                bw.write(count[1] + "\n");
                break;
            }

            if(count[0] % 3 ==0 && !visit[count[0]/3]){
                queue.add(new int[]{count[0]/3, count[1]+1});
                visit[count[0]/3] = true;
            }
            if(count[0] % 2 == 0 && !visit[count[0]/2]){
                queue.add(new int[]{count[0]/2, count[1]+1});
                visit[count[0]/2] = true;

            }
            if(!visit[count[0]-1]){
                queue.add(new int[]{count[0] -1, count[1]+1});
                visit[count[0]-1] = true;
            }

        }
        bw.flush();
    }

}
