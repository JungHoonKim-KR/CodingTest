import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!Objects.equals(line = br.readLine(), null)){
            int n = Integer.parseInt(line);

            if (n == 0){
                bw.write("-"+"\n");
            }
            else{

                int N = (int)Math.pow(3, n);
                sb = new StringBuilder();

                divide(0, N-1);

                bw.write(sb.toString()+"\n");
            }
        }


        bw.flush();
        br.close();  // 입력 스트림 닫기
        bw.close();  // 출력 스트림 닫기

    }

    static void divide(int left, int right){
        if((right - left) == 0){
            //append
            sb.append("-");
            return;
        }
        int term = (right-left+1)/3;
        int midStart = left + term;
        int midEnd = midStart + term -1;

        //1
        divide(left, midStart-1);
        // 2 공백 추가
        for(int i =midStart; i<midEnd+1; i++){
            sb.append(" ");
        }
        // 3
        divide(midEnd+1, right);
    }


}


