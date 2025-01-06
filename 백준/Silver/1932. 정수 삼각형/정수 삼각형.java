import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {
    static int arr[][];
    static Integer DP[][];
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        arr=new int [t][t];
        DP=new Integer[t][t];
        StringTokenizer st;
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0;k<t;k++){
            DP[t-1][k]=arr[t-1][k];

        }
        System.out.println(recur(0,0));











    }
    public static int recur(int N,int index){
       // if(N==t-1)return DP[N][index];
        if(DP[N][index]==null){
            DP[N][index]=Math.max(recur(N+1,index),recur(N+1,index+1))+arr[N][index];

        }
        return DP[N][index];

    }

}