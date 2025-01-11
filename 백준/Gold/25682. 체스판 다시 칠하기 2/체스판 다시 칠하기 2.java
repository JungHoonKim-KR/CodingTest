import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n+1][m+1];

        // 첫 칸이 검은색 기준
        for(int i = 1; i <= n; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j=1; j<=m; j++){
                char c = charArray[j-1];
                if((i+j)%2==0){
                    if(c=='B') arr[i][j] = 0;
                    else arr[i][j]=1;
                }
                else{
                    if(c=='B')arr[i][j] = 1;
                    else arr[i][j]=0;
                }
            }
        }
        // 누적합
        for(int i =1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }

        //구간별 최소값
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n-k+1; i++){
            for(int j=1; j<=m-k+1; j++){
                int value = arr[i+k-1][j+k-1] - (arr[i-1][j+k-1] + arr[i+k-1][j-1] - arr[i-1][j-1]);
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }
        bw.write(Math.min(min, k*k-max)+"");
        bw.flush();



    }

}