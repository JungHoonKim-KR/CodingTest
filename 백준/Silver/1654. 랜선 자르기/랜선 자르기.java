import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int [n];
        long high =0;
        for(int i =0; i<n; i++){
            int l = Integer.parseInt(br.readLine());
            arr[i] =l;
            high = Math.max(high, l);
        }

        long low = 0;
        // upperBound는 target값의 최대 index+1에 위치하기 때문에 만약 모든 랜샌의 길이가 같다면 
        // +1 index에 위치할 자리가 필요하기 때문에 max++이 필요하다
        high++;
        while(low < high){
            long mid = (low + high)/2;
            long count=0;
            for(int a : arr){
                count += a/mid;
            }

            if(count < k){
                high = mid;
            }
            else low = mid+1;
        }


        System.out.println(low-1);


    }





}