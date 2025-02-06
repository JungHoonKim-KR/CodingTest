import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent= new int[n+1];

        for(int i =1; i<=n; i++){
            parent[i] = i;
        }

        // 입력과 동시에 동작
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0)
                union(a,b);
            else{
                if(find(a) == find(b))
                    bw.write("YES\n");
                else bw.write("NO\n");
            }

        }



        bw.flush();
        br.close();
        bw.close();
    }

    static void union(int a, int b){
        int A = find(a);
        int B = find(b);

        if(A>B)
            parent[B] = A;
        else parent[A] = B;
    }

    static int find(int a ){
        if(parent[a] == a)
            return a;
        else return parent[a] = find(parent[a]);
    }

}