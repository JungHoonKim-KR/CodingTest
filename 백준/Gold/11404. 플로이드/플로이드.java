import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, weight;

        Node(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        long INF = Long.MAX_VALUE /2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        long dist[][] = new long[v+1][v+1];
        for(int i =1; i<=v; i++){
            Arrays.fill(dist[i],INF);
            dist[i][i] =0;
        }

        for(int i = 0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to], w);
        }

        for(int k = 1 ; k<=v; k++){
            for(int i = 1; i<=v; i++){
                for(int j =1; j<=v; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j],dist[i][j]);
                    }
                }
            }
        }

        for(int i =1; i<=v; i++){
            for(int j =1; j<=v; j++){
                if(dist[i][j] == INF){
                    sb.append(0+" ");
                }
                else sb.append(dist[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


}
