import java.io.*;
import java.util.*;

public class Main {
    static class Bit{
        int tree[];
        Bit(int size){
            tree = new int[size+1];
        }

        void update(int index, int value){
            while(index < tree.length){
                tree[index] += value;
                index += index & - index;
            }
        }

        int sum(int index){
            int sum=0;
            while(index >0){
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Bit bit = new Bit(n);
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            bit.update(i+1,  Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            bw.write(bit.sum(second) - bit.sum(first-1)+"\n");
        }
        bw.flush();
    }

}