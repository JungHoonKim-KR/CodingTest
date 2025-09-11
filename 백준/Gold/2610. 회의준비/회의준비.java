import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[] parent;
    static List<Integer>[] adj;
    static Map<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 초기화
        parent = new int[N+1];
        adj = new List[N+1];

        for(int i = 1; i<=N; i++){
            parent[i] = i;
            adj[i] = new LinkedList<>();
        }
        // 입력
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);

            union(a,b);
        }

        // 팀에 누가 소속되어 있는지 저장
        map = new HashMap<>();
        for(int i = 1; i<=N; i++){
            map.computeIfAbsent(find(parent[i]), k -> new ArrayList()).add(i);
        }

        // 만들어진 팀 순서대로 돌아가며 리더 찾기
        List<Integer>leaderList = new ArrayList<>();
        for(List<Integer>group : map.values()){
            int leader = -1;
            int MIN = Integer.MAX_VALUE;

            // 거리 계산
            for(int member : group){
                int[] distances = bfs(member);
                int max = Arrays.stream(distances).max().getAsInt();

                if(MIN > max){
                    MIN = max;
                    leader = member;
                }
                if(MIN == max){
                    leader = Math.min(leader, member);
                }
            }
            leaderList.add(leader);
        }
        // 오른차순으로 출력
        Collections.sort(leaderList);
        
        sb.append(leaderList.size()).append("\n");
        for(int leader : leaderList){
            sb.append(leader).append("\n");
        }
        System.out.println(sb);
    }
    static int[] bfs(int i){
        int[] distances = new int[N+1];
        Arrays.fill(distances, -1);
        distances[i] = 0;
        Queue<Integer>q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : adj[cur]){
                if(distances[next] == -1){
                    distances[next] = distances[cur] + 1;
                    q.add(next);
                }
            }
        }
        return distances;
    }

    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB)
            parent[rootB] = rootA;
    }


}