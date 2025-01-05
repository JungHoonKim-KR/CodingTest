import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

    static int N;
    static int[][] score;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        score=new int [N][N];
        visit=new boolean[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                score[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(Min);

    }
    public static void dfs(int index,int start){
        if(index==N/2){
            Min=Math.min(Min,Team());
            return;
        }
        for(int i=start;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                dfs(index+1,i+1);
                visit[i]=false;
            }
        }

    }
    public static int Team(){
        int value1=0;
        int value2=0;
        for(int i=0;i<N;i++)
            for(int j=i+1;j<N;j++){
                if(visit[i]==true && visit[j]==true)
                value1+=(score[i][j]+score[j][i]);
                else if(visit[i]==false && visit[j]==false)
                value2+=(score[j][i]+score[i][j]);
        }
        return Math.abs(value1-value2);
    }

}