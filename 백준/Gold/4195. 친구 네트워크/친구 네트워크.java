import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> size = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            parent.clear();
            size.clear();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                String m1 = st.nextToken();
                String m2 = st.nextToken();

                bw.write(union(m1, m2) + "\n");
            }
        }

        bw.flush();
    }

    static int union(String a, String b) {
        String A = find(a);
        String B = find(b);

        if(A == null){
            parent.put(a,a);
            size.put(a,1);
            A = a;
        }
        if(B == null){
            parent.put(b,b);
            size.put(b,1);
            B = b;
        }

        if (!A.equals(B)) {
            if (size.get(A) >= size.get(B)) {
                parent.put(B, A);
                size.put(A, size.get(B) + size.get(A));
                return size.get(A);
            } else {
                parent.put(A, B);
                size.put(B, size.get(B) + size.get(A));
                return size.get(B);
            }
        }
        // 조상이 같다
        return size.get(A);
    }

    static String find(String a) {
        if (!size.containsKey(a))
            return null;
        if (parent.get(a).equals(a)) {
            return a;
        } else {
            String root = find(parent.get(a));
            parent.put(a,root);
            return root;
        }
    }

}