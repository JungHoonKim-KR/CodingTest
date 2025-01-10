import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        // 0 : 무게, 1 : 가치
        int item[][] = new int[n][2];
        int knapback[][] = new int[n][w+1];
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            item[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }

        // 0~n-1번 아이템까지 총 배낭 무게에 맞게 검사
        // 물건
        for(int i =0; i<n; i++){
            // 배낭 수용량
            for(int weight=1; weight<=w; weight++){
                if(item[i][0] <= weight){
                    // 첫 물건일 때
                    if(i==0){
                        knapback[i][weight] = item[i][1];
                    }
                    else{
                        knapback[i][weight] = Math.max(knapback[i-1][weight], knapback[i-1][weight - item[i][0]] + item[i][1]);
                    }
                }
                else if(i!=0)knapback[i][weight] = knapback[i-1][weight];
            }
        }
        System.out.println(knapback[n-1][w]);
    }
}