import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int [n][];

        for(int i =0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = n-2; i>=0; i--){
            for(int j =0; j<arr[i].length;j++){
                arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
            }
        }

        System.out.print(arr[0][0]);

    }


}
