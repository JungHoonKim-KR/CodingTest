import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        find(arr);
        bw.write(max+"");
        bw.flush();
    }

    static void find(int arr[]){

        int value=0;
        for(int i =0; i<arr.length;i++){
            if(value + arr[i]>0){
                value+=arr[i];
                max = Math.max(max,value);

            }
            else {
                max = Math.max(max,arr[i]);
                value=0;
            }


        }
    }


}
