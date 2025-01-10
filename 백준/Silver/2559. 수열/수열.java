import java.io.*;
import java.util.*;

public class Main {
    static class Bit{
        int arr[];
        Bit(int size){
            arr = new int[size+1];
        }

        void update(int index, int value){
            while(index < arr.length){
                arr[index] += value;
                index += index & -index;
            }
        }

        int sum(int index){
            int sum=0;
            while(index >0){
                sum+=arr[index];
                index -= index& -index;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Bit bit = new Bit(n);
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            bit.update(i+1,Integer.parseInt(st.nextToken()));
        }
        int max = Integer.MIN_VALUE;
        for(int i =1; i<=n-k+1; i++){
            max = Math.max(max, bit.sum(i-1 +k) - bit.sum(i-1));
        }
        System.out.println(max);
    }

}