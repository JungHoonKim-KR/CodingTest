import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int []b=new int [n];
        int count=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            b[i]=arr[i];
        }

        Arrays.sort(b);
        HashMap<Integer,Integer>rank=new HashMap<Integer,Integer>();
        StringBuilder sb = new StringBuilder();
        for(int j:b){
            if(!rank.containsKey(j)) {
                rank.put(j, count);
                count++;
            }
        }
        for(int k:arr){
            sb.append(rank.get(k)+" ");
        }

        System.out.println(sb);


    }
}










