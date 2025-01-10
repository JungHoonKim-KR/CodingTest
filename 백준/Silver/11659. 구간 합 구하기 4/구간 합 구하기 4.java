import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum[] = new int [n];
        sum[0] = arr[0];
        for(int i =1; i<n; i++){
            sum[i] = sum[i-1] + arr[i];
        }


        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            bw.write(sectorSum(sum, arr, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1)+ "\n");
        }

        bw.flush();
    }

    static int sectorSum(int sum[],int arr[],  int i, int j){
        return sum[j] - sum[i] + arr[i];
    }

}