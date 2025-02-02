import java.io.*;
import java.util.*;

public class Main {
    static class Item{
        int g, v;
        Item(int g, int v){
            this.g = g;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        Item list[] =new Item[n+1];
        list[0] = new Item(0,0);
        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(list, (i1, i2)->{
            return Integer.compare(i1.g, i2.g);
        });
        int dp[][] = new int[n+1][g+1];
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=g; j++){
                Item cur = list[i];
                if(cur.g <= j){
                    dp[i][j] = Math.max(cur.v,Math.max(dp[i-1][j], dp[i-1][j-cur.g]+cur.v));
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.print(dp[n][g]);

    }



}
