import java.io.*;
import java.util.*;

class G{
    int vertexNum;
    List<Integer>[] adjList;
    List<Integer>[] transPosedAdjList;

    G(int m){
        vertexNum = m;
        adjList = new List[vertexNum];
        transPosedAdjList = new List[vertexNum];
        for(int i = 0; i< vertexNum; i++){
            adjList[i]=new ArrayList<>();
            transPosedAdjList[i]=new ArrayList<>();
        }
    }

    public void addEdge(int from , int to){
        adjList[from].add(to);
    }

    public void fillFinishNum(int v, boolean[] isVisit,Stack<Integer>stack){
        isVisit[v] = true;
        for(int vertex : adjList[v]){
            if(!isVisit[vertex])
                fillFinishNum(vertex,isVisit,stack);
        }
        stack.push(v);
    }
    public void dfs(int v, boolean[] isVisit,ArrayList<Integer>components){
        isVisit[v]=true;
        components.add(v);
        for(int vertex: transPosedAdjList[v]){
            if(!isVisit[vertex])
                dfs(vertex,isVisit,components);
        }
    }

    public ArrayList<ArrayList<Integer>> findScc(){
        Stack<Integer> stack = new Stack<>();
        boolean [] isVisit = new boolean[vertexNum];
        for(int i = 0; i<vertexNum; i++){
            if(!isVisit[i])
                fillFinishNum(i,isVisit,stack);
        }
        for(int i =0; i<vertexNum; i ++){
            for(int to:adjList[i]){
                transPosedAdjList[to].add(i);
            }
        }
        ArrayList<ArrayList<Integer>>scc = new ArrayList<>();
        Arrays.fill(isVisit,false);
        while(!stack.empty()){
            Integer vertex = stack.pop();
            if(!isVisit[vertex]){
                ArrayList<Integer> components = new ArrayList<>();
                dfs(vertex,isVisit,components);
                scc.add(components);
            }

        }
        return scc;
    }
}
public class scc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("scc.inp"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("scc.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        G g = new G(m);
        for(int tc = 0; tc< n ; tc++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g.addEdge(from,to);
        }
        ArrayList<ArrayList<Integer>> result = g.findScc();
        bw.write(result.size()+"\n");
        bw.close();

    }
}
