import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int house [][] = new int [n][3];
        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        // 각 색깔 = 다른 색깔 들 중 최소값인 색 + 현재 색
        // house[1][0] += Math.min(house[i-1][1], house[i-1][2])

        for(int i =1; i<n; i++){
            house[i][0] +=  Math.min(house[i-1][1], house[i-1][2]);
            house[i][1] +=  Math.min(house[i-1][0], house[i-1][2]);
            house[i][2] +=  Math.min(house[i-1][0], house[i-1][1]);
        }

        int min = Integer.MAX_VALUE;
        for(int i =0; i<3; i++){
            min = Math.min(min, house[n-1][i]);
        }

        bw.write(min+"");
        bw.flush();
    }




}
