import java.io.*;
import java.util.*;

public class Main {
    static char arr[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new char [n][n];

        for(int i =0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        rectangular(0,0,n);
        System.out.println(sb.toString());
    }

    static void rectangular(int startX, int startY, int n){
        char color = arr[startX][startY];
        if(n == 1){
            sb.append(color);
            return;
        }

        for(int i = startX; i<startX+n; i++){
            for(int j = startY; j<startY+n; j++){
                if(arr[i][j] != color){
                    // 네 부분으로 나뉨
                    sb.append("(");
                    rectangular(startX, startY, n/2);
                    rectangular(startX, startY + n/2, n/2);
                    rectangular(startX + n/2, startY, n/2);
                    rectangular(startX + n/2, startY + n/2, n/2);
                    sb.append(")");
                    return;
                }

            }
        }

        sb.append(color);
    }

}