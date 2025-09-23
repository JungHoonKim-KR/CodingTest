
import java.io.*;
import java.util.*;


public class Main {
    static int N, M, inventory, time= Integer.MAX_VALUE, height = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inventory = Integer.parseInt(st.nextToken());
        arr = new int[N * M];
        int index = 0;
        for(int i =  0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[index++] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);

        for(int i  =0; i<= 256; i++){
            flat(i);
        }
        System.out.println(time+" "+ height);
    }
    static void flat(int value){
        // 역순으로 조회
        int t = 0;
        int inven = inventory;
        for(int i = N*M-1; i>=0; i--){
            if(arr[i] > value){
                int sub = arr[i] - value;
                t += 2*sub;
                inven += sub;
            }
            else if(arr[i] < value){
                int sub = value - arr[i];
                if(inven < sub)
                    return;
                t += sub;
                inven -= sub;
            }
        }

        if(time == t){
            height = Math.max(height, value);
        }
        else if(time > t){
            time = t;
            height = value;
        }
    }
}



