import java.io.*;
import java.util.*;

public class Main {
    static long a=0;
    static long c=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int [n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int brr [][] = new int[m][k];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<k; j++){
                brr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int crr[][] = new int[n][k];
        for(int i=0;i<n; i++){
            for(int j=0; j<k; j++){
                int temp=0;
                for(int l = 0; l<m; l++){
                    temp += arr[i][l] * brr[l][j];
                }
                crr[i][j] = temp;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<k; j++){
                bw.write(crr[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
    }


}