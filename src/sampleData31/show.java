import java.io.*;
import java.util.*;


public class show {
    private static class TwoSat{
        int n ;
        boolean [] visited;
        List<Integer>[] graph, reversedGraph;
        Stack<Integer> stack;
        int [] scc;
        int sccCount;

        TwoSat(int n){
            this.n = n;
            graph = new ArrayList[2*n];
            reversedGraph = new ArrayList[2*n];
            for(int i =0; i<2*n; i++){
                graph[i] = new ArrayList<>();
                reversedGraph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int var1, int var2){
            int u = convertSign(var1);
            int v = convertSign(var2);

            graph[negate(u)].add(v);
            graph[negate(v)].add(u);

            reversedGraph[v].add(negate(u));
            reversedGraph[u].add(negate(v));
        }

        private int convertSign(int var){
            return var>0? 2*(var-1): 2*(-var-1)+1;
        }

        private int negate(int var){
            return var%2==0? var+1 : var-1;
        }

        public int solve(){
            stack = new Stack<>();
            visited = new boolean[2*n];

            for(int i =0; i<2*n; i++){
                if(!visited[i]){
                    dfs1(i);
                }
            }
            Arrays.fill(visited,false);
            scc = new int[2*n];
            sccCount=0;
            while(!stack.isEmpty()){
                int u = stack.pop();
                if(!visited[u]){
                    dfs2(u, sccCount++);
                }
            }
            for(int i =0; i<n;i++){
                if(scc[2*i] == scc[2*i+1]) return 0;
            }
            return 1;
        }

        private void dfs1(int i) {
            visited[i] = true;
            for(int u:graph[i]){
                if(!visited[u]){
                    dfs1(u);
                }
            }
            stack.push(i);
        }
        private void dfs2(int u, int label) {
            visited[u]= true;
            scc[u] = label;
            for(int v:reversedGraph[u]){
                if(!visited[v]){
                    dfs2(v,label);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(bufferedReader.readLine());
        int variableNum = Integer.parseInt(st.nextToken());
        int clauseNum = Integer.parseInt(st.nextToken());
        TwoSat twoSat = new TwoSat(variableNum);
        for(int tc = 0; tc<clauseNum; tc++){
            st = new StringTokenizer(bufferedReader.readLine());
            twoSat.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        bufferedWriter.write(twoSat.solve()+"");
        bufferedWriter.close();
    }
}
