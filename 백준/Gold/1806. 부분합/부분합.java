import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start=0, end=0;
        int min = Integer.MAX_VALUE;
        long sum =arr[end];
        while(true){

            if(sum >= s){
                min = Math.min(min, end - start+1);
                sum -= arr[start++];
            }
            else if(end== n)
                break;
            else {
                sum += arr[++end];
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }



}

