import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Bit {
        long[] tree;

        Bit(int size) {
            tree = new long[size + 1];
        }

        void update(int index, int value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long sum(int index) {
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int testcase = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        Bit bit = new Bit(n);
        for (int tc = 0; tc < n; tc++) {
            bit.update(tc + 1, Integer.parseInt(st.nextToken()));
        }
        for(int tc = 0; tc<testcase;tc++){
            st = new StringTokenizer(bufferedReader.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            bufferedWriter.write(bit.sum(lastIndex) - bit.sum(firstIndex-1)+"\n");
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}