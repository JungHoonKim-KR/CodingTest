import java.io.*;
import java.util.*;

public class Main {

    static class Tree {
        Map<Character, List<Character>> tree = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        void insert(char parent, char left, char right) {
            tree.put(parent, Arrays.asList(left, right));
        }

        void preOrder(char node) {
            if (node == '.' || node == 0) return;
            sb.append(node); // 현재 노드 출력
            List<Character> children = tree.get(node);
            preOrder(children.get(0)); // 왼쪽 자식
            preOrder(children.get(1)); // 오른쪽 자식
        }

        void inOrder(char node) {
            if (node == '.' || node == 0) return;
            List<Character> children = tree.get(node);
            inOrder(children.get(0)); // 왼쪽 자식
            sb.append(node); // 현재 노드 출력
            inOrder(children.get(1)); // 오른쪽 자식
        }

        void postOrder(char node) {
            if (node == '.' || node == 0) return;
            List<Character> children = tree.get(node);
            postOrder(children.get(0)); // 왼쪽 자식
            postOrder(children.get(1)); // 오른쪽 자식
            sb.append(node); // 현재 노드 출력
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.insert(parent, left, right);
        }

        // PreOrder 순회
        tree.preOrder('A');
        bw.write(tree.sb.toString() + "\n");
        tree.sb.setLength(0);

        // InOrder 순회
        tree.inOrder('A');
        bw.write(tree.sb.toString() + "\n");
        tree.sb.setLength(0);

        // PostOrder 순회
        tree.postOrder('A');
        bw.write(tree.sb.toString() + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
