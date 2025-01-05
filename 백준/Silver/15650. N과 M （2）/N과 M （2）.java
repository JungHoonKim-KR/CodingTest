import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr [] = new int[m];
        divide(arr, 0, n, m, 0);

        bw.flush();

    }

    static void divide(int arr[], int depth, int n, int m , int cur){
        if(depth == m){
            for(int num : arr){
                System.out.print(num +" ");
            }
            System.out.println();
            return;
        }

        for(int i =1; i<=n; i++){
            if(i > cur){
                arr[depth] = i;
                divide(arr, depth+1, n, m, i);
            }
        }
    }


}