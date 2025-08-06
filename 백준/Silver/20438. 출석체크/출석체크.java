import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[3+n];
        Arrays.fill(arr, 1);
        arr[2] = 0;
        Set<Integer> set = new HashSet<>();
        st =new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        st =new StringTokenizer(br.readLine());
        for(int i = 0; i<q; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num))
                continue;

            for(int j=num; j<=n+2; j+=num){
                  if(set.contains(j))
                      continue;
                  arr[j] = 0;
            }
        }

        for(int i = 4; i<=n+2; i++){
            arr[i] += arr[i-1];
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end] - arr[start-1]+"\n");
        }
        System.out.println(sb);
    }


}


