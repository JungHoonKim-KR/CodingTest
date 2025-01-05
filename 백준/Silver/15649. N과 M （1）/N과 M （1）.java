import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {
    static int N;
    static int M;
    static int arr[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문제 받기
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visit=new boolean[N];
        arr=new int [M];
        dfs(0);


        }
        public static void dfs(int dep){
            if(dep==M){
                for(int value:arr){
                    System.out.print(value+" ");
                }
                System.out.println();
                return;
            }
            for(int i=0;i<N;i++){
                if(!visit[i])
                {
                    visit[i]=true;
                    arr[dep]=i+1;
                    dfs(dep+1);
                    visit[i]=false;
                }
            }
        }
    }




























