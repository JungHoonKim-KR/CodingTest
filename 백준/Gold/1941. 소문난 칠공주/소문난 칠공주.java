import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static boolean[][] isMember;
    static int N = 5, result;
    static int[][] go = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];
        isMember = new boolean[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        subset(0,0,0);
        System.out.println(result);
    }

    static void subset(int depth,int start, int countY){
        if(countY >=4){
            return;
        }

        if(depth == 7){
            int r = (start -1)/N;
            int c = (start - 1)%N;
            if(check(r,c,new boolean[N][N]) == 7){
                result++;
            }
            return;
        }
        for(int i = start; i<N*N; i++){
            int r = i/N;
            int c = i%N;

            isMember[r][c] = true;
            subset(depth+1,i+1,countY+ (map[r][c] == 'Y' ? 1 : 0));
            isMember[r][c] = false;
        }

    }
    static int check(int startX, int startY, boolean[][] visit){
        visit[startX][startY] = true;
        int count = 1;
        for(int i = 0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];

            if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N
            || !isMember[moveX][moveY] || visit[moveX][moveY])
                continue;
            count += check(moveX, moveY, visit);
        }
        return count;
    }
}