import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
해당 좌표가 큰 사각형 기준 몇 사분면에 속하는지 확인
한 사분면의 길이 : 2^N, 즉
 */
public class Main {
    static int N, X, Y,num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        // 2사분면
        int size =(int)Math.pow(2, N);

        run(size, X,Y);
        System.out.println(num);
    }

    static void run(int width, int startX, int startY){
        if(width == 1){
            return;
        }
        // 4등분
        int separation = width / 2;

        // 2사분면
        if(startX < separation && startY < separation){
            run(separation, startX, startY);
        }
        else if(startX < separation && startY >= separation){
            num += separation * separation;
            run(separation, startX, startY - separation);
        }
        else if(startX >= separation && startY < separation){
            num += separation * separation *2;
            run(separation, startX - separation, startY);
        }
        else if(startX >= separation && startY >= separation){
            num += separation * separation *3;
            run(separation, startX - separation, startY - separation);
        }

    }


}