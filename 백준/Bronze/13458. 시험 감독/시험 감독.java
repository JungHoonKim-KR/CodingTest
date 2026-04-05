import java.io.*;
import java.util.*;



/*
시험장: N개
충감 : B
부감 : C

 */
public class Main {
    static int N;
    static int B, C;
    static int rooms[];
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // init
        N = Integer.parseInt(br.readLine());
        rooms = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        // 총감독 가능 수 만큼 제거
        mainLogic();
        // 부감독 계싼
        subLogic();

        System.out.println(result);
    }

    static void mainLogic(){
        for(int i = 0; i < N; i++){
            rooms[i] -= B;
            if(rooms[i] < 0){
                rooms[i] = 0;
            }
        }
        result += N;
    }

    static void subLogic(){
        for(int i = 0; i < N; i++){
            result += rooms[i] / C;

            if(rooms[i] % C != 0){
                result+=1;
            }
        }
    }







}
