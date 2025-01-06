import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[][];
    static int n;
    static boolean visit[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int j = 1; j <= n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1);
        bw.write(min+"");
        bw.flush();
    }

    static void dfs(int depth, int value) {
        int team1=0, team2=0;
        if(depth >= n/2){
            for(int j=1; j<n; j++){
                for(int i=j+1; i<=n; i++){
                    if(visit[i] && visit[j]){
                        team1 += arr[i][j] + arr[j][i];
                    }
                    else if(!visit[i] && !visit[j]){
                        team2 += arr[i][j] + arr[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(team1 - team2));
            return;
        }

        for(int i = value; i<=n; i++){
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }



    }





}
