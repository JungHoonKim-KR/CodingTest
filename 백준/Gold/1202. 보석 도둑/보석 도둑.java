import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][]jewelry = new int[n][2];
        int[]backpack = new int[k];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken());
            jewelry[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++){
            backpack[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(jewelry, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        Arrays.sort(backpack);

        int index=0;
        long result=0;
        for(int bag : backpack){
            while(index < n && jewelry[index][0] <= bag){
                queue.add(jewelry[index][1]);
                index++;
            }
            if(!queue.isEmpty()){
                result += queue.poll();
            }
        }
        System.out.println(result);


    }
}