import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {
    static int N;
    static int M;
    static int arr[];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제 받기
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int [M];
        dfs(0);
        System.out.println(sb);
        }
        public static void dfs(int dep){
            if(dep==M){
                for(int value:arr){
                    sb.append(value+" ");
                }
                sb.append("\n");
                return;
            }
            for(int i=0;i<N;i++){
                    arr[dep]=i+1;
                    dfs(dep+1);

            }
        }
    }





























