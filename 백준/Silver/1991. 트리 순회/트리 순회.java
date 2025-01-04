import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Node {
    char value;
    Node left, right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;

    }
}
 class Tree {
    Node root = new Node('A', null, null);
    StringBuilder sb = new StringBuilder();
    void Insert(Node tmp, char target, char left, char right) {
        if (tmp == null) return;

        if (root.value == target) {
            root.left = (left == '.' ? null : new Node(left, null, null));
            root.right = (right == '.' ? null : new Node(right, null, null));
        } else if (target == tmp.value) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            Insert(tmp.left, target, left, right);
            Insert(tmp.right, target, left, right);
        }
    }
    void PreOrder(Node root){
        if (root == null) return;
        sb.append(root.value);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    void PostOrder(Node root){
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        sb.append(root.value);

    }

    void InOrder(Node root){
        if (root == null) return;
        InOrder(root.left);
        sb.append(root.value);
        InOrder(root.right);
    }
}


public class Main {


    StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.Insert(tree.root,target, left, right);
        }

        tree.PreOrder(tree.root);
        bw.write(tree.sb.toString()+"\n");
        tree.sb.setLength(0);
        tree.InOrder(tree.root);
        bw.write(tree.sb.toString()+"\n");
        tree.sb.setLength(0);
        tree.PostOrder(tree.root);
        bw.write(tree.sb.toString()+"\n");

        bw.flush();
        br.close();  // 입력 스트림 닫기
        bw.close();  // 출력 스트림 닫기

    }


}


