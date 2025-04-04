import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int goX[] = {-1, -2, -1,-2,1,2,1,2};
    static int goY[] = {-2,-1,2,1,-2,-1,2,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int tc = Integer.parseInt(br.readLine());

        while (tc--> 0) {
            //입력
            int n = Integer.parseInt(br.readLine());
            int visit[][] = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Queue<int[]>queue = new LinkedList<>();
            queue.add(new int[]{x1,y1});

            while(!queue.isEmpty()){
                int []cur = queue.poll();
                if(cur[0] == x2 && cur[1] == y2){
                    break;
                }

                    for(int i =0; i<8; i++){
                        int moveX = cur[0]+goX[i];
                        int moveY = cur[1] + goY[i];
                        if(moveX<0 || moveX>=n || moveY<0 || moveY>=n || visit[moveX][moveY]!=0){
                            continue;
                        }
                        visit[moveX][moveY] = visit[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{moveX,moveY});
                    }
                }
            sb.append(visit[x2][y2]+"\n");

            }
        System.out.println(sb);

    }


}