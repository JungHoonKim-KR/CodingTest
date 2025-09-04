import java.io.*;
import java.util.*;

/*
1. 접수창구 배열
 할당 시간

2. 정비창구 배열
 할당 시간

3. 사람 배열
 접수창구, 정비창구

시간은 전역 변수로 흐른다.
접수 대기 Queue, 정비 대기 Queue
각 time 마다 Queue를 확인하고 각 창구가 비어있고 Queue에 사람이 있으면 할당한다

for문 돌아서 각 사람이 들어간 창구 번호와 내가 찾는 번호가 일치하면 답에 추가
 */
class Human{
    int registerNum, repairNum;

    Human(int registerNum, int repairNum){
        this.registerNum = registerNum;
        this.repairNum = repairNum;
    }
}

class StartHuman{
    int no, startTime;
    StartHuman(int no, int startTime){
        this.no = no;
        this.startTime = startTime;
    }
}

class Register{
    int finishTime, time, guestNumber;
    boolean isEmpty;
    Register(int time){
        this.finishTime = Integer.MAX_VALUE;
        this.time = time;
        isEmpty = true;
    }
}

class Repair{
    int finishTime, time;
    boolean isEmpty;
    Repair(int time){
        this.finishTime = Integer.MAX_VALUE;
        this.time = time;
        isEmpty = true;
    }
}

class RepairReady{
    int guestNumber, finishTime, registerNumber;
    RepairReady(int guestNumber, int finishTime, int registerNumber){
        this.guestNumber = guestNumber;
        this.finishTime = finishTime;
        this.registerNumber = registerNumber;
    }
}
public class Solution {
    static int N, M, K ,A ,B;
    static Register[] registerArr;
    static Repair[] repairArr;
    static Human[] humanArr;
    static int registerCount, repairCount;
    static Queue<StartHuman> readyQueue;
    static Queue<Integer> registerQueue;
    static Queue<RepairReady> repairQueue;
    static int TotalTime, finishCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            init();

            st =  new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                registerArr[i] = new Register(Integer.parseInt(st.nextToken()));
            }
            st =  new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                repairArr[i] = new Repair(Integer.parseInt(st.nextToken()));
            }
            st =  new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                readyQueue.add(new StartHuman(i, Integer.parseInt(st.nextToken())));
            }
            run();
            int result = 0;

            for(int i = 1; i<=K; i++){
                Human h = humanArr[i];
                if(h.registerNum == A && h.repairNum == B){
                    result += i;
                }
            }

            sb.append("#").append(tc).append(" ")
                    .append(result == 0? -1 : result).append("\n");

        }
        System.out.println(sb);
    }

    static void run(){
        while (finishCount != K) {
            clear();
            add();
            TotalTime++;
        }
    }

    static void clear(){
        // 정비소 비우기
        for(int i = 1 ;i<=M; i++){
            Repair repair = repairArr[i ];
            // 할당된 손님 제거
            if(TotalTime == repair.finishTime){
                repair.isEmpty = true;
                finishCount++;
            }
        }
        // 접수 비우기
        for(int i = 1 ;i<=N; i++){
            Register register = registerArr[i];
            if(TotalTime == register.finishTime){
                register.isEmpty = true;

                //정비대기 시켜야함
                repairQueue.add(new RepairReady(register.guestNumber, TotalTime,i));
                register.guestNumber = 0;
            }
        }
        // 레디 비우기
        while(!readyQueue.isEmpty() && readyQueue.peek().startTime == TotalTime){
            registerQueue.add(readyQueue.poll().no);

        }
    }

    static void add(){
        // 접수 시작
        for(int i = 1 ;i<=N; i++){
            Register register = registerArr[i];
            if(register.isEmpty && !registerQueue.isEmpty()){
                int humanNumber = registerQueue.poll();
                humanArr[humanNumber].registerNum = i;
                register.guestNumber = humanNumber;
                register.isEmpty = false;
                register.finishTime = TotalTime + register.time;
            }
        }

        // 정비 시작
        for(int i = 1 ;i<=M; i++){
            Repair repair = repairArr[i];
            if(repair.isEmpty && !repairQueue.isEmpty()){
                int humanNumber = repairQueue.poll().guestNumber;
                humanArr[humanNumber].repairNum = i;
                repair.isEmpty = false;
                repair.finishTime = TotalTime + repair.time;
            }
        }
    }

    private static void init() {
        TotalTime = 0;
        registerArr = new Register[N+1];
        repairArr = new Repair[M+1];
        humanArr = new Human[K+1];
        registerCount = 0;
        repairCount = 0;
        finishCount = 0;
        readyQueue = new ArrayDeque<>();
        registerQueue = new PriorityQueue<>();
        repairQueue = new PriorityQueue<>((r1, r2)->{
            if(r1.finishTime == r2.finishTime){
                return Integer.compare(r1.registerNumber, r2.registerNumber);
            }
            return  Integer.compare(r1.finishTime, r2.finishTime);
        });
        for(int i = 1 ;i<=K; i++){
            humanArr[i] = new Human(0,0);
        }
    }
}







