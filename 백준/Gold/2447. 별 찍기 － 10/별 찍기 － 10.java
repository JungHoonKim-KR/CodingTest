import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static StringBuilder sb[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder[n];

        for(int i =0; i<n; i++){
            sb[i] = new StringBuilder();
        }
        divide(n, 0, 0);
        for(int i =0; i<n; i++){
            bw.write(sb[i].toString()+"\n");
        }
        bw.flush();
        br.close();  // 입력 스트림 닫기
        bw.close();  // 출력 스트림 닫기

    }

    static void divide(int n, int y, int x) {
        if(n == 1){
            sb[y].append("*");
            return;
        }

        int term = n / 3;
        // term 기준에 걸리면 빈 칸 추가 그 이외의 범위는 divide 호출
        for (int i = y; i < y+n; i += term) {
            for (int j = x; j < x+n; j += term) {
                if(i == y + term && j == x + term){
                    for(int k = i; k< i+term; k++){
                        for(int l = j; l<j+term; l++){
                            sb[k].append(" ");
                        }
                    }
                }
                else{
                    divide(term, i, j);
                }
            }
        }

    }


}


