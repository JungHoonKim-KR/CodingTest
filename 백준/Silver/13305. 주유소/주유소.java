import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도로와 도시를 받는데, 마지막 도시는 의미 없음
        int n = Integer.parseInt(br.readLine()) - 1;
        int road[] = new int[n];
        int city[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int minCost = city[0];

        long result=0;
        for(int i=0; i<n; i++){
            result += (long)minCost * road[i];
            if(i+1 < n && minCost > city[i+1]){
                minCost = city[i+1];
            }
        }
        System.out.println(result);
    }

}