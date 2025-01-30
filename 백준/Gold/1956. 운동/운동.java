import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        long dist[][] = new long [v+1][v+1];

        for(int i = 1; i<=v; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i =0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[from][to] = w;
        }

        for(int k =1; k<=v; k++){
            for(int i =1; i<=v; i++){
                for(int j =1; j<=v; j++){
                    if(dist[i][k] != Integer.MAX_VALUE &&  dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        long min = Integer.MAX_VALUE;
        for(int i = 1; i<=v; i++){
            for(int j =1; j<=v; j++){
                if(dist[i][j] != dist[j][i]){
                    min = Math.min(dist[i][j] + dist[j][i], min);
                }
            }
        }


        long result = min == Integer.MAX_VALUE ? -1 : min;

        System.out.print(result);





    }


}
