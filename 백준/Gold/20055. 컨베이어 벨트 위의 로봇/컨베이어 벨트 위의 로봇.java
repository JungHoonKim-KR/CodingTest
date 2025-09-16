import java.util.*;
import java.io.*;

/*
벨트 이동(로봇은 자동으로 한 칸씩 이동됨)
로봇 이동
로봇 올리기(만약 로봇 이동 후 1번자리에 로봇이 없으면 새 로봇으로 채우기)
 */


public class Main {
    static int N, K, time;
    // 수명
    static ArrayList<Integer> durability = new ArrayList<>();
    static ArrayList<Boolean> isRobot = new ArrayList<>();
    static int startIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*N; i++) {
            durability.add(Integer.parseInt(st.nextToken()));
            isRobot.add(false);
        }
        run();
    }

    static void run() {
        // 벨트 이동
        while(K>0){
            time ++;
            moveBelt();
            moveRobot();
        }
        System.out.println(time);

    }

    static void moveBelt(){
        startIdx = (startIdx -1 +2*N) % (2*N);

        // 로봇이 내리는 위치에 도착했으면 내리기
        int downIdx = (startIdx + N-1) % (2*N);
        if(isRobot.get(downIdx)){
            isRobot.set(downIdx,false);
        }
    }

    static void moveRobot(){

        for(int i = N-2; i >= 0; i--) {
            int curIdx = (startIdx + i) % (2*N);
            int nextIdx = (curIdx+1) % (2*N);
            if(isRobot.get(curIdx) && !isRobot.get(nextIdx) && durability.get(nextIdx) >=1) {
                isRobot.set(curIdx, false);
                isRobot.set(nextIdx, true);

                int durable = durability.get(nextIdx)-1;
                durability.set(nextIdx, durable);
                if(durable ==0){
                    K--;
                }
            }

        }
        int downIdx = (startIdx + N-1) % (2*N);
        if(isRobot.get(downIdx)){
            isRobot.set(downIdx, false);
        }
        if(!isRobot.get(startIdx) && durability.get(startIdx) >=1){
            int durable = durability.get(startIdx)-1;
            durability.set(startIdx, durable);
            isRobot.set(startIdx, true);
            if(durable == 0){
                K--;
            }

        }
    }


}