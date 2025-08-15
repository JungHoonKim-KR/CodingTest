import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m, result = Integer.MAX_VALUE;
    static ArrayList<int[]> homeList = new ArrayList<>();
    static ArrayList<int[]>chickenList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input ==1){
                    homeList.add(new int[]{i,j});
                }
                else if(input ==2){
                    chickenList.add(new int[]{i,j});
                }
            }
        }
        dfs(0,0,new int[m][2]);
        System.out.println(result);

    }
    static void dfs(int depth, int start, int[][] select){
        if(depth == m){
            int sum = 0;
            for(int i =0; i< homeList.size(); i++){
                int minDist = Integer.MAX_VALUE;
                for(int j=0; j<m;j++){
                    minDist = Math.min(minDist, Math.abs(homeList.get(i)[0] - select[j][0])
                            + Math.abs(homeList.get(i)[1] - select[j][1]));
                }
                sum += minDist;
            }
            result = Math.min(sum,result);
            return;

        }

        for(int i = start; i< chickenList.size(); i++){
            select[depth][0] = chickenList.get(i)[0];
            select[depth][1] = chickenList.get(i)[1];
            dfs(depth+1, i+1, select);
        }
    }
}
