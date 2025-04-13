import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int from;
        int to;
        int weight;
        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>graph = new ArrayList();
        long dist[] =new long[n+1];

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            graph.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for(int i =0; i<n-1; i++){
            for(Node node : graph){
                if(dist[node.from] != Integer.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight){
                    dist[node.to] = dist[node.from] + node.weight;
                }
            }
        }

        boolean can = true;
        for(Node node : graph){
            if(dist[node.from] != Integer.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight){
                System.out.println(-1);
                can = false;
                break;
            }
        }
        if(can){
            for(int i =2; i<=n; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    sb.append(-1+"\n");
                }
                else sb.append(dist[i]).append("\n");
            }
            System.out.println(sb);
        }

    }




}