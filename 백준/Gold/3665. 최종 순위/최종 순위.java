import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            List<Integer> graph[] = new LinkedList[n+1];
            for(int i =1; i<=n; i++){
                graph[i] = new LinkedList<>();
            }

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int [] indegree = new int[n+1];
            for(int i =0; i<n; i++){
                for(int j = i+1; j<n; j++){
                    graph[input[i]].add(input[j]);
                }
                indegree[input[i]]=i;
            }

            int m = Integer.parseInt(br.readLine());

            for(int i =0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                // a가 b를 포함한다?
                if(graph[first].contains(second)){
                    graph[first].remove((Integer)second);
                    graph[second].add(first);

                    indegree[first]++;
                    indegree[second]--;
                }
                else{
                    graph[second].remove((Integer)first);
                    graph[first].add(second);

                    indegree[second]++;
                    indegree[first]--;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; i++){
                if(indegree[i]==0)
                    q.add(i);
            }

            while(!q.isEmpty()){
                int cur = q.poll();
                sb.append(cur+" ");
                for(int data : graph[cur]){
                    if(--indegree[data]==0)
                        q.add(data);
                }

            }
            boolean isTrue=true;
            for(int data : indegree){
                if(data != 0){
                    isTrue = false;
                    break;
                }
            }

            if(isTrue){
                result.append(sb).append("\n");
            }
            else result.append("IMPOSSIBLE\n");

        }

        System.out.println(result);
    }


}