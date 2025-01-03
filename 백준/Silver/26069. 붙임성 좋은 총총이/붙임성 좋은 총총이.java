import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // chongchong이 시작점
        int n  = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<String> set = new HashSet<>(Set.of("ChongChong"));
        for(int i =0; i<n; i++){
            // chongchong과 만나는 모든 사람은 감염
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            // 만난 사람을 배열에 저장
            if(set.contains(s1)){
                set.add(s2);
            }
            else if(set.contains(s2)){
                set.add(s1);
            }
        }
        // 결과는 set.size()
        bw.write(set.size()+"");
        bw.flush();
    }


}


