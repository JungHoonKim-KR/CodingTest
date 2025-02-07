import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i =0; i<n; i++){
            parent[i]= i;
        }

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                System.out.println(i+1);
                System.exit(0);
            }
            else union(a,b);
        }
        System.out.println(0);
    }

    static void union(int a, int b){
        int A = find(a);
        int B = find(b);


        if(A<B){
            parent[B] = A;
        }
        else parent[A] = B;
    }
    static int find(int a){
        if(parent[a] == a)
            return a;
        else return parent[a] = find(parent[a]);
    }
}
