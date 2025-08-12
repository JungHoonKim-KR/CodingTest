import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            Queue<int[]>queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int value = Integer.parseInt(st.nextToken());
                list.add(value);
                queue.add(new int[]{i,value});
            }
            Collections.sort(list, Comparator.reverseOrder());
            int count = 1;
            outer:for(int i = 0; i < n; i++){
                int curP = list.get(i);
                while(true){
                    int cur[] = queue.poll();

                    if(cur[1] == curP){
                        if(cur[0] == target){
                            break outer;
                        }
                        count++;
                        break;
                    }
                    else{
                        queue.add(cur);
                    }
                }
            }
            System.out.println(count);

        }


    }

}

