import java.io.*;
import java.util.*;

public class Main {
    static int n,m,t,k;
    static List<int[]>list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int result=0, maxX=0, maxY=0;
        list = new ArrayList();
        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for(int i =0; i<t; i++){
            for(int j=0; j<t; j++){
                int X, Y;
                if(list.get(i)[0]+k > n) X = n-k;
                else X = list.get(i)[0];
                if(list.get(j)[1]+k > m) Y = m-k;
                else Y = list.get(j)[1];
                int findAnswer = find(X,Y);
                if(findAnswer > result){
                    result = findAnswer;
                    maxX = X;
                    maxY = Y;
                }
            }
        }
        System.out.println(maxX+" " + (maxY+k));
        System.out.println(result);

    }
    static int find(int X, int Y){
        int count=0;
        for(int node[]: list){
            if(node[0]>=X && node[0]<=X+k && node[1]>=Y && node[1]<=Y+k){
                count++;
            }
        }
        return count;
    }
}

