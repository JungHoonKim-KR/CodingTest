import java.io.*;
import java.util.*;

public class Main {
    static int zero=0;
    static int one=0;
    static int minusOne=0;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int [n][n];

        for(int i =0; i<n; i++){
            arr[i] =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        rectangular(0,0,n);
        System.out.println(minusOne+"\n"+zero+"\n"+one);
    }

    static void rectangular(int startX, int startY, int n){
        int kind = arr[startX][startY];
        if(n==1){
            if(kind ==-1)minusOne++;
            else if(kind ==0) zero++;
            else one++;
            return;
        }
        //9개로 쪼갬
        for(int i = startX; i<startX+n;i++){
            for(int j = startY; j<startY+n;j++){
                if(arr[i][j] != kind){
                    rectangular(startX, startY, n/3);
                    rectangular(startX, startY + n/3, n/3);
                    rectangular(startX, startY + n*2/3, n/3);
                    rectangular(startX +n/3, startY, n/3);
                    rectangular(startX +n/3, startY + n/3, n/3);
                    rectangular(startX +n/3, startY + 2*n/3, n/3);
                    rectangular(startX + 2*n/3, startY, n/3);
                    rectangular(startX + 2*n/3, startY +n/3, n/3);
                    rectangular(startX + 2*n/3, startY + 2*n/3, n/3);
                    return;
                }
            }
        }
        // 다 같으면 counting
        if(kind ==-1)minusOne++;
        else if(kind ==0) zero++;
        else one++;
    }

}