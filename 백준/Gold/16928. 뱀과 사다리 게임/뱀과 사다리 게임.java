import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int map[] = new int[101];
        boolean visit[] = new boolean[101];
        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<Integer, Integer> snakeMap = new HashMap<>();
        for(int i =0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            ladderMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i =0; i<s; i++){
            st = new StringTokenizer(br.readLine());
            snakeMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Integer>queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            for(int i =1; i<=6; i++){
                int next = poll+i;
                if (next>100) continue;
                if(visit[next])continue;

                if(ladderMap.containsKey(next)){
                    next = ladderMap.get(next);
                }
                else if(snakeMap.containsKey(next)){
                    next = snakeMap.get(next);
                }

                if(!visit[next]){
                    map[next] = map[poll] +1;
                    visit[next] = true;
                    queue.add(next);
                    // 사다리가 100으로 이동하는 것을 고려해야하기 때문에 마지막에 체크
                    if(next ==100) {
                        System.out.println(map[next]);
                        return;
                    }
                }

            }

        }



    }
}
