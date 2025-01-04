import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        divide(n, 1, 3 ,2);
        bw.write((int)Math.pow(2,n)-1+"\n");
        bw.write(sb.toString());
        bw.flush();
        br.close();  // 입력 스트림 닫기
        bw.close();  // 출력 스트림 닫기

    }

    static void divide(int n, int from, int to, int other) {
        // n을 옮기기 위해 거쳐가는 구간
        if(n == 0) return ;
        divide(n-1, from, other, to);

        sb.append(from + " "+ to+"\n");

        // n을 목적지로 옮김
        divide(n-1, other, to, from);

    }


}


