import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int A[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int P[] = A.clone();
        Arrays.sort(P);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j<n; j++){
                if(A[i] == P[j]){
                    sb.append(j).append(" ");
                    // 중복 값이 있을 경우 사전순으로 순번을 정해야 하기 때문에 한 번 썼으면 없애야 한다
                    P[j] = -1; 
                    break;
                }
            }
        }
        System.out.println(sb);

    }


}