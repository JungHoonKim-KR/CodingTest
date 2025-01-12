import java.io.*;
import java.util.*;

public class Main {
    static long a=0;
    static long c=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
         a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());
        long result = modular(b);
        System.out.println(result);

    }

    static long modular(long n){
        // a*b%c == (a%c * b%c) %c
        // 그럼 a와 b를 계속 찢는다. a의 지수가 1이 될 때 까지

        if(n==1){
            return a %c;
        }
        // 이 때 지수기 홀수라면 1은 빼고 분할한다.
        long temp = modular(n/2);
        //그리고 다시 1만큼을 더 곱해준다.
        if(n %2 == 1){
            //temp에 %c를 안하는 이유는 최소 단위인 n==1에서 a%c로 처리하기 때문에 이미 반영이 된 상태임
            return (temp * temp % c) * a %c;
        }
        else return (temp * temp) %c;
    }

}