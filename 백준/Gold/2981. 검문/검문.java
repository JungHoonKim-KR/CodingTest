import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제 받기
        int t = Integer.parseInt(br.readLine());
        int arr[]=new int[t];

        for(int i=0;i<t;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        //해결
        Arrays.sort(arr);
        int n=arr[1]-arr[0];
        for(int j=2;j<t;j++){
            n=gcd(n,arr[j]-arr[j-1]);

        }
        //출력
        StringBuilder sb=new StringBuilder();
        for(int k=2;k<=n;k++){
            if(n%k==0)
                sb.append(k+" ");
        }
        System.out.println(sb);
    }

    public static int gcd(int a,int b){
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        while(max%min!=0){
            int r=max%min;
            max=min;
            min=r;

        }
        return min;
    }

    }





















