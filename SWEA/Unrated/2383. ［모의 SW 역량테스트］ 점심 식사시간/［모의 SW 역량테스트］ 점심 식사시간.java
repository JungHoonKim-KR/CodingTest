import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
 모든 사람이 아래층으로 가야함
 1. 계단 까지 이동
 2. 계단은 2개 이고 계단 마다 길이가 다름.
 3. 계단에 도착하면 다음 Time에 계단을 이용할 수 있음.(비활성화/활성화)
 4. 계단에서 인원체크 후 3명 이동 관리 (Queue 사용, 계단 까지의 이동 거리를 도착시간으로 한 뒤 우선순위 큐?)
 5. 이후 계단의 길이 만큼 더해주면 해당 사람의 이동 완료

 */
public class Solution {
    static int N, MIN;
    static int[][] map;
    static List<int[]> humanPos;
    static List<int[]> stairPos;
    static List<int[]> distances;
    static List<Integer> groupA; // 몇 번 사람인지만 알면 됨
    static List<Integer> groupB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            MIN = Integer.MAX_VALUE;
            map = new int[N][N];
            humanPos = new ArrayList<>();
            stairPos = new ArrayList<>();
            groupA = new ArrayList<>();
            groupB = new ArrayList<>();
            distances = new ArrayList<>();
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    int input =  Integer.parseInt(st.nextToken());
                    if(input == 1){
                        humanPos.add(new int[]{i,j});
                    }
                    else if(input >=2){
                        stairPos.add(new int[]{i,j, input});
                    }
                }
            }

            for(int i = 0; i<humanPos.size(); i++){
                int hx = humanPos.get(i)[0];
                int hy = humanPos.get(i)[1];
                int temp[] = new int[2];
                for(int j = 0; j<2; j++){
                    int sX = stairPos.get(j)[0];
                    int sY = stairPos.get(j)[1];
                    temp[j] = Math.abs(sX-hx)+Math.abs(sY-hy);
                }
                distances.add(temp);
            }
            subset(0);
             sb.append("#").append(tc).append(" ").append(MIN).append("\n");
        }
        System.out.print(sb);
    }
    static void subset(int depth){
        if(depth == humanPos.size()){
            //시뮬레이션

            int A = simulate(groupA, 0);
            int B = simulate(groupB, 1);

            MIN = Math.min(MIN, Math.max(A,B));
            return;
        }
        // A
        groupA.add(depth);
        subset(depth+1);
        groupA.remove(groupA.size()-1);

        //B
        groupB.add(depth);
        subset(depth+1);
        groupB.remove(groupB.size()-1);

    }

    /*
     groupType : distance[groupType](A계단 or B계단 선택 인덱스
     */
    static int simulate(List<Integer> group, int groupType){
        if(group.isEmpty()){
            return 0;
        }
        int k = stairPos.get(groupType)[2];
        // pq로 시간별 정렬
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int humanIndex : group){
            pq.add(distances.get(humanIndex)[groupType]);
        }

        int[] userFinishTimes = new int[3];
        // init
        for(int i = 0; i<3; i++){
            if(pq.isEmpty())
                break;

            userFinishTimes[i] = pq.poll() +1 + k;
        }
        while(!pq.isEmpty()){
            int arriveTime = pq.poll();
            Arrays.sort(userFinishTimes);

            int startTime = Math.max(arriveTime+1, userFinishTimes[0]);
            userFinishTimes[0] = startTime + k;
        }
        Arrays.sort(userFinishTimes);
        return userFinishTimes[2];
    }

}