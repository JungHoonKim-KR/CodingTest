import java.util.*;
import java.io.*;

public class Main {
    static int globalIndex = 0;
    static Map<Integer, int[]> tree = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            list.add(Integer.parseInt(input));
        }
        root = list.get(0);
        buildOrder(Integer.MAX_VALUE, root);
        postOrder(root);
        System.out.println(sb);

    }

    static void buildOrder(int parent, int cur) {
        tree.putIfAbsent(cur, new int[2]);

        if (globalIndex + 1 < list.size() && list.get(globalIndex + 1) < cur) {
            int left = list.get(++globalIndex);
            tree.get(cur)[0] = left;
            buildOrder(cur, left);

        }
        if (globalIndex + 1 < list.size() && list.get(globalIndex + 1) > cur && list.get(globalIndex + 1) < parent) {
            int right = list.get(++globalIndex);
            tree.get(cur)[1] = right;
            buildOrder(parent, right);
        }

    }

    static void postOrder(int n) {
        if (tree.get(n)[0] != 0)
            postOrder(tree.get(n)[0]);
        if (tree.get(n)[1] != 0)
            postOrder(tree.get(n)[1]);
        sb.append(n + " ");
    }
}
