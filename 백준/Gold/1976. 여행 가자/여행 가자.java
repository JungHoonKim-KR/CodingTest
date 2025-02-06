import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m  = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        StringTokenizer st;
        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int init=0;
        for(int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(init == 0){
                init = find(temp);
            }
            else if(init != find(temp)){
                System.out.println("NO");
                System.exit(0);
            }

        }

        System.out.println("YES");



    }

    static void union(int a, int b){
        int A = find(a);
        int B = find(b);

        if(A!=B){
            if(A<B)
                parent[A] = B;
            else parent[B] = A;
        }
    }
    static int find(int a){
        if(parent[a]==a)
            return a;
        else return parent[a] = find(parent[a]);
    }

}